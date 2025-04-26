package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

import java.util.HashMap;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage(null, null, null);
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            var title = ctx.formParam("title");
            var content = ctx.formParam("content");
            var errors = new HashMap<String, List<ValidationError<Object>>>();

            try {
                if (title == null || title.length() < 2) {
                    errors.put("title", List.of(new ValidationError<>("Статья не должна быть короче двух символов")));
                }

                if (content == null || content.length() < 10) {
                    errors.put("content", List.of(new ValidationError<>("Статья должна быть не короче 10 символов")));
                }

                if (ArticleRepository.existsByTitle(title)) {
                    errors.put("title", List.of(new ValidationError<>("Статья с таким названием уже существует")));
                }

                if (!errors.isEmpty()) {
                    throw new ValidationException(errors);
                }

                Article article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/article");

            } catch (ValidationException e) {
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.status(422);
                ctx.render("/article/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

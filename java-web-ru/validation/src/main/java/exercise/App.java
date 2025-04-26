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
            try {
                var title = ctx.formParamAsClass("title", String.class)
                        .check(x -> x.length() > 2, "Название не должно быть короче двух символов")
                        .check(stt -> !ArticleRepository.existsByTitle(stt), "Статья с таким названием уже существует")
                        .get();
                var content = ctx.formParamAsClass("content", String.class)
                        .check(x -> x.length() > 10, "Статья должна быть не короче 10 символов")
                        .get();
                var artic = new Article(title, content);
                ArticleRepository.save(artic);
                ctx.redirect("/articles");

            } catch (ValidationException e) {
                var title = ctx.formParam("title");
                var content = ctx.formParam("content");
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.render("articles/build.jte", model("page", page)).status(422);
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

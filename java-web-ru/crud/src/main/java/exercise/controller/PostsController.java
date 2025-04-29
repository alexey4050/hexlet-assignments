package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            Post post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.status(404);
            ctx.result(String.valueOf(e));
        }
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.getEntities();
        var totalPages = (int) Math.ceil((double) posts.size() / 5);
        posts = PostRepository.findAll(pageNumber, 5);
        var page = new PostsPage(posts, pageNumber, totalPages);
        ctx.render("posts/index.jte", model("page", page));
    }
    // END
}

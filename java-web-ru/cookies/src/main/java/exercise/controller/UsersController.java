package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        if (StringUtils.isAnyBlank(firstName, lastName, email, password)) {
            ctx.status(422).result("Все поля обязательны для заполнения");
            return;
        }

        var token = Security.generateToken();
        var encryptedPassword = Security.encrypt(password);
        var user = new User(firstName, lastName, email, encryptedPassword, token);
        UserRepository.save(user);

        ctx.cookie("user_token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var token = ctx.cookie("user_token");
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Пользователь не найден"));

        if (!user.getToken().equals(token)) {
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }

        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    // END
}

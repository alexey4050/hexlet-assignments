package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            String pageParam = ctx.queryParam("page");
            String perParam = ctx.queryParam("per");

            int page = (pageParam == null) ? 1 : Integer.parseInt(pageParam);
            int per = (perParam == null) ? 5 : Integer.parseInt(perParam);

            int fromIndex = (page - 1) * per;
            int toINdex = Math.min(fromIndex + per, USERS.size());

            if (fromIndex >= USERS.size() || fromIndex < 0) {
                ctx.status(404).result("Page not found");
                return;
            }

            List<Map<String, String>> userPage = USERS.subList(fromIndex, toINdex);
            ctx.json(userPage);
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

package com.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.HashMap;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create(config ->{
            config.staticFiles.add("/public", Location.CLASSPATH);
        });

        app.before(ctx -> {
            System.out.println("Matched path: " + ctx.matchedPath());
        });

        app.get("/json", ctx -> {
            HashMap map = new HashMap<>();
            map.put("message", "Hello");
            ctx.json(map);
        });
        
        app.get("/html", ctx ->{
            ctx.html("<h1>Welcome to Javalin 3BSY!</h1><p>This is an HTML response :)</p>");
        });

        app.post("/echo", ctx -> {
            String requestBody = ctx.body();
            ctx.result("Echoed back: " + requestBody);
        });

        app.after(ctx -> {
            String sessionId = ctx.req().getSession().getId();
            System.out.println("User session ID: " + sessionId);
        });

        app.start(7070);
    }
}

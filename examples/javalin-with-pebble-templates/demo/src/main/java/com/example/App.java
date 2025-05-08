package com.example;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinPebble;

public class App {
    public static void main(String[] args) throws IOException {
        PebbleEngine engine = new PebbleEngine.Builder().loader(new ClasspathLoader()).build();
        PebbleTemplate compiledTemplate = engine.getTemplate("templates/pebble/home.peb");
        Writer writer = new StringWriter();

    Map<String, Object> context = new HashMap<>();
    context.put("websiteTitle", "My First Website");
    context.put("content", "My Interesting Content");

    compiledTemplate.evaluate(writer, context);

    String output = writer.toString();
    System.out.println(output);

    Javalin app = Javalin.create(config -> {
    config.fileRenderer(new JavalinPebble(engine));
    });
        app.get("/", ctx -> {
            ctx.redirect("/pebble");
        });
                
        app.get("/pebble", ctx -> {
            ctx.render("templates/pebble/home.peb",context);
        });
        app.start(9090);
    }
}

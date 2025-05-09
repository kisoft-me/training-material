package com.example;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        // Create the Guice injector with the HelloWorldModule
        Injector injector = Guice.createInjector(new HelloWorldModule());

        // Get an instance of HelloWorldService and call sayHello()
        HelloWorldService helloWorldService = injector.getInstance(HelloWorldService.class);
        helloWorldService.sayHello();
    }
}

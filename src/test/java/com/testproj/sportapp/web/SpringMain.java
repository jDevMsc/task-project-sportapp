package com.testproj.sportapp.web;

import java.util.function.Consumer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {
        execute(() -> System.out.println("Hello execute Test!"));
        consume(System.out::println, "Hello consume Test!");

            }

    private static void execute(Runnable runnable) {
        System.out.println("Start runner");
        runnable.run();
        System.out.println("End runner");
    }

    private static <String> void consume(Consumer<String> consumer, String out) {
        System.out.println("Start consume");
        consumer.accept(out);
        System.out.println("End consume");
        System.out.format("Hello consume Test!");
    }

}

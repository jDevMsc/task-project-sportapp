package com.testproj.sportapp;

import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2019,5,5,5,5);

        System.out.format(dateTime.toString());
    }
}


package com.paraline.common;

import net.datafaker.Faker;

import java.util.Random;


public class DataGenerate {

    static Faker faker = new Faker();

    private DataGenerate() {
        super();
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomCompany() {
        return faker.company().name();
    }

    public static String randomPass() {
        return faker.internet().password();
    }

    public static String randomTitle() {
        return faker.book().title();
    }

    public static String randomText() {
        return faker.lorem().paragraph();
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static String randomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        Random random = new Random();
        int randomIndex = random.nextInt(months.length);
        String randomMonth = months[randomIndex];
        return randomMonth;
    }

}

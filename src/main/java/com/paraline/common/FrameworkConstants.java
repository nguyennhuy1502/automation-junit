package com.paraline.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class FrameworkConstants {

    static final Properties prop = new Properties();
    static {
        try {
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String URL_HOME = prop.getProperty("URL_HOME");
    public static final String URL_LOGIN = prop.getProperty("URL_LOGIN");
    public static final String URL_REGISTER = prop.getProperty("URL_REGISTER");
    public static final String URL_MY_ACCOUNT = prop.getProperty("URL_MY_ACCOUNT");
    public static final String URL_ADD_REVIEW = prop.getProperty("URL_ADD_REVIEW");
    public static final String USERNAME = prop.getProperty("USERNAME");
    public static final String PASSWORD = prop.getProperty("PASSWORD");


}

package com.paraline.common;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class Data {
    public static String getMessageEmailEmpty = "Please enter your email";
    public static String getMessageEmailInvalid = "Wrong email";
    public static String getMessageEmailError = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
    public static String getMessageEmptyPassword = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";
    public static String getMessageEmailEmptyRegister = "Email is required.";
    public static String getMessagePasswordEmptyRegister = "Password is required.";
    public static String getMessageFirstNameEmptyRegister = "First name is required.";
    public static String getMessageLastNameEmptyRegister = "Last name is required.";
    public static String getMessageSuccessRegister = "Your registration completed";
    public static String getMessageErrorValidation = "The specified email already exists";
    public static String getMessagePasswordLessSix = "Password must meet the following rules:\nmust have at least 6 characters";
    public static String getMessageConfirmPassNotPass = "The password and confirmation password do not match.";
    public static String notificationSuccessCustomer = "The customer info has been updated successfully.";
    public static String notificationSuccessUpdate = "The new address has been added successfully.";
    public static String notificationSuccessChangePass = "Password was changed";
    public static String addReviewSuccess = "Product review is successfully added.";
    public static Set<Cookie> cookieValue;
    public static String username;
    public static String password;
}

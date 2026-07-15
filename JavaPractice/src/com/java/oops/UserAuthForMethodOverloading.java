package com.java.oops;

import java.util.regex.Pattern;

class UserAuth {

    public void auth(String email, long password) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValidEmail = Pattern.matches(emailRegex, email);

        String passwordRegex = "^\\d{10}$";
        String passwordStr = String.valueOf(password);
        boolean isPasswordValid = Pattern.matches(passwordRegex, passwordStr);

        if(isValidEmail && isPasswordValid) {
            System.out.println("User Authenticated Using Email And Password");
        } else {
            System.out.println("Invalid User, Not able to authenticated");
        }
    }

    public void auth(long phone, int otp) {
        String phoneRegex = "^\\d{10}$";
        String phoneStr = String.valueOf(phone);
        boolean isPhoneValid = Pattern.matches(phoneRegex, phoneStr);

        String otpRegex = "^\\d{4}$";
        String otpStr = String.valueOf(otp);
        boolean isOtpValid = Pattern.matches(otpRegex, otpStr);

        if(isPhoneValid && isOtpValid) {
            System.out.println("User Authenticated using phone");
        } else {
            System.out.println("Not able to authenticate using phone and otp validation");
        }

    }

    public void auth(String socialId) {
        String socialIdRegex = "^[a-z]+\\d{4}$";
        boolean isSocialIdValid = Pattern.matches(socialIdRegex, socialId);

        if(isSocialIdValid) {
            System.out.println("User Authenticated using social ID");
        } else {
            System.out.println("User not Authenticated using social ID");
        }
    }

}

public class UserAuthForMethodOverloading {

    public static void main(String[] args) {

        UserAuth userAuth = new UserAuth();

        System.out.println("=========================================================");
        System.out.println("USER AUTHENTICATION PROGRAM BASED ON METHOD OVERLOADING");
        System.out.println("=========================================================");
        System.out.println();

        System.out.println("Email & Password based authentication : ");
        userAuth.auth("sam@123.com", 7689045321L);
        System.out.println();

        System.out.println("Phone & OTP based authentication : ");
        userAuth.auth(7608764364L, 5460);
        System.out.println();

        System.out.println("Social ID based authentication : ");
        userAuth.auth("sam1007");
        System.out.println();

        System.out.println("---------------------------------------------------------");


    }
}

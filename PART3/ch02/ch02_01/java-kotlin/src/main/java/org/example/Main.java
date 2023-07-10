package org.example;

import org.example.user.UserModel;

public class Main {
    public static void main(String[] args) {
        var userModel = new UserModel(
            "홍길동", 10, "gmail.com"
        );

        System.out.println(userModel);
    }
}
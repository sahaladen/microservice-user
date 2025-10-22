package com.example.user;

import com.example.user.model.Player;

import java.util.Scanner;

public class Login {

    public Player connect(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("login to your account: ");

        System.out.println("your user name:");
        String userName = scanner.nextLine();

        System.out.println("your user password: ");
        String password = scanner.nextLine();

        Player player = new Player(userName, password);
        System.out.println(player);

        return player;
    }
}

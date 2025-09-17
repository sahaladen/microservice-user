package com.example.user;

import java.util.Scanner;

public class Login {

    public Player connect(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("login to your account: ");

        System.out.println("your user name:\n");
        String userName = scanner.nextLine();

        System.out.println("your user password: ");
        String password = scanner.nextLine();

        Player player = new Player(userName, password);
        System.out.println(player);

        return player;
    }
    private  final Bank bank = new Bank();
    public void connects(){
        boolean check = true;
        System.out.println("login to your account: ");

        System.out.println("your user name:\n");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine().toLowerCase();

        System.out.println("your user password: ");
        Scanner input2 = new Scanner(System.in);
        String password = input2.nextLine().toLowerCase();

        Player player = new Player(userName, password);
        System.out.println(player);


    }

}

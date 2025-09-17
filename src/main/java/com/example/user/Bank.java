package com.example.user;

import java.util.Scanner;

public class Bank {

    private final Scanner scanner = new Scanner(System.in);


    public void deposit(Player player){
        System.out.println("enter amount you want to deposit: ");
        int amount = scanner.nextInt();
        player.setBalance(player.getBalance() + amount);
        System.out.println("deposit succesful. new balance: " + player.getBalance());

    }

    public void withdraw(Player player){
        System.out.println("enter amount t0 withdraw: ");
        int amount = scanner.nextInt();
        if(player.getBalance() >= amount){
            player.setBalance(player.getBalance() - amount);
            System.out.println("withdrawn succesful. new balance: " + player.getBalance());
        }else {
            System.out.println("Insufficient funds.");
        }

    }

}

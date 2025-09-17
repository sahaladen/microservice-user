package com.example.user;

import java.util.Scanner;

public class Program {
    private final Bank bank = new Bank();
    private Player activePlayer;


    public void run(){
        Login login = new Login();
        activePlayer = login.connect();
        meny();
    }
    public void meny(){

        Scanner scanner = new Scanner(System.in);
        boolean check = true;

        while (check){
            System.out.println("press 1 to deposit");
            System.out.println("press 2 to withdraw");
            System.out.println("press 3 to show balance");
            System.out.println("press 4 to quit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    bank.deposit(activePlayer);
                    break;
                case 2:
                    bank.withdraw(activePlayer);
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    System.out.println("goodbye");
                    check = false;
                default:
                    System.out.println("enter a valid input!!!\n");
            }
        }

    }

    public void showBalance(){
        System.out.println("your balance is: " + activePlayer.getBalance());
    }
}

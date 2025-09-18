package com.example.user;

public class PlayerDto {
    private final String userName;
    private final int balance;

    public PlayerDto(Player player) {
        this.userName = player.displayName();
        this.balance = player.getBalance();
    }

    public String getUserName() {
        return userName;
    }

    public int getBalance() {
        return balance;
    }
}

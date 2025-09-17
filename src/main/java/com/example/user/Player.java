package com.example.user;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



public class Player {
    private final String userName;
    private final String password;

    private int balance;


    //todo: legg til en gjest metode for sensor slik at de kan testge alle funksjoner.
    //todo: legg til at pengene blir vist på riktig måte. altså hvordan python legger til comma og penge tegn for deg.
    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.balance = 0;
        //den vil registere og lagre alle brukere som blir lagd BARE i minne.
        //todo: legg dette inn i en database
        allPlayer.add(this);
    }




    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }



    @Getter
    private static final List<Player> allPlayer = new ArrayList<>();



    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }


}

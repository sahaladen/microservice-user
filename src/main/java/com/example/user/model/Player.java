package com.example.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(force = true)
public class Player {
    //todo: fiks database koblingen slik at den faktisk fungerer
    @Id
    @GeneratedValue
    private Long id;

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
        //allPlayer.add(this);
    }




    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }




    private static final List<Player> allPlayer = new ArrayList<>();

    @JsonIgnore //får dem ikke opp på siden
    public List<Player> getAllPlayer(){
        return allPlayer;
    }

    @JsonIgnore
    public boolean isAdmin(){
        return "admin".equals(userName) && "admin".equals(password);
    }
    @JsonIgnore
    public boolean isGuest(){
        return "guest".equals(userName) && "guest".equals(password);
    }

    public String displayName(){
        return userName;
    }





    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }


}

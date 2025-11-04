package com.example.user;

import com.example.user.model.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
public class PlayerDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private int balance;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

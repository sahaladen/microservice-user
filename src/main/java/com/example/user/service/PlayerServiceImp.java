package com.example.user.service;

import com.example.user.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    private final List<Player> player = new ArrayList<>();

    public PlayerServiceImp() {
        for (int i = 1; i <= 10; i++) {
            player.add(new Player("player" + i, "password" + i));
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        return player;
    }
}

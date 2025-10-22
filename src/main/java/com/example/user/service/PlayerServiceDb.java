package com.example.user.service;

import com.example.user.PlayerDto;
import com.example.user.model.Player;
import com.example.user.model.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceDb implements PlayerService{

    private final PlayerRepo playerRepo;

    @Override
    public List<PlayerDto> getAllPlayers() {
        return playerRepo.findAll();
    }

    public void addPlayer(PlayerDto player){
        playerRepo.save(player);
    }
}

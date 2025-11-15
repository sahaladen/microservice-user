package com.example.user.service;

import com.example.user.PlayerDto;
import com.example.user.model.Player;
import com.example.user.model.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<PlayerDto> findByUserName(String userName) {
        return playerRepo.findByUserName(userName);
    }

    public PlayerDto updateBalance(String userName, int newBalance){
        PlayerDto player = findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("player not found"));

        player.setBalance(newBalance);
        return playerRepo.save(player);
    }

    public Optional<PlayerDto> findById(Long id) {
        return playerRepo.findById(id);
    }

    public PlayerDto updateBalanceById(Long id, int newBalance) {
        PlayerDto player = findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        player.setBalance(newBalance);
        return playerRepo.save(player);
    }

    public void deletePlayerById(Long id) {
        if (!playerRepo.existsById(id)) {
            throw new RuntimeException("Player not found");
        }
        playerRepo.deleteById(id);
    }

    public void deletePlayerByUsername(String userName) {
        PlayerDto player = findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        playerRepo.delete(player);
    }

    public boolean existsByUserName(String userName) {
        return findByUserName(userName).isPresent();
    }
}

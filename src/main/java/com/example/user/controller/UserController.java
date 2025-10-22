package com.example.user.controller;

import com.example.user.model.Player;
import com.example.user.PlayerDto;
import com.example.user.service.PlayerServiceDb;
import com.example.user.service.PlayerServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/microservice/user")
public class UserController {
    private final PlayerServiceImp playerService;
    private final PlayerServiceDb playerServiceDb;



    @GetMapping("/butDB")
    public List<PlayerDto> getDBPlayers(){
        return playerServiceDb.getAllPlayers();
    }

    @GetMapping("/testadd")
    public void addPlayer(){
        Player testPlayer = new Player("testname","testpassword");
        testPlayer.setBalance(11111);
        PlayerDto testdto = new PlayerDto(testPlayer);
        playerServiceDb.addPlayer(testdto);
    }
}

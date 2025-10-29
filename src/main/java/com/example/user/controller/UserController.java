package com.example.user.controller;

import com.example.user.model.LoginRequest;
import com.example.user.model.Player;
import com.example.user.PlayerDto;
import com.example.user.service.PlayerServiceDb;
import com.example.user.service.PlayerServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/microservice/user")
public class UserController {
    private final PlayerServiceImp playerService;
    private final PlayerServiceDb playerServiceDb;



    @GetMapping("/butDB")
    public List<PlayerDto> getDBPlayers(){
        return playerServiceDb.getAllPlayers();
    }

    @PostMapping("/login")
    //todo: gjør det slik at den tar imot login og sjekker om den er i DB.
    public ResponseEntity<Map<String, String>> loginAttempt(@RequestBody LoginRequest request){
        Map<String, String> response = new HashMap<>();


        response.put("message", "login good");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/testadd")
    public void addPlayer(){
        Player testPlayer = new Player("testname","testpassword");
        testPlayer.setBalance(11111);
        PlayerDto testdto = new PlayerDto(testPlayer);
        playerServiceDb.addPlayer(testdto);
    }
}

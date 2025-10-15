package com.example.user.controller;

import com.example.user.Player;
import com.example.user.PlayerDto;
import com.example.user.service.PlayerService;
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

    @GetMapping()
    public List<PlayerDto> getAllPlayers(){
        //log.info("getting all players that are registered...");
        List<PlayerDto> dto = new ArrayList<>();
        for(Player p : playerService.getAllPlayers()){
            dto.add(new PlayerDto(p));
        }
        return dto;
    }
}

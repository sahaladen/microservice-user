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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/microservice/user")
public class UserController {
    private final PlayerServiceImp playerService;
    private final PlayerServiceDb playerServiceDb;


    @GetMapping("/getallplayers")
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


    //bruk fakerdata hvis du får tid

    @PostMapping("/testadd")
    public void addPlayer(){
        String[] names = {
                "testname1", "testname2", "testname3", "testname4", "testname5",
                "testname6", "testname7", "testname8", "testname9", "testname10", "guest","admin"
        };

        String[] passwords = {
                "testpassword1", "testpassword2", "testpassword3", "testpassword4", "testpassword5",
                "testpassword6", "testpassword7", "testpassword8", "testpassword9", "testpassword10"
                , "guest", "admin"
        };

        int[] balances = {
                11111, 12312, 1324513, 432546, 12345235,
                65453, 667635643, 876554, 67876764, 876543324, 9999999, 9999999
        };

        for (int i = 0; i < names.length; i++) {
            Player player = new Player(names[i], passwords[i]);
            player.setBalance(balances[i]);

            PlayerDto dto = new PlayerDto(player);
            playerServiceDb.addPlayer(dto);

        }
    }

    @GetMapping("/testfindbyid/{id}")
    public ResponseEntity<PlayerDto> findById(@PathVariable long id){
        return playerServiceDb.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/testfindbalancebyid/{id}")
    public ResponseEntity<PlayerDto> findBalanceById(@PathVariable long id){
        return playerServiceDb.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



    @GetMapping("/testfindname/{name}")
    public ResponseEntity<PlayerDto> findUserName(@PathVariable String name){
        return playerServiceDb.findByUserName(name)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}

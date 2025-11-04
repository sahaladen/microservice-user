package com.example.user.model;

import com.example.user.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository <PlayerDto, Long>{
    Optional<PlayerDto> findByUserName(String userName);

}

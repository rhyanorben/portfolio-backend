package com.example.avaliacao02.controller;

import com.example.avaliacao02.models.Fixture.GameEntity;
import com.example.avaliacao02.service.GameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class FavoriteGamesController {

    @Autowired
    private GameSearchService searchService;

    @PostMapping("/{id}/favorita")
    public ResponseEntity<String> marcarFavorita(@PathVariable int id, @RequestParam boolean favorita){
        boolean atualizada = searchService.marcarFavorito(id, favorita);
        if (atualizada) {
            return ResponseEntity.ok("Partida marcada como favorita!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partida não encontrada!");
        }
    }

    @GetMapping("/favoritas")
    public List<GameEntity> getPartidasFavoritas(){
        return searchService.buscarPartidasFavoritas();
    }
}

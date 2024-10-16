package com.example.avaliacao02.controller;

import com.example.avaliacao02.model.Game;
import com.example.avaliacao02.service.GameIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class GamesIdController {

    @Autowired
    private GameIdService jogoService;

    @GetMapping("/{id}")
    public List<Game> getJogoPorId(@PathVariable int id){
        return jogoService.buscarDetalhesJogo(id);
    }

}

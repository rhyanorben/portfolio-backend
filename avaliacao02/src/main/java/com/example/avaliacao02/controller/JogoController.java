package com.example.avaliacao02.controller;

/*/jogos
	/andamento - GET
	/{id_jogo} - GET
	/favoritos - GET/POST
		/remover - POST*/

import com.example.avaliacao02.model.Game;
import com.example.avaliacao02.GameIdService.GameIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private GameIdService jogoService;

    @GetMapping("/{id}")
    public List<Game> getJogoPorId(@PathVariable int id){
        return jogoService.buscarDetalhesJogo(id);
    }

}

package com.example.avaliacao02.controller;

import com.example.avaliacao02.service.SearchService;
import com.example.avaliacao02.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesOngoingController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/partidas/andamento")
    public List<Game> getPartidasEmAndamento(
        @RequestParam(value = "liga", required = false) String liga,
        @RequestParam(value = "time", required = false) String time
    ){
        return searchService.buscarPartidas(liga != null ? liga: "", time != null ? time: "");
    }

}

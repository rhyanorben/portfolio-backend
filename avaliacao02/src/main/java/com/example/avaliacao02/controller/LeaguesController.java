package com.example.avaliacao02.controller;

import com.example.avaliacao02.models.League.LeagueEntity;
import com.example.avaliacao02.service.LeagueSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaguesController {

    @Autowired
    private LeagueSearchService searchService;

    @GetMapping("/ligas")
    public List<LeagueEntity> getLigas(
            @RequestParam (value = "nome") String nomeLiga
    ) {
        return searchService.buscarLigas(nomeLiga);
    }
}

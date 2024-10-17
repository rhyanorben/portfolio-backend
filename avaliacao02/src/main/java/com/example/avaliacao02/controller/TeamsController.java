package com.example.avaliacao02.controller;

import com.example.avaliacao02.models.Team.TeamEntity;
import com.example.avaliacao02.service.TeamSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamsController {

    @Autowired
    private TeamSearchService searchService;

    @GetMapping("/times")
    public List<TeamEntity> getTimes(
            @RequestParam(value = "nome") String nomeTime
    ){
        return searchService.buscarTimes(nomeTime);
    }
}

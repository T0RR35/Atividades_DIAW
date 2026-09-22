package com.example.AV1.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AV1.Candidato;
import com.example.AV1.service.CandidatosTseService;

import org.springframework.ui.Model; 


@Controller
public class CandidatosTseController {

    private final CandidatosTseService candidatosTseService;
    
    public CandidatosTseController(CandidatosTseService candidatosTseService){
        this.candidatosTseService = candidatosTseService;
    }
    

    @GetMapping("/")
    public String index(
        @RequestParam(required = false) String cargo,
        @RequestParam(required = false) String partido,
        @RequestParam(required = false) String texto,
        Model model
    ) {

        candidatosTseService.carregarCsv();
        List<Candidato> candidatos = candidatosTseService.filtrar(cargo, partido, texto);

        model.addAttribute("candidatos", candidatos);

        return "index";
    }
}

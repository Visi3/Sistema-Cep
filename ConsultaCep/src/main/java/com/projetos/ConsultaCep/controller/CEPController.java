package com.projetos.ConsultaCep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetos.ConsultaCep.client.CEPClient;
import com.projetos.ConsultaCep.dto.CEPResponse;

@Controller
public class CEPController {

    @GetMapping("/consultarCEP")
    public String mostrarHtml(){
        return "index";
    }
    @PostMapping("/consultarCEP")
    public String consultarCEP(@RequestParam("cep-input") String cep, Model model) {
        CEPClient CEPClient = new CEPClient();
        CEPResponse CEPResponse = CEPClient.consultarCEP(cep);

        // Adiciona os dados do CEP ao modelo para serem enviados ao HTML
        model.addAttribute("cepData", CEPResponse);

        return "index"; // nome do meu arquivo HTML
    }
}
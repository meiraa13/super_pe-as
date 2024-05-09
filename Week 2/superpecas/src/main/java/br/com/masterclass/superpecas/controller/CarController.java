package br.com.masterclass.superpecas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarController {

    @GetMapping
    public String getCar(){
        return "method get test";
    }
}

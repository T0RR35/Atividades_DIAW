package com.example.Weather_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Weather_API.service.Service;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/temperatura")
    public String consultarTemperatura(){
        return service.consultarTemperatura();
    }

}

package com.fullstack.banco.controller;

import com.fullstack.banco.entity.Persona;
import com.fullstack.banco.service.PersonaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "persona")
public class PersonaController {
    @Autowired
    PersonaS personaS;

    @GetMapping(
            path = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Persona> findAll(){
        return personaS.findAll();
    }
}

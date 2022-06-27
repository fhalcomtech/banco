package com.fullstack.banco.service;

import com.fullstack.banco.dao.PersonaDao;
import com.fullstack.banco.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaS {
    @Autowired
    PersonaDao personaDao;

    public List<Persona> findAll()
    {
        return this.personaDao.findAll();
    }
}

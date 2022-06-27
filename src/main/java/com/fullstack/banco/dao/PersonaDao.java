package com.fullstack.banco.dao;

import com.fullstack.banco.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona,Integer> {
}

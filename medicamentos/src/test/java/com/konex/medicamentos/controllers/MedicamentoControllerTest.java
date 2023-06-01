package com.konex.medicamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.konex.medicamentos.config.BusinessException;
import com.konex.medicamentos.dto.MedicamentoDTO;
import com.konex.medicamentos.iservices.MedicamentoIService;

import jakarta.validation.Valid;


public class MedicamentoControllerTest {
    
    /*@Autowired
    private MedicamentoIService service;

    
    public void findAll() throws BusinessException {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    
    public void save(@RequestBody @Valid MedicamentoDTO dto) {
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.CREATED);
    }

    
    public void findById() {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }
    
    public ResponseEntity<Boolean> delete() {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }

    public void validarStok() {
        return this.service.validarStok(id, cantidad);
    }*/
}

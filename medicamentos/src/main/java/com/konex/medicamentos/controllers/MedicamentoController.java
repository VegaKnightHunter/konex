package com.konex.medicamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konex.medicamentos.config.BusinessException;
import com.konex.medicamentos.dto.MedicamentoDTO;
import com.konex.medicamentos.iservices.MedicamentoIService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MedicamentoController {
    
    @Autowired
    private MedicamentoIService service;

    @GetMapping(value = "/medicamento/")
    public ResponseEntity<List<MedicamentoDTO>> findAll() throws BusinessException {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/medicamento")
    public ResponseEntity<MedicamentoDTO> save(@RequestBody @Valid MedicamentoDTO dto) throws BusinessException {
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/medicamento/{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable("id") long id) throws BusinessException {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/medicamento/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) throws BusinessException {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }

    @GetMapping(value = "/validarstok/{id}/{cantidad}")
    public Boolean validarStok(@PathVariable("id") long id, @PathVariable("cantidad") Integer cantidad) throws BusinessException {
        return this.service.validarStok(id, cantidad);
    }
}

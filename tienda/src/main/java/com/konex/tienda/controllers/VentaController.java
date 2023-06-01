package com.konex.tienda.controllers;

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

import com.konex.tienda.config.BusinessException;
import com.konex.tienda.dto.VentaDTO;
import com.konex.tienda.iservices.VentaIService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class VentaController {
    
    @Autowired
    private VentaIService service;

    @GetMapping(value = "/venta/")
    public ResponseEntity<List<VentaDTO>> findAll() throws BusinessException {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/venta")
    public ResponseEntity<VentaDTO> save(@RequestBody @Valid VentaDTO dto) throws BusinessException {
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/venta/{id}")
    public ResponseEntity<VentaDTO> findById(@PathVariable("id") long id) throws BusinessException {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/venta/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) throws BusinessException {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }

    @GetMapping(value = "/vender/{id}/{cantidad}")
    public ResponseEntity<String> vender(@PathVariable("id") long id, @PathVariable("cantidad") Integer cantidad) throws BusinessException {
        return new ResponseEntity<>(this.service.venta(id, cantidad), HttpStatus.OK);
    }
}

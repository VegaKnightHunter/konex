package com.konex.medicamentos.dto;

import org.junit.jupiter.api.Test;

import com.konex.medicamentos.domains.Medicamento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class MedicamentoDTOTest {

    @Test
    public void testEntityConstructor() {
        Long id = 1L;
        String nombre = "Medicamento 1";
        String laboratorioFabrica = "Laboratorio 1";
        Date fechaFabricacion = new Date();
        Date fechaVencimiento = new Date();
        int cantidadStock = 15;
        int valor = 5000;

        Medicamento m = new Medicamento();
        m.setId(id);
        m.setNombre(nombre);
        m.setLaboratorioFabrica(laboratorioFabrica);
        m.setFechaFabricacion(fechaFabricacion);
        m.setFechaVencimiento(fechaVencimiento);
        m.setCantidadStock(cantidadStock);
        m.setValor(valor);

        MedicamentoDTO medicamentoDTO = new MedicamentoDTO(m);

        assertEquals(id, medicamentoDTO.getId());
        assertEquals(nombre, medicamentoDTO.getNombre());
        assertEquals(laboratorioFabrica, medicamentoDTO.getLaboratorioFabrica());
        assertEquals(fechaFabricacion, medicamentoDTO.getFechaFabricacion());
        assertEquals(fechaVencimiento, medicamentoDTO.getFechaVencimiento());
        assertEquals(cantidadStock, medicamentoDTO.getCantidadStock());
        assertEquals(valor, medicamentoDTO.getValor());
    }

    /*public Medicamento entity() {
        Medicamento m = new Medicamento();
        m.setId(this.id);
        m.setNombre(this.nombre);
        m.setLaboratorioFabrica(this.laboratorioFabrica);
        m.setFechaFabricacion(this.fechaFabricacion);
        m.setFechaVencimiento(this.fechaVencimiento);
        m.setCantidadStock(this.cantidadStock);
        m.setValor(this.valor);
        return m;
    }*/
}

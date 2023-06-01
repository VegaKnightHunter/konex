package com.konex.medicamentos.dto;

import java.util.Date;

import com.konex.medicamentos.domains.Medicamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDTO {

    private Long id;

    @NotEmpty(message = "Nombre es requerido")
    @Size(min = 3, max = 60, message = "Nombre debe tener entre 3 y 90 caracteres")
    private String nombre;

    @NotEmpty(message = "Laboratorio de fabrica es requerido")
    @Size(min = 3, max = 60, message = "Laboratorio de fabrica debe tener entre 3 y 90 caracteres")
    private String laboratorioFabrica;

    @NotNull(message = "Fecha de Fabricación es requerido")
    private Date fechaFabricacion;

    @NotNull(message = "Fecha de vencimiento es requerido")
    private Date fechaVencimiento;

    private Integer cantidadStock;

    private Integer valor;

    public MedicamentoDTO(Medicamento m) {
        this.id = m.getId();
        this.nombre = m.getNombre();
        this.laboratorioFabrica = m.getLaboratorioFabrica();
        this.fechaFabricacion = m.getFechaFabricacion();
        this.fechaVencimiento = m.getFechaVencimiento();
        this.cantidadStock = m.getCantidadStock();
        this.valor = m.getValor();
    }

    public Medicamento entity() {
        Medicamento m = new Medicamento();
        m.setId(this.id);
        m.setNombre(this.nombre);
        m.setLaboratorioFabrica(this.laboratorioFabrica);
        m.setFechaFabricacion(this.fechaFabricacion);
        m.setFechaVencimiento(this.fechaVencimiento);
        m.setCantidadStock(this.cantidadStock);
        m.setValor(this.valor);
        return m;
    }
}

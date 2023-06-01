package com.konex.medicamentos.domains;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"medicamento\"", schema = "konex")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 90, nullable = false)
    private String nombre;

    @Column(name = "laboratorio_fabrica", length = 90, nullable = false)
    private String laboratorioFabrica;

    @Column(name = "fecha_fabricacion", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaFabricacion;

    @Column(name = "fecha_vencimiento", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaVencimiento;

    @Column(name = "cantiad_stock", nullable = false)
    private Integer cantidadStock;

    @Column(name = "valor", nullable = false)
    private Integer valor;
    
}

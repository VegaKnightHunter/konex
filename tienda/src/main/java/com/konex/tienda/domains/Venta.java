package com.konex.tienda.domains;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"venta\"", schema = "konex")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fecha;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "valor_unitario", nullable = false)
    private Integer valorUnitario;

    @Column(name = "valor_total", nullable = false)
    private Integer valorTotal;

    @ManyToOne
    @JoinColumn(name = "medicamento")
    private Medicamento medicamento;
    
}

package com.konex.tienda.dto;

import java.util.Date;

import com.konex.tienda.domains.Medicamento;
import com.konex.tienda.domains.Venta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Long id;

    @NotNull(message = "Fecha requerido")
    private Date fecha;

    private Integer cantidad;

    private Integer valorUnitario;

    private Integer valorTotal;

    private Long medicamento;

    public VentaDTO(Venta m) {
        this.id = m.getId();
        this.fecha = m.getFecha();
        this.cantidad = m.getCantidad();
        this.valorUnitario = m.getValorUnitario();
        this.valorTotal = m.getValorTotal();
        this.medicamento = m.getMedicamento().getId();
    }

    public Venta entity() {
        Venta m = new Venta();
        m.setId(this.id);
        m.setFecha(this.fecha);
        m.setCantidad(this.cantidad);
        m.setValorUnitario(this.valorUnitario);
        m.setValorTotal(this.valorTotal);
        Medicamento me = new Medicamento();
        me.setId(this.medicamento);
        m.setMedicamento(me);
        return m;
    }
}

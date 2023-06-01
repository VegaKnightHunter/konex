package com.konex.tienda.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.konex.tienda.config.BusinessException;

@FeignClient(name = "medicamento", url = "http://172.18.0.3:8080/medicamentos/api")
public interface MedicamentoApi {
    @GetMapping(value = "/validarstok/{id}/{cantidad}")
    public Boolean validarStok(@PathVariable("id") long id, @PathVariable("cantidad") Integer cantidad) throws BusinessException;
}

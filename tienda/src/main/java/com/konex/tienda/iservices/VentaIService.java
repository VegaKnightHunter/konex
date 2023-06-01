package com.konex.tienda.iservices;

import java.util.List;

import com.konex.tienda.config.BusinessException;
import com.konex.tienda.dto.VentaDTO;

public interface VentaIService {
    
    VentaDTO save(VentaDTO dto) throws BusinessException;
    boolean delete(Long id) throws BusinessException;
    List<VentaDTO> findAll() throws BusinessException;
    VentaDTO findById(Long id) throws BusinessException;

    String venta(Long id, Integer cantidad) throws BusinessException;
}

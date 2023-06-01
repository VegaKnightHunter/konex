package com.konex.medicamentos.iservices;

import java.util.List;

import com.konex.medicamentos.config.BusinessException;
import com.konex.medicamentos.dto.MedicamentoDTO;

public interface MedicamentoIService {
    
    MedicamentoDTO save(MedicamentoDTO dto) throws BusinessException;
    boolean delete(Long id) throws BusinessException;
    List<MedicamentoDTO> findAll() throws BusinessException;
    MedicamentoDTO findById(Long id) throws BusinessException;
    Boolean validarStok(Long id, Integer cantidad);
}

package com.konex.medicamentos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konex.medicamentos.config.BusinessException;
import com.konex.medicamentos.domains.Medicamento;
import com.konex.medicamentos.dto.MedicamentoDTO;
import com.konex.medicamentos.iservices.MedicamentoIService;
import com.konex.medicamentos.repositories.MedicamentoRepository;

import org.jboss.logging.Logger;

@Service
public class MedicamentoService implements MedicamentoIService {

    @Autowired(required = true)
    private MedicamentoRepository repository;

    @Override
    public MedicamentoDTO save(MedicamentoDTO dto) throws BusinessException {
        Medicamento medicamento = dto.entity();
        medicamento = repository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Override
    public boolean delete(Long id) throws BusinessException {
        try {
            Medicamento m = new Medicamento();
            m.setId(id);
            this.repository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger(MedicamentoService.class).error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
        return true;
    }

    @Override
    public List<MedicamentoDTO> findAll() throws BusinessException {
        List<Medicamento> list = this.repository.findAll();
        return list.stream().map(MedicamentoDTO::new).collect(Collectors.toList());
    }
    
    /*@Override
    public List<MedicamentoDTO> findAll(int pageNumber, int pageSize) throws BusinessException {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Medicamento> list = this.repository.findAll(pageable);
        return list.stream().map(MedicamentoDTO::new).collect(Collectors.toList());
    }*/

    @Override
    public MedicamentoDTO findById(Long id) throws BusinessException {
        Optional<Medicamento> response  =  repository.findById(id);
		Medicamento m = null;
		if(response.isPresent()) {
			m = response.get();
		}else {
			throw new BusinessException("No se encontro el medicamento");
		}
		
		return new MedicamentoDTO(m);
    }

    @Override
    public Boolean validarStok(Long id, Integer cantidad) {
        Integer v = this.repository.validarStok(id, cantidad);
        if(v == 0) {
            return false;
        }
        return true;
    }
    
}

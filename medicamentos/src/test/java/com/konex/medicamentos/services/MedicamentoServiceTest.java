package com.konex.medicamentos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.konex.medicamentos.domains.Medicamento;
import com.konex.medicamentos.dto.MedicamentoDTO;
import com.konex.medicamentos.iservices.MedicamentoIService;
import com.konex.medicamentos.repositories.MedicamentoRepository;


public class MedicamentoServiceTest{

    /*@Autowired(required = true)
    private MedicamentoRepository repository;

    @Test
    public void save() {
        Medicamento medicamento = dto.entity();
        medicamento = repository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Test
    public void delete() {
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

    @Test
    public void findAll() {
        List<Medicamento> list = this.repository.findAll();
        return list.stream().map(MedicamentoDTO::new).collect(Collectors.toList());
    }


    @Test
    public void findById() {
        Optional<Medicamento> response  =  repository.findById(id);
		Medicamento m = null;
		if(response.isPresent()) {
			m = response.get();
		}else {
			throw new BusinessException("No se encontro el medicamento");
		}
		
		return new MedicamentoDTO(m);
    }

    @Test
    public void validarStok() {
        Integer v = this.repository.validarStok(id, cantidad);
        if(v == 0) {
            return false;
        }
        return true;
    }*/
    
}

package com.konex.tienda.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konex.tienda.clients.MedicamentoApi;
import com.konex.tienda.config.BusinessException;
import com.konex.tienda.domains.Venta;
import com.konex.tienda.dto.VentaDTO;
import com.konex.tienda.iservices.VentaIService;
import com.konex.tienda.repositories.VentaRepository;

import org.jboss.logging.Logger;

@Service
public class VentaService implements VentaIService {

    @Autowired(required = true)
    private VentaRepository repository;

    /*@Autowired
    private MedicamentoApi medicamentoApi;*/

    @Override
    public VentaDTO save(VentaDTO dto) throws BusinessException {
        Venta Venta = dto.entity();
        Venta = repository.save(Venta);
        return new VentaDTO(Venta);
    }

    @Override
    public boolean delete(Long id) throws BusinessException {
        try {
            Venta m = new Venta();
            m.setId(id);
            this.repository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger(VentaService.class).error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
        return true;
    }

    @Override
    public List<VentaDTO> findAll() throws BusinessException {
        /*Boolean a = this.medicamentoApi.validarStok(1, 4);
        Logger.getLogger(VentaService.class).info("primera:" + a);
        a = this.medicamentoApi.validarStok(1, 3);
        Logger.getLogger(VentaService.class).info("segunda:" + a);*/

        List<Venta> list = this.repository.findAll();
        return list.stream().map(VentaDTO::new).collect(Collectors.toList());
    }
    

    @Override
    public VentaDTO findById(Long id) throws BusinessException {
        Optional<Venta> response  =  repository.findById(id);
		Venta m = null;
		if(response.isPresent()) {
			m = response.get();
		}else {
			throw new BusinessException("No se encontro la venta");
		}
		
		return new VentaDTO(m);
    }

    @Override
    public String venta(Long id, Integer cantidad) throws BusinessException {
        Object[][] a = this.repository.procedureVenta(id, cantidad);
        int ok;
        try {
            ok = (int) a[0][0];
        } catch (Exception e) {
            ok = 0;
        }
        if(ok > 0) {
            return (String) a[0][1];
        } else {
            throw new BusinessException((String) a[0][1]);
        }
    }
    
}

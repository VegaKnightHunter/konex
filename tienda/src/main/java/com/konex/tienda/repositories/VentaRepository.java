package com.konex.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import com.konex.tienda.domains.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "CALL konex.p_venta(:p_id, :p_cantidad)", nativeQuery = true)
    Object[][] procedureVenta(@Param("p_id") Long persona, @Param("p_cantidad") Integer cantidad);
}

package com.bolasaideas.springboot.app.models.dao;

import com.bolasaideas.springboot.app.models.entities.Factura;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Eisten Flores
 * @project spring-boot-data-jpa
 */
public interface IFacturaDao extends CrudRepository<Factura, Long> {
}

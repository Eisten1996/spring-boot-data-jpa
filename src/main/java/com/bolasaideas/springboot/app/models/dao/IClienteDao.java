package com.bolasaideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolasaideas.springboot.app.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
	
}

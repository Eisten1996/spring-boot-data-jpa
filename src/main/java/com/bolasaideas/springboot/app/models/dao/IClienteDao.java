package com.bolasaideas.springboot.app.models.dao;

import java.util.List;

import com.bolasaideas.springboot.app.models.entities.Cliente;

public interface IClienteDao {
	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findOne(Long id);
}

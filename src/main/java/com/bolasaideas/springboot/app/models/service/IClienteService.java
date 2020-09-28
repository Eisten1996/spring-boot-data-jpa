package com.bolasaideas.springboot.app.models.service;

import java.util.List;

import com.bolasaideas.springboot.app.models.entities.Factura;
import com.bolasaideas.springboot.app.models.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolasaideas.springboot.app.models.entities.Cliente;

public interface IClienteService {
    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public void delete(Long id);

    public List<Producto> findByNombre(String term);

    public void saveFactura(Factura factura);
}

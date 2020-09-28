package com.bolasaideas.springboot.app.models.service;

import java.util.List;

import com.bolasaideas.springboot.app.models.dao.IFacturaDao;
import com.bolasaideas.springboot.app.models.dao.IProductoDao;
import com.bolasaideas.springboot.app.models.entities.Factura;
import com.bolasaideas.springboot.app.models.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolasaideas.springboot.app.models.dao.IClienteDao;
import com.bolasaideas.springboot.app.models.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        // TODO Auto-generated method stub
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        // TODO Auto-generated method stub
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String term) {
        return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
    }

    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return clienteDao.findAll(pageable);
    }

}

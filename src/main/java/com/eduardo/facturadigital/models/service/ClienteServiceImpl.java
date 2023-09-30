package com.eduardo.facturadigital.models.service;

import com.eduardo.facturadigital.models.dao.IClienteDao;
import com.eduardo.facturadigital.models.entity.Cliente;
import com.eduardo.facturadigital.models.entity.Factura;
import com.eduardo.facturadigital.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
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
        clienteDao.deleteById(id);
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        return findByNombre(nombre);
    }

    @Override
    public void saveFactura(Factura factura) {
        clienteDao.save();
    }

    @Override
    public Producto findProductoById(Long id) {
        return findProductoById(id);
    }

    @Override
    public Factura findFacturaById(Long id) {
        return findFacturaById(id);
    }

    @Override
    public void deleteFactura(Long id) {
        clienteDao.deleteById(id);
    }
}

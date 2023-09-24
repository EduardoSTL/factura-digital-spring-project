package com.eduardo.facturadigital.models.service;

import com.eduardo.facturadigital.models.dao.IClienteDao;
import com.eduardo.facturadigital.models.entity.Cliente;
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
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }
}

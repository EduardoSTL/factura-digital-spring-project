package com.eduardo.facturadigital.models.dao;

import com.eduardo.facturadigital.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
}

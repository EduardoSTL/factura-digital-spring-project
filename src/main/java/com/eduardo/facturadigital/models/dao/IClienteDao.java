package com.eduardo.facturadigital.models.dao;

import com.eduardo.facturadigital.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public class IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
}

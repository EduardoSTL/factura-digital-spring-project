package com.eduardo.facturadigital.models.dao;

import com.eduardo.facturadigital.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
}

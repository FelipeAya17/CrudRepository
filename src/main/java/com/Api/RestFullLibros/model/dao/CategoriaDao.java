package com.Api.RestFullLibros.model.dao;

import com.Api.RestFullLibros.model.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {
}

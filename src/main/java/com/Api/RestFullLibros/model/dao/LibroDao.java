package com.Api.RestFullLibros.model.dao;

import com.Api.RestFullLibros.model.entity.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroDao extends CrudRepository<Libro, Integer> {
}

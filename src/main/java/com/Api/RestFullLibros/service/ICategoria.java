package com.Api.RestFullLibros.service;

import com.Api.RestFullLibros.model.entity.Categoria;

import java.util.List;

public interface ICategoria {

    List<Categoria> getAll();

    Categoria save(Categoria categoria);

    Categoria findById(Integer id);

    void delete(Categoria categoria);
}

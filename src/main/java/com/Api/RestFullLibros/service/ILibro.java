package com.Api.RestFullLibros.service;

import com.Api.RestFullLibros.model.entity.Libro;

import java.util.ArrayList;

public interface ILibro {

    ArrayList<Libro> getAll();
    Libro save(Libro libro);

    Libro findById(Integer id);

    void delete(Libro libro);
}

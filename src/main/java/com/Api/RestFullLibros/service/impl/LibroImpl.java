package com.Api.RestFullLibros.service.impl;

import com.Api.RestFullLibros.model.dao.LibroDao;
import com.Api.RestFullLibros.model.entity.Libro;
import com.Api.RestFullLibros.service.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class LibroImpl implements ILibro {
    @Autowired
    private LibroDao libroDao;

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Libro> getAll() {
        return (ArrayList<Libro>) libroDao.findAll();
    }

    @Transactional
    @Override
    public Libro save(Libro libro) {
        return libroDao.save(libro);
    }

    @Transactional(readOnly = true)
    @Override
    public Libro findById(Integer id) {
        return libroDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Libro libro) {
        libroDao.delete(libro);
    }
}

package com.Api.RestFullLibros.service.impl;

import com.Api.RestFullLibros.model.dao.CategoriaDao;
import com.Api.RestFullLibros.model.entity.Categoria;
import com.Api.RestFullLibros.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaImpl implements ICategoria {

    @Autowired
    private CategoriaDao categoriaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> getAll(){ return (List<Categoria>) categoriaDao.findAll(); }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) { return categoriaDao.save(categoria); }

    @Transactional(readOnly = true)
    @Override
    public Categoria findById(Integer id){ return categoriaDao.findById(id).orElse(null); }

    @Transactional
    @Override
    public void delete(Categoria categoria) { categoriaDao.delete(categoria); }
}

package com.Api.RestFullLibros.controller;


import com.Api.RestFullLibros.model.entity.Categoria;
import com.Api.RestFullLibros.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {

    @Autowired
    private ICategoria categoriaService;

    @PostMapping("categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria saveCat(@RequestBody Categoria categoria) { return categoriaService.save(categoria); }

    @PutMapping("categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria updateCat(Categoria categoria){
        return categoriaService.save(categoria);
    }

    @DeleteMapping("categoria/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteLibro(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Categoria categoriaEliminada = categoriaService.findById(id);
            categoriaService.delete(categoriaEliminada);
            return new ResponseEntity<>("id eliminado", HttpStatus.NO_CONTENT);
        }catch (DataAccessException d){
            response.put("mensaje", d.getMessage());
            response.put("libro", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("categoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Categoria categoriaEncontrada = categoriaService.findById(id);
        if(categoriaEncontrada != null){
            return new ResponseEntity<>(categoriaEncontrada,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Id no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("categoria")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> getAllCat(){ return categoriaService.getAll(); }

}

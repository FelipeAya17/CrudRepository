package com.Api.RestFullLibros.controller;

import com.Api.RestFullLibros.model.entity.Libro;
import com.Api.RestFullLibros.service.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LibroController {

    @Autowired
    private ILibro libroService;

    @PostMapping("libro")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro saveLibro(@RequestBody Libro libro){
        return libroService.save(libro);
    }

    @PutMapping("libro")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro updateLibro(Libro libro){
        return libroService.save(libro);
    }
    @DeleteMapping("libro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteLibro(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Libro libroEliminado = libroService.findById(id);
            libroService.delete(libroEliminado);
            return new ResponseEntity<>(libroEliminado, HttpStatus.NO_CONTENT);
        }catch (DataAccessException d){
            response.put("mensaje", d.getMessage());
            response.put("libro", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("libro/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Libro libroEncontrado = libroService.findById(id);
        if (libroEncontrado != null) {
            return new ResponseEntity<>(libroEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("libro")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Libro> getAll(){
        return libroService.getAll();
    }
}

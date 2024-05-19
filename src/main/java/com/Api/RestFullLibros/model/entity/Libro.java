package com.Api.RestFullLibros.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "editorial")
    private String editorial;
}

package com.example.peliculon.servicios;

import com.example.peliculon.modelo.Pelicula;
import com.example.peliculon.repositorios.RepositorioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioPelicula {
    @Autowired
    RepositorioPeliculas repo;

    public ArrayList<Pelicula> findAll(){
        return repo.findAll();
    }

    public Pelicula findById(long id){
        return repo.findById(id);
    }

    public Pelicula save(Pelicula pelicula){
        return repo.save(pelicula);
    }

    public ArrayList<Pelicula> findByNacionalidad(String nacionalidad){
        return repo.findbyNacionalidad(nacionalidad);
    }
}

package com.example.peliculon.repositorios;

import com.example.peliculon.modelo.Comentario;
import com.example.peliculon.modelo.Pelicula;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface RepositorioComentarios extends JpaRepository<Comentario, Long>{
    public ArrayList<Comentario> findAll();

    public Comentario findById(long id);

    ArrayList<Comentario> findByPelicula(Pelicula pelicula);
    public Comentario save(Comentario comentario);

}
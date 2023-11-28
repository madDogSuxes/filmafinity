package com.example.peliculon.controladores;

import com.example.peliculon.modelo.Pelicula;
import com.example.peliculon.repositorios.RepositorioComentarios;
import com.example.peliculon.repositorios.RepositorioPeliculas;
import com.example.peliculon.servicios.ServicioComentario;
import com.example.peliculon.servicios.ServicioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class Principal {
    @Autowired
    ServicioPelicula servicioPelicula;

    @Autowired
    ServicioComentario servicioComentario;

    @GetMapping("/")
    public String inicio(Model model){
        ArrayList<Pelicula> cartelera=servicioPelicula.findAll();
        model.addAttribute("cartelera", cartelera);
        return "index";
    }

    @GetMapping("/pelicula/{id}")
    public String detalle(@PathVariable long id, Model model){
        Pelicula pelicula=servicioPelicula.findById(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("post", servicioComentario.findByPelicula(pelicula));
        return "detalle";

    }

}

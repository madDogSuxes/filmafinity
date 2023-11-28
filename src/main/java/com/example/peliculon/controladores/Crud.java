package com.example.peliculon.controladores;

import com.example.peliculon.modelo.Pelicula;
import com.example.peliculon.servicios.ServicioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/crud")
@Controller
public class Crud {
    //Para modificar peliculas necesito el Repositorio o Servicio de películas
    @Autowired
    ServicioPelicula servicioPelicula;

    //Este endpoint/url nos muestra la lista con todas las películas
    @GetMapping("/crud")
    public String listadoPeliculas(Model model){
        //El nombre de "películas" es el que voy a utilizar en la plantilla
        model.addAttribute("peliculas", servicioPelicula.findAll());
        return "crud";

    }

    //Muestra el formularoi para añadir películas, PERO ESTE AUN NO LA AÑADE.
    @GetMapping("/crud/add")
    public String addPelicula(Model model){
        //formPelicula es el objeto que voy a usar en la plantilla
        model.addAttribute("formPelicula",  new Pelicula());
        return "form_add";
    }

    //Esta es la url que aparece en el th:action del formulario para añadir películas
    //Lo que aparece en el ModelAttribute es lo mismo del th:object del formulario
    @PostMapping("/crud/save")
    public String guardarPeli(@ModelAttribute("formPelicula") Pelicula nuevaPelicula){
        servicioPelicula.save(nuevaPelicula);
        return "redirect:/crud/add";
    }

    @GetMapping("/crud/update/{id}")
    public String muestraPelicula(@PathVariable long id, Model model){
        Pelicula p= servicioPelicula.findById(id);
        //El nombre del objeto debe ser el mismo que en el GetMapping de añadir
        //Y el mismo que en el th:object del formulario
        model.addAttribute("formPelicula", p);
        return "form_add";
    }

    @PostMapping("/crud/modificar")
    public String modificarPelicula(@ModelAttribute("formPelicula") Pelicula p){
        servicioPelicula.save(p);
        return "redirect:/crud";
    }

    @GetMapping("/crud/delete/{id}")
    public String eliminarPelicula(@PathVariable long id, Model model){
        Pelicula p= servicioPelicula.findById(id);
        servicioPelicula.delete(p);
        return "redirect:/crud";
    }
}

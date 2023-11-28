package com.example.peliculon;

import com.example.peliculon.modelo.Comentario;
import com.example.peliculon.modelo.Pelicula;
import com.example.peliculon.repositorios.RepositorioComentarios;
import com.example.peliculon.repositorios.RepositorioPeliculas;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Locale;

@SpringBootApplication
public class FilmafinityApplication {

	@Autowired
	RepositorioPeliculas repositorioPeliculas;

	@Autowired
	RepositorioComentarios repositorioComentarios;

	public static void main(String[] args) {

		SpringApplication.run(FilmafinityApplication.class, args);
	}

	@Bean
	CommandLineRunner ponPeliculas(){
		return args -> {



			Faker faker = new Faker(new Locale("es-ES"));
			if(repositorioPeliculas.findAll().size()<15) {
				for (int i = 0; i < 5; i++) {
					Pelicula p = new Pelicula();
					p.setTitulo(faker.pokemon().name());
					p.setSinopsis(faker.gameOfThrones().quote());
					p.setFecha(LocalDate.now());
					p.setTrailer("https://www.youtube.com/embed/ClFUH11eJng?si=ujS6gQJL_kN_qVXw");
					p.setNacionalidad(faker.country().countryCode2());
					repositorioPeliculas.save(p);

					for(int ii=0; ii<4; ii++){
						Comentario c=new Comentario();
						c.setTitulo(faker.backToTheFuture().character());
						c.setContenido(faker.backToTheFuture().quote());
						c.setFecha(LocalDate.now());
						c.setPelicula(p);
						repositorioComentarios.save(c);
					}
				}
			}
		};
	}

}

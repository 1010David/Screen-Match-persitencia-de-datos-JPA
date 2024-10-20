package com.cursoalura.screenmatch;

import com.cursoalura.screenmatch.modelo.DatoSerie;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=the+walking+dead&Season=1&apikey=e213ac13");
		System.out.println(json);
		ConveritrDatos conversor = new ConveritrDatos();
		var datos = conversor.obteberDatos(json, DatoSerie.class);
		System.out.println(datos);

	}
}
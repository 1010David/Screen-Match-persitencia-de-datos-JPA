package com.cursoalura.screenmatch;

import com.cursoalura.screenmatch.modelo.DatoSerie;
import com.cursoalura.screenmatch.modelo.DatosEpisode;
import com.cursoalura.screenmatch.modelo.DatosTemporada;
import com.cursoalura.screenmatch.principal.EjemploStreams;
import com.cursoalura.screenmatch.principal.Principal;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Principal principal = new Principal();
		//principal.muetraMenu();
		EjemploStreams ejemploStreams = new EjemploStreams();
		ejemploStreams.muestraEjemplo();

	}
}
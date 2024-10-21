package com.cursoalura.screenmatch;

<<<<<<< HEAD
import com.cursoalura.screenmatch.modelo.DatoSerie;
import com.cursoalura.screenmatch.modelo.DatosEpisode;
import com.cursoalura.screenmatch.modelo.DatosTemporada;
import com.cursoalura.screenmatch.principal.EjemploStreams;
import com.cursoalura.screenmatch.principal.Principal;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;
=======
import com.cursoalura.screenmatch.service.ConsumoAPI;
>>>>>>> 492868062312f905148ec8daf68ef888d5145171
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 492868062312f905148ec8daf68ef888d5145171
@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

<<<<<<< HEAD
		//Principal principal = new Principal();
		//principal.muetraMenu();
		EjemploStreams ejemploStreams = new EjemploStreams();
		ejemploStreams.muestraEjemplo();
=======
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=the+walking+dead&Season=1&apikey=e213ac13");
		System.out.println(json);
>>>>>>> 492868062312f905148ec8daf68ef888d5145171

	}
}
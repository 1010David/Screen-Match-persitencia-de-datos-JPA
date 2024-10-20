package com.cursoalura.screenmatch.principal;

import com.cursoalura.screenmatch.modelo.DatoSerie;
import com.cursoalura.screenmatch.modelo.DatosEpisode;
import com.cursoalura.screenmatch.modelo.DatosTemporada;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumoAPI = new ConsumoAPI();

    private final String URL_BASE ="https://www.omdbapi.com/?t=";
    private final String API_KEY ="&apikey=e213ac13";
    private ConveritrDatos conversor = new ConveritrDatos();

    public void muetraMenu(){
        System.out.println("Nombre de la serie por buscar");
        //Bucar datos generales serie
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + API_KEY);
        var datos = conversor.obteberDatos(json, DatoSerie.class);

        //Buscar datos temporadas
        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+ i + API_KEY );
            var datosTemporada = conversor.obteberDatos(json,DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas

        temporadas.forEach(t -> t.episodes().forEach(e -> System.out.println(e.titulo())));

    }
    
}

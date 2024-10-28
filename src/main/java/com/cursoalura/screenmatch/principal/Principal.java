package com.cursoalura.screenmatch.principal;

import com.cursoalura.screenmatch.modelo.DatoSerie;
import com.cursoalura.screenmatch.modelo.DatosEpisodio;
import com.cursoalura.screenmatch.modelo.DatosTemporada;
import com.cursoalura.screenmatch.modelo.Episodio;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        //temporadas.forEach(t -> t.episodes().forEach(e -> System.out.println(e.titulo())));
        //  Convertir info a List tipo DatosEpisode

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());

        //Top 5 episoidos
        //System.out.println("Top 5 episodes");
        //datosEpisodios.stream()
        //        .filter(e-> !e.evaluacion().equalsIgnoreCase("N/A"))
        //        .peek(e-> System.out.println("Primer filtro (N/A)" + e))
        //        .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
        //        .peek(e-> System.out.println("Segundo ordenación (M>m)" + e))
        //        .map(e-> e.titulo().toUpperCase())
        //        .peek(e-> System.out.println("Tercer filtro mayúscula (m>M)" + e))
        //        .limit(5)
        //        .forEach(System.out::println);


        //Convirtiendo datos a lista de tipo episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t->t.episodes().stream()
                        .map(d-> new Episodio(t.numero(),d)))
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);

        //Buqueda de episodio a partir de x año
        //System.out.println("Indica el año para la búsqueda");
        //var fecha = teclado.nextInt();
        //teclado.nextLine();

        //LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        //episodios.stream()
        //        .filter(e -> e.getFechaLanzamiento() != null && e.getFechaLanzamiento().isAfter(fechaBusqueda))
        //        .forEach(e -> System.out.println(
        //                "Temporada " + e.getTemporada()));


        //Busca episodios por pedazo del título
        /* System.out.println("Episodio por bucar: ");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> epiosdioBuscado = episodios.stream()
                .filter(e-> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();

        if (epiosdioBuscado.isPresent()){
            System.out.println(" Found episode");
            System.out.println("Los datos son: " + epiosdioBuscado.get());

        }else{
            System.out.println("Not Found Episode");
        } */

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e-> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println(est);

    }
    
}

package com.cursoalura.screenmatch.principal;

import com.cursoalura.screenmatch.modelo.*;
import com.cursoalura.screenmatch.repository.SerieRepository;
import com.cursoalura.screenmatch.service.ConsumoAPI;
import com.cursoalura.screenmatch.service.ConveritrDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumoAPI = new ConsumoAPI();

    private final String URL_BASE ="https://www.omdbapi.com/?t=";

    private final String API_KEY ="&apikey=e213ac13";

    private ConveritrDatos conversor = new ConveritrDatos();

    private List<DatoSerie> datoSeries = new ArrayList<>();

    private  SerieRepository repositorio;

    private List<Serie> series;

    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Mostrar series por título
                    5 - Top 5 Series
                    6 - Buscar Serie x Categoria
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSerieBuscadas();
                    break;
                case 4:
                    buscarSeriesPorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarSeriePorCategoria();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }



    private DatoSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatoSerie datos = conversor.obteberDatos(json, DatoSerie.class);
        return datos;
    }

    private void buscarEpisodioPorSerie() {

        mostrarSerieBuscadas();
        System.out.println("De cúal serie traer episodios?");
        var nombreSerie = teclado.nextLine();



        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        if (serie.isPresent()){
            var serieEncontrada = serie.get();
            List<DatosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalDeTemporadas(); i++) {
                var json = consumoAPI.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporada datosTemporada = conversor.obteberDatos(json, DatosTemporada.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());


            serieEncontrada.setEpisodes(episodios);
            repositorio.save(serieEncontrada);


        }


    }

    private void buscarSerieWeb() {
        DatoSerie datos = getDatosSerie();
        Serie serie = new Serie(datos);
        repositorio.save(serie);
        //datoSeries.add(datos);
        System.out.println(datos);
    }

    private void mostrarSerieBuscadas() {
        series = repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private  void buscarSeriesPorTitulo(){

        System.out.println("Cúal serie buscar?");
        var nombreSerie = teclado.nextLine();
        Optional<Serie> serieBuscada = repositorio.findByTituloContainsIgnoreCase(nombreSerie);

        if(serieBuscada.isPresent()){
            System.out.println("Serie found: " + serieBuscada.get());
        } else {
            System.out.println("Not found!");
        }
    }
    private  void buscarTop5Series(){
        List<Serie> topSeries = repositorio.findTop5ByOrderByEvaluacionDesc();
        topSeries.forEach(s ->
                System.out.println("Serie: " + s.getTitulo() + " Evaluación: " + s.getEvaluacion()));
    }

    private  void  buscarSeriePorCategoria(){
        System.out.println("Genero/Categora de Serie: ");
        var genero = teclado.nextLine();
        var categoria = Categoria.fromSEspanol(genero);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Series de la categoria: " + genero);
        seriesPorCategoria.forEach(System.out::println);
    }
    
}
package com.cursoalura.screenmatch.modelo;


import java.util.OptionalDouble;

public class Serie {

    Private String titulo;
    Private Integer totalDeTemporadas;
    Private Double evaluacion;
    Private String poster;
    Private Categoria genero;
    Private String actores;
    Private String sinopsis;


    public Serie (DatoSerie datoSerie){
        this.titulo = datoSerie.titulo();
        this.totalDeTemporadas = datoSerie.totalDeTemporadas();
        this.evaluacion = OptionalDouble.of(java.lang.Double.valueOf(datoSerie.evaluacion())).orElse(0);
        this.poster = datoSerie.poster();
        this.genero = Categoria.fromString(datoSerie.genero().split(",")[0].trim());
        this.actores = datoSerie.actores();
        this.sinopsis = datoSerie.sinopsis();
    }

}

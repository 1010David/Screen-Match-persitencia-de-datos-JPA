package com.cursoalura.screenmatch.modelo;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoSerie(

        @JsonAlias("Title") String titulo,

        @JsonAlias("totalSeasons")Integer totalDeTemporadas,

        @JsonAlias("imdbRating")String evaluacion,

        @JsonAlias("Poster")String poster,

        @JsonAlias("Genre")String genero,

        @JsonAlias("Actors")String actores,

        @JsonAlias("Plot")String sinopsis) {
}





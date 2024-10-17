package com.cursoalura.screenmatch.modelo;


import com.fasterxml.jackson.annotation.JsonAlias;

public record DatoSerie(

        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons")Integer totalDeTemporadas,
        @JsonAlias("imdbRating")String evaluacion ) {
}





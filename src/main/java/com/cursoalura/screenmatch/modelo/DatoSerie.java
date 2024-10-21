package com.cursoalura.screenmatch.modelo;


import com.fasterxml.jackson.annotation.JsonAlias;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
=======

>>>>>>> 492868062312f905148ec8daf68ef888d5145171
public record DatoSerie(

        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons")Integer totalDeTemporadas,
        @JsonAlias("imdbRating")String evaluacion ) {
}





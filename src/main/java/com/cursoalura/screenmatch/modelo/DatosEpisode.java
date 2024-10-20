package com.cursoalura.screenmatch.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
        public record DatosEpisode(

        @JsonAlias("Title")String titulo,
        @JsonAlias("Episode")Integer numeroEpisode,
        @JsonAlias("imdbRating")String evaluacion,
        @JsonAlias("Released")String fechaDeLanzamiento) {
}

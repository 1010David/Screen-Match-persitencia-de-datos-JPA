package com.cursoalura.screenmatch.repository;

import com.cursoalura.screenmatch.modelo.Categoria;
import com.cursoalura.screenmatch.modelo.Episodio;
import com.cursoalura.screenmatch.modelo.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
        Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

        List<Serie> findTop5ByOrderByEvaluacionDesc();

        List<Serie> findByGenero(Categoria categoria);

        List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalDeTemporadas, Double evaluacion);


        @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
        List<Serie> seriesPorTemparadaYEvaluacion(int totalTemporadas, Double evaluacion);

        //@Query("SELECT e FROM Serie s JOIN s.episodios e WHERE LOWER(e.titulo) LIKE LOWER(CONCAT('%', :nombreEpisodio, '%'))")
        //List<Episodio> episodiosPorNombre(String nombreEpisodio);

        @Query("SELECT e FROM Episodio e WHERE e.serie = :serie ORDER BY e.evaluacion DESC")
        List<Episodio> top5Episodios(Serie serie);

}

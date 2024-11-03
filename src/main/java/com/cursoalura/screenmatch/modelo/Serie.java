package com.cursoalura.screenmatch.modelo;


import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name="Series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalDeTemporadas;
    private double evaluacion;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String poster;
    private String actores;
    private String sinopsis;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodes;

    public  Serie(){}

    public Serie (DatoSerie datoSerie){
        this.titulo = datoSerie.titulo();
        this.totalDeTemporadas = datoSerie.totalDeTemporadas();
        this.evaluacion = OptionalDouble.of(java.lang.Double.valueOf(datoSerie.evaluacion())).orElse(0);
        this.poster = datoSerie.poster();
        this.genero = Categoria.fromString(datoSerie.genero().split(",")[0].trim());
        this.actores = datoSerie.actores();
        this.sinopsis = datoSerie.sinopsis();
    }

    @Override
    public String toString() {

        return "genero=" + genero +
                "titulo='" + titulo + '\'' +
                ", totalDeTemporadas=" + totalDeTemporadas +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", episodios='" + episodes + '\'';
    }

    public List<Episodio> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episodio> episodes) {
        episodes.forEach(e->e.setSerie(this));
        this.episodes = episodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}

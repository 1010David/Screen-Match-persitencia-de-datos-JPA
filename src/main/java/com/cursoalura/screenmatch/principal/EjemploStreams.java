package com.cursoalura.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo(){

        List<String> nombres = Arrays.asList("Exodo","Geneis","Apocalipsis");
        nombres.stream()
                .sorted()
                .limit(2)
                .filter(n -> n.startsWith("B"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);


    }
}

package com.cursoalura.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo(){

        List<String> nombres = Arrays.asList("Exodo","Geneis","Apocalipsis");
        nombres.stream()
                .sorted()
                .forEach(System.out::println);


    }
}

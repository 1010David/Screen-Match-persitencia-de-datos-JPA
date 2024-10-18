package com.cursoalura.screenmatch.service;

public interface IConvertirDatos {

    <T> T obteberDatos(String json, Class<T> clase);
}

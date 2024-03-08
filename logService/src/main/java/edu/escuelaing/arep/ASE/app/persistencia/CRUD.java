package edu.escuelaing.arep.ASE.app.persistencia;

import java.util.Collection;

public interface CRUD<T,I>{

    public void guardar(I identificador, T tipoDato);

    public void eliminar(I identificador);

    public T buscar(I identificador);

    public Collection<T> buscarTodos();


}

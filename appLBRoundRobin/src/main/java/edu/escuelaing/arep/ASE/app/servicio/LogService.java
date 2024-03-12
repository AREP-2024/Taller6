package edu.escuelaing.arep.ASE.app.servicio;

import java.util.Collection;
import java.util.List;

import edu.escuelaing.arep.ASE.app.integracion.ClienteHttp;

public class LogService {
    private String url;
    private int puerto;
    private ClienteHttp cliente;

    public LogService(String url, int puerto) {
        this.url = url;
        this.puerto = puerto;
        this.cliente = new ClienteHttp();
    }

    public Collection<String> invocar(String parametro) {
        String info = String.format("Hola soy puerto:%d->info: %s", puerto, parametro);
        String devolverLlamado = cliente.hacerLlamado(url, info);
        return List.of(devolverLlamado);
    }

    
}

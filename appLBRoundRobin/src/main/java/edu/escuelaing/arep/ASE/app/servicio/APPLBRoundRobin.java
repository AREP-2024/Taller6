package edu.escuelaing.arep.ASE.app.servicio;

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;


public class APPLBRoundRobin {
    private int indice;
    private List<LogService> unidades;

    public APPLBRoundRobin() {
        this(3,5000);
    }

    public APPLBRoundRobin(int cantidadUnidades, int puertoInicial) {
        indice = 0;
        unidades = new ArrayList<>();
        for (int i = 0; i < cantidadUnidades; i++) {
            String url = "http://logservice-"+i+":" + (puertoInicial) + "/log";
            unidades.add(new LogService(url, puertoInicial + i));
        }

    }

    public Collection<String> invocar(String parametro) {
        var aux= unidades.get(indice).invocar(parametro);
        this.indice = (this.indice + 1) % unidades.size();
        return aux;
    }

    
    
}

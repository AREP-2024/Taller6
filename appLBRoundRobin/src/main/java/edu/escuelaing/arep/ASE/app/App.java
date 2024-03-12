package edu.escuelaing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.controlador.Controlador;
import edu.escuelaing.arep.ASE.app.controlador.SparkControlador;
import edu.escuelaing.arep.ASE.app.servicio.APPLBRoundRobin;

public class App {
    
    public static void main(String[] args) {
        APPLBRoundRobin appLBRoundRobin = new APPLBRoundRobin(1,5000);
        Controlador controlador = new SparkControlador(appLBRoundRobin);
        controlador.init();
    }
    
}

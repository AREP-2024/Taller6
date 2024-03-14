package edu.escuelaing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.controlador.Controlador;
import edu.escuelaing.arep.ASE.app.controlador.SparkControlador;
import edu.escuelaing.arep.ASE.app.servicio.APPLBRoundRobin;

import static spark.Spark.staticFileLocation;

public class App {
    
    public static void main(String[] args) {
        staticFileLocation("/public");
        APPLBRoundRobin appLBRoundRobin = new APPLBRoundRobin(3,5000);
        Controlador controlador = new SparkControlador(appLBRoundRobin);
        controlador.init();
    }
    
}

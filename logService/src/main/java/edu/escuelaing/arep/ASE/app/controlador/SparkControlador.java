package edu.escuelaing.arep.ASE.app.controlador;

import static spark.Spark.port;
import edu.escuelaing.arep.ASE.app.servicio.LogService;

import static spark.Spark.get;

public class SparkControlador implements Controlador {
    private LogService logService;

    public SparkControlador(LogService logService){
        this.logService = logService;
    }

    @Override
    public void init() {        
        port(5000);
        get("/log", (req,res)->{
            String parametro = req.queryParams("parametro");
            logService.guardarLog(parametro);            
            return logService.obtenerUltimosLogs();

        });
    }

}

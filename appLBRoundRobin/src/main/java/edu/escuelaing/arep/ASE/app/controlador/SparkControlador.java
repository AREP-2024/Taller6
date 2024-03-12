
package edu.escuelaing.arep.ASE.app.controlador;
import edu.escuelaing.arep.ASE.app.servicio.APPLBRoundRobin;

import static spark.Spark.port;
import static spark.Spark.get;
import java.security.PublicKey;


public class SparkControlador implements Controlador {
    private APPLBRoundRobin appLBRoundRobin;

    public SparkControlador(APPLBRoundRobin appLBRoundRobin){
        this.appLBRoundRobin = appLBRoundRobin;
    }

    @Override
    public void init() {
        port(80);
        get("/log", (req,res)->{
            String parametro = req.queryParams("parametro");
            return appLBRoundRobin.invocar(parametro);        

        });


    }


}

package edu.escuelaing.arep.ASE.app;

import static spark.Spark.port;

import static spark.Spark.get;

public class LogService {
   
    public void mian (String[] args){
        port(5000);
        get("logservicefacade", (req,res)->{
            res.type("application/json");
            return "{\"logid1\":\"20-2-2024-Log inicial\"}";

        });
}
    
}

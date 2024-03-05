package edu.escuelaing.arep.ASE.app;


import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class LogServiceFacade {
    private static final String LOG_SERVICE_URL = "http://localhost:5000/logservice";
    
    public void main (String[] args){
        RemoteLogServiceInvoke invoker = new RemoteLogServiceInvoke(LOG_SERVICE_URL);
        staticFiles.location("/public");
        get("logservicefacade", (req,res)->{
            res.type("application/json");
            return invoker.invoke(args);

        });
}
    
}

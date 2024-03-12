package edu.escuelaing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.controlador.Controlador;
import edu.escuelaing.arep.ASE.app.controlador.SparkControlador;
import edu.escuelaing.arep.ASE.app.persistencia.LogsDAO;
import edu.escuelaing.arep.ASE.app.servicio.LogService;

public class SparkAPP {

    public static void main(String[] args) {
        LogsDAO logsDAO = LogsDAO.getLogsDAO("ratito","logs");
        LogService logService = new LogService(logsDAO);
        Controlador controlador = new SparkControlador(logService);
        controlador.init();
    }
    
}

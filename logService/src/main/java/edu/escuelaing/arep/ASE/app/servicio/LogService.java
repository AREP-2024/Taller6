package edu.escuelaing.arep.ASE.app.servicio;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import edu.escuelaing.arep.ASE.app.persistencia.LogsDAO;

public class LogService {

    private LogsDAO logsDAO;
    
    public LogService(LogsDAO logsDAO){
        this.logsDAO = logsDAO;
    }

    public void guardarLog(String informacion){
        LocalDateTime now = LocalDateTime.now();
        String fecha = now.format(DateTimeFormatter.ISO_DATE_TIME);
        String log = String.format("%s:%s",fecha,informacion);
        logsDAO.guardar(fecha,log);

    }

    public Collection<String> obtenerUltimosLogs(){
        Collection<String> todasLasCadenas = logsDAO.buscarTodos();
        List<String> ultimasDiezCadenas = new ArrayList<>();
 
        int contador = 0;
        for (String cadena : todasLasCadenas) {
            if (contador >= todasLasCadenas.size() - 10) {
                ultimasDiezCadenas.add(cadena);
            }
            contador++;
        }
 
        return ultimasDiezCadenas;
    }    
        

}

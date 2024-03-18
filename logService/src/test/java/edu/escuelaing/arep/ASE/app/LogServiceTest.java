package edu.escuelaing.arep.ASE.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.client.model.Collation;

import edu.escuelaing.arep.ASE.app.persistencia.LogsDAO;
import edu.escuelaing.arep.ASE.app.servicio.LogService;

public class LogServiceTest {
    private LogService logService;
    private LogsDAO logsDAO;

    @Before
    public void setUp(){
        logsDAO = mock(LogsDAO.class);
        logService = new LogService(logsDAO);        
    }

    @Test
    public void deberiaGuardarLog(){
        String id = "test1";
        logService.guardarLog(id);
        verify(logsDAO,times(1)).guardar(anyString(), anyString());
    }

    @Test
    public void deberiaTenerDiez(){
        Collection<String> coleccion = Arrays.asList("Luisa1","Luisa2",
                                                        "Luisa3","Luisa4",
                                                        "Luisa5","Luisa6",
                                                        "Luisa7","Luisa8",
                                                        "Luisa9","Luisa10","Luisa11");
        
        when(logsDAO.buscarTodos()).thenReturn(coleccion);
        Collection<String> ultimasDiez = logService.obtenerUltimosLogs();
        verify(logsDAO,times(1)).buscarTodos();
        assertEquals(10, ultimasDiez.size());
    }

    @Test
    public void deberiaObtenerUltimosLogs(){
        Collection<String> coleccion = Arrays.asList("Luisa1","Luisa2",
                                                        "Luisa3","Luisa4",
                                                        "Luisa5","Luisa6",
                                                        "Luisa7","Luisa8",
                                                        "Luisa9","Luisa10","Luisa11");
        
        Collection<String> aux = Arrays.asList("Luisa2",
                                                    "Luisa3","Luisa4",
                                                    "Luisa5","Luisa6",
                                                    "Luisa7","Luisa8",
                                                    "Luisa9","Luisa10","Luisa11");                                               
        
        when(logsDAO.buscarTodos()).thenReturn(coleccion);
        Collection<String> ultimasDiez = logService.obtenerUltimosLogs();
        verify(logsDAO,times(1)).buscarTodos();
        assertEquals(10, ultimasDiez.size());
        assertEquals(aux, ultimasDiez);
    }




    
}

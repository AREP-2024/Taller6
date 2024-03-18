package edu.escuelaing.arep.ASE.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Test;
import org.mockito.Mockito;

import edu.escuelaing.arep.ASE.app.integracion.ClienteHttp;
import edu.escuelaing.arep.ASE.app.servicio.LogService;

public class LogServiceTest {

    @Test
    public void deberiaInvocar(){
        
        String info = "Hola soy puerto: 5000->info: Prueba-1";
        String devolverLlamado = "Prueba-1";
 
        ClienteHttp cliente = Mockito.mock(ClienteHttp.class);
        when(cliente.hacerLlamado(anyString(), anyString())).thenReturn(devolverLlamado);
 
        LogService logService = new LogService("http://localhost:5000/log", 5000, cliente);
 
        Collection<String> resultado = logService.invocar(info);
 
        assertEquals(1, resultado.size());
        assertEquals(devolverLlamado, resultado.iterator().next());

        
    }
    
}

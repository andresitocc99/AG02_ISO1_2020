package Dominio;

import java.util.Vector;

public class GestorIncidencia {
	public static int cerrarIncidencia(long i,String username) throws Exception{
		int cerrado=0;
			cerrado=Incidencia.cambiarIncidencia(i, username);
		
		return cerrado;
	}
	
	public static Vector<Incidencia> leerIncidenciasCliente(String username){
		Incidencia i= new Incidencia();
		i.readListIncidenciasCliente(username);
		return i.getIncidenciaList();
	}
}

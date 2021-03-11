package Dominio;

import java.util.Vector;



public class GestorTecnico {

	private Vector<Incidencia> IncidenciaList= new Vector<Incidencia>();
	
	public Vector<Incidencia> getIncidenciaList() {
		return IncidenciaList;
	}

	public void setIncidenciaList(Vector<Incidencia> incidenciaList) {
		IncidenciaList = incidenciaList;
	}


	public static Vector<Incidencia> leerIncidencias(){
		Incidencia i= new Incidencia();
		i.readListIncidenciasTecnico();
		return i.getIncidenciaList();
		
	}
}

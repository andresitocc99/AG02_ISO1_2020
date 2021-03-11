package Dominio;

import java.util.Vector;

import Persistencia.Agente;

public class Incidencia {

	private long ID_Incidencia;
	private String Username;
	private long ID_Tecnico;
	private int estado;
	private String Producto;
	private Vector<Incidencia> IncidenciaList= new Vector<Incidencia>();
	
	public Incidencia(long iD_Incidencia, String username, long iD_Tecnico, int estado, String producto) {
		super();
		ID_Incidencia = iD_Incidencia;
		Username = username;
		ID_Tecnico = iD_Tecnico;
		this.estado = estado;
		this.Producto = producto;
	}

	public Incidencia(long i) {
		ID_Incidencia= i;
	}

	public Incidencia() {
	}

	public long getID_Incidencia() {
		return ID_Incidencia;
	}

	public void setID_Incidencia(long iD_Incidencia) {
		ID_Incidencia = iD_Incidencia;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public long getID_Tecnico() {
		return ID_Tecnico;
	}

	public void setID_Tecnico(long iD_Tecnico) {
		ID_Tecnico = iD_Tecnico;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public void readListIncidenciasTecnico() {
		try {
		Vector<Vector<Object>> v =Agente.getAgente().leer("SELECT * FROM iso1.incidencias WHERE Estado=0 ;");
		for (int i = 0; i < v.size(); i++) {
			int idincidencia = (int) v.elementAt(i).elementAt(0);
			String username = (String) v.elementAt(i).elementAt(1);
			int IDTecnico = (int) v.elementAt(i).elementAt(2);	
			int Estado = (int) v.elementAt(i).elementAt(3);
			String Producto = (String) v.elementAt(i).elementAt(4);	
			Incidencia inci = new Incidencia(idincidencia,username,IDTecnico,Estado,Producto);
			IncidenciaList.add(inci);
		}
	}catch (Exception e) {
	System.err.println(e.getMessage());
	}
	}
		
	public void readListIncidenciasCliente(String usernam) {
		try {
		Vector<Vector<Object>> v =Agente.getAgente().leer("SELECT * FROM iso1.incidencias;");
		for (int i = 0; i < v.size(); i++) {
			int idincidencia = (int) v.elementAt(i).elementAt(0);
			String username = (String) v.elementAt(i).elementAt(1);
			int IDTecnico = (int) v.elementAt(i).elementAt(2);	
			int Estado = (int) v.elementAt(i).elementAt(3);
			String Producto = (String) v.elementAt(i).elementAt(4);	
			Incidencia inci = new Incidencia(idincidencia,username,IDTecnico,Estado,Producto);
			if (inci.getUsername().equals(usernam)&& inci.getEstado()==1){
				IncidenciaList.add(inci);
			}
		}
	}catch (Exception e) {
	System.err.println(e.getMessage());
	}


		}
	public Vector<Incidencia> getIncidenciaList() {
		return IncidenciaList;
	}

	public void setIncidenciaList(Vector<Incidencia> incidenciaList) {
		IncidenciaList = incidenciaList;
	}

	public int getEstado() {
		return estado;
	}

	public static int cambiarIncidencia(long ID, String username) throws Exception {
		int actualizado;
		actualizado= Agente.getAgente().cambiar("UPDATE iso1.incidencias SET `Estado` = '0' WHERE (`IDIncidencia` = '"+ID+"') AND Username='"+username+"';");
		return actualizado;
	}
	
}

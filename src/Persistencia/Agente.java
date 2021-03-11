package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Vector;

public class Agente {
	protected static Agente mInstancia = null;
	protected Connection mBD;

	protected Agente() throws Exception {
		String url="jdbc:mysql://localhost:3306/iso1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		mBD=DriverManager.getConnection(url,"alumno","alumno");
	}

	public static Agente getAgente() throws Exception {
		if (mInstancia==null) {
			mInstancia=new Agente();
		}
		return mInstancia;
	}
	
	//Lectura de la base de datos
	public Vector<Vector<Object>> leer(String SQL) throws Exception{
		Vector<Vector<Object>> vectoradevolver = null;
		try {
				Statement stmt = mBD.createStatement();
				vectoradevolver = new Vector<Vector<Object>>();
				ResultSet res=stmt.executeQuery(SQL);
				while (res.next()) {
					Vector<Object> aux=new Vector<Object>();
					//Bucle que agrega n columnas de la base de datos a vectoradevolver
					for (int i = 1;i<=(res.getMetaData().getColumnCount());i++) {
						aux.addElement(res.getObject(i));
					}
					vectoradevolver.add(aux);
				} //while
		} catch (Exception e) {
			throw e;
		}

		return vectoradevolver;

	}
	//Cambiar base de datos
	public int cambiar(String SQL) throws Exception{
		Statement stmt = mBD.createStatement();
	return stmt.executeUpdate(SQL);


	}
}

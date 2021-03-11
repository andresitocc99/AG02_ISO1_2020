package Dominio;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.cj.jdbc.Driver;

import Persistencia.Agente;



public class Usuario {
	
	protected String mUsername;
	protected String mPassword;
	protected String mEmail;
	protected int mTipoUsuario;
	
	
	//Constructor para la creaci—n de un objeto Usuario vacio
	public Usuario(){
		this.mUsername = null;
		this.mPassword = null;
		this.mEmail = null;
		this.mTipoUsuario = 5;
		
	}
	
	//Constructor para la creaci—n de un Usuario
	public Usuario(String Username, String password, String Email, int TipoUsuario){
		this.mUsername = Username;
		this.mPassword = password;
		this.mEmail = Email;
		this.mTipoUsuario = TipoUsuario;
	}
	
	public Usuario (String Username, String password) {
		this.mUsername = Username;
		this.mPassword = password;
	}
	
	public Usuario(String Username, String password, int TipoUsuario){
		this.mUsername = Username;
		this.mPassword = password;
		this.mTipoUsuario = TipoUsuario;
	}
	
	public Usuario(String Username){
		this.mUsername = Username;
	}
	//Selecci—n de un usuario de la base de datos a partir del login y el password
	@SuppressWarnings("unchecked")
	public static Usuario read(String login, String password, int tipoUsuario) throws Exception{

		Usuario u = null;
		Vector<Object> aux = null;
		Driver derbyEmbeddedDriver = new Driver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		Connection mBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/iso1?user=alumno&password=alumno&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		String SQL_Consulta = "SELECT login, pass, tipoUsuario FROM Usuario WHERE login = '"+login+"' AND pass = '"+password+"'AND tipoUsuario = '"+tipoUsuario+"';";
		Vector<Object> vectoradevolver=new Vector<Object>();
		Statement stmt = mBD.createStatement();
		ResultSet res=stmt.executeQuery(SQL_Consulta);
		while (res.next()) {
			aux=new Vector<Object>();
			aux.add(res.getObject(1));
			aux.add(res.getObject(2));
			aux.add(res.getObject(3));
			vectoradevolver.add(aux);
		}
    	stmt.close();
    	mBD.close();
		aux = new Vector<Object>();
		if (vectoradevolver.size() == 1){
			aux = (Vector<Object>) vectoradevolver.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1),(int) aux.elementAt(2));
		}
		return u;
	}
	
	public int insert() throws Exception{
		int res=Agente.getAgente().cambiar("INSERT INTO `iso1`.`usuario` (`login`, `pass`, `tipoUsuario`) VALUES ('"+this.mUsername+"', '"+this.mPassword+"', '1');");
		return res;
	}
	
	public int update () throws Exception{
		return 0;
	}
	
	public int  delete () throws Exception {
		int res= Agente.getAgente().cambiar("DELETE FROM `iso1`.`usuario` WHERE (`login` = '"+this.mUsername+"');");
		return res;
	}
	


	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public int ismTipoUsuario() {
		return mTipoUsuario;
	}

	public void setmTipoUsuario(int mTipoUsuario) {
		this.mTipoUsuario = mTipoUsuario;
	}
}


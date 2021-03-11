package Dominio;

public class GestorUsuario {
	
	public static int login(String Username, String password, String tipoUsuario) throws Exception{
		int autenticado = 0;
		
		
		if (tipoUsuario.equals("Cliente")) {
			if(Usuario.read(Username, password,1) != null)
				autenticado = 1;
		} else if (tipoUsuario.equals("Técnico")){
			if(Usuario.read(Username, password,0) != null)
				autenticado = 1;
			}
		
		return autenticado;
	}
	
	public static boolean nuevoUsuario(String Username, String password, String Email, int TipoUsuario) throws Exception{
		boolean insertado = false;
		
		Usuario u = new Usuario(Username, password, Email, TipoUsuario);
		if(u.insert() ==1)
			insertado = true;
		return insertado;		
	}
}
	

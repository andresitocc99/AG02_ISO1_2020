package Dominio;



public class Tecnico extends Usuario{
	
	private int mID_Tecnico;
	
	public Tecnico(String Username, String password, String Email, int TipoUsuario, int ID_Tecnico) {
		super(Username, password, Email, TipoUsuario);
		this.mID_Tecnico = ID_Tecnico;
	}

	public int getmID_Tecnico() {
		return mID_Tecnico;
	}

	public void setmID_Tecnico(int mID_Tecnico) {
		this.mID_Tecnico = mID_Tecnico;
	}

	
	

		
}

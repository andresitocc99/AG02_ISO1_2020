package Dominio;

public class Reclamacion {

	
	private Usuario Username;
	private String motivo;
	
	public Reclamacion(Usuario username, String motivo) {
		super();
		Username = username;
		this.motivo = motivo;
	}

	public Usuario getUsername() {
		return Username;
	}

	public void setUsername(Usuario username) {
		Username = username;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
}

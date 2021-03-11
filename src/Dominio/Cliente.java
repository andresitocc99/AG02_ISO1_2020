package Dominio;

public class Cliente extends Usuario{
	
	protected long mTarjeta;
	protected boolean mTipoCliente;
	
	public Cliente(String Username, String password, String Email, int TipoUsuario,long Tarjeta, boolean TipoCliente) {
		super(Username, password, Email, TipoUsuario);
		this.mTarjeta=Tarjeta;
		this.mTipoCliente=TipoCliente;
		
	}

	public long getmTarjeta() {
		return mTarjeta;
	}

	public void setmTarjeta(long mTarjeta) {
		this.mTarjeta = mTarjeta;
	}

	public boolean ismTipoCliente() {
		return mTipoCliente;
	}

	public void setmTipoCliente(boolean mTipoCliente) {
		this.mTipoCliente = mTipoCliente;
	}

}

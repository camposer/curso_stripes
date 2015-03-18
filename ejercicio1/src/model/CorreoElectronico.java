package model;

public class CorreoElectronico {
	private String usuario;
	private String dominio;
	
	public CorreoElectronico() {
	}
	
	
	public CorreoElectronico(String usuario, String dominio) {
		this.usuario = usuario;
		this.dominio = dominio;
	}


	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	@Override
	public String toString() {
		return "CorreoElectronico [usuario=" + usuario + ", dominio=" + dominio
				+ "]";
	}
}

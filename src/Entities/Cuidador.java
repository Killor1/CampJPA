package Entities;

public class Cuidador {
	
	private String dni;
	private String name;
	private String tlf;
	private String direccio;
	private String mail;
	
	public Cuidador (){
		
	}
	public Cuidador (String dni, String name, String tlf, String direccio, String mail){
		this.dni=dni;
		this.name=name;
		this.tlf=tlf;
		this.direccio=direccio;
		this.mail=mail;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getDireccio() {
		return direccio;
	}
	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		return "Cuidador [dni=" + dni + ", name=" + name + ", tlf=" + tlf + ", direccio=" + direccio + ", mail=" + mail
				+ "]";
	}	
}
package Entities;

import java.util.Date;

public class Nen {
	private int idNen;
	private String nom;
	private Date data_naix;
	private boolean menu_especial;
	private Cuidador cuidador;
	
	public Nen(){
		
	}
	public Nen(int idNen, String nom, Date data_naix, boolean menu_esp){
		this.idNen=idNen;
		this.nom=nom;
		this.data_naix = data_naix;
		this.menu_especial=menu_esp;
		
	}
	public Nen(int idNen, String nom, Date data_naix, boolean menu_esp, Cuidador cuidador){
		this.idNen=idNen;
		this.nom=nom;
		this.data_naix = data_naix;
		this.menu_especial=menu_esp;
		this.cuidador=cuidador;
	}
	
	public int getIdNen() {
		return idNen;
	}
	public void setIdNen(int idNen) {
		this.idNen = idNen;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getData_naix() {
		return data_naix;
	}
	public void setData_naix(Date data_naix) {
		this.data_naix = data_naix;
	}
	public boolean isMenu_especial() {
		return menu_especial;
	}
	public void setMenu_especial(boolean menu_especial) {
		this.menu_especial = menu_especial;
	}
	public Cuidador getCuidador() {
		return cuidador;
	}
	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}
	
	@Override
	public String toString() {
		return "Nen [idNen=" + idNen + ", nom=" + nom + ", data_naix=" + data_naix + ", menu_especial=" + menu_especial
				+ ", cuidador=" + cuidador + "]";
	}
	
}

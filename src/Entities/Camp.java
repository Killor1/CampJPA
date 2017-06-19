package Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Camp {
	private int id;	
	private String localitzacio;
	private Date data_ini, data_fi;
	private Set<Activitats> activitats = new HashSet<Activitats>();
	
	public Camp(){
		
	}	
	public Camp(int id,  String localitzacio,Date data_ini, Date data_fi, Set<Activitats> activitats) {
		this.id = id;		
		this.localitzacio = localitzacio;
		this.data_ini=data_ini;
		this.data_fi=data_fi;
		this.activitats = activitats;
	}
	public Camp(int id, String localitzacio,Date data_ini, Date data_fi) {
		this.id = id;		
		this.localitzacio = localitzacio;
		this.data_ini=data_ini;
		this.data_fi=data_fi;		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocalitzacio() {
		return localitzacio;
	}
	public void setLocalitzacio(String localitzacio) {
		this.localitzacio = localitzacio;
	}
	public Date getData_ini() {
		return data_ini;
	}
	public void setData_ini(Date data_ini) {
		this.data_ini = data_ini;
	}
	public Date getData_fi() {
		return data_fi;
	}
	public void setData_fi(Date data_fi) {
		this.data_fi = data_fi;
	}
	public Set<Activitats> getActivitats() {
		return activitats;
	}
	public void setActivitats(Set<Activitats> activitats) {
		this.activitats = activitats;
	}	

	@Override
	public String toString() {
		return "Camp [id=" + id +  ", localitzacio=" + localitzacio + ", activitats="
				+ activitats + "]";
	}
	
	
}

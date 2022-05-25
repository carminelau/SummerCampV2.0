package model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class customCentroSettimana implements Serializable{
	public customCentroSettimana(Centro centro, List<Settimana> settimane) {
		super();
		this.centro = centro;
		this.settimane = settimane;
	}
	
	public customCentroSettimana() {
		
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public List<Settimana> getSettimane() {
		return settimane;
	}
	public void setSettimane(List<Settimana> settimane) {
		this.settimane = settimane;
	}
	private Centro centro;
	private List<Settimana> settimane;
}

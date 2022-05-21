package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;

import static model.entity.Centro.FIND_ALL_CENTER;


/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity
@Table(name="centro")
@NamedQueries({
	@NamedQuery(name=FIND_ALL_CENTER, query="SELECT i FROM Centro i")
})
public class Centro implements Serializable{
	
	public static final String FIND_ALL_CENTER = "Centro.findAll";
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Centro() {
	}
	
	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getCapienzatotale() {
		return capienzatotale;
	}
	public void setCapienzatotale(int capienzatotale) {
		this.capienzatotale = capienzatotale;
	}
	@Id
	private int idCentro;
	private String denominazione;
	private String indirizzo;
	private int capienzatotale;
}

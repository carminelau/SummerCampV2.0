package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;

import static model.entity.Centro.FIND_ALL_CENTER;
import static model.entity.Centro.FIND_BY_ID;
import static model.entity.Centro.FIND_BY_NAME;


/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity
@Table(name="centro")
@NamedQueries({
	@NamedQuery(name=FIND_ALL_CENTER, query="SELECT i FROM Centro i"),
	@NamedQuery(name=FIND_BY_NAME, query="SELECT i FROM Centro i WHERE i.denominazione=:denominazione "),
	@NamedQuery(name=FIND_BY_ID, query="SELECT i FROM Centro i WHERE i.idCentro=:idCentro "),
})
public class Centro implements Serializable{
	
	public static final String FIND_ALL_CENTER = "centro.findAll";
	public static final String FIND_BY_NAME = "centro.findByName";
	public static final String FIND_BY_ID = "centro.findById";
	
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
	public int getCapienzaTot() {
		return capienzaTot;
	}
	public void setCapienzaTot(int capienzaTot) {
		this.capienzaTot = capienzaTot;
	}
	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCentro;
	private String denominazione;
	private String indirizzo;
	private int capienzaTot;
	private String comune;
	private String provincia;

	public static boolean matches(Centro c) {
		if((c.getDenominazione()==null)
			|| c.getComune() == null
			|| c.getProvincia()== null
			|| c.getCapienzaTot() < -1) {
			return false;
		}
		else return true;
		
		}
}

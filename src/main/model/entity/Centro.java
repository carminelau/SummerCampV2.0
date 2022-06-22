package main.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import static main.model.entity.Centro.FIND_ALL_CENTER;
import static main.model.entity.Centro.FIND_BY_ID;
import static main.model.entity.Centro.FIND_BY_NAME;


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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCentro;
	private String denominazione;
	private String indirizzo;
	private int capienzaTot;
	private String comune;
	private String provincia;
	private int cancellato;

	public int isCancellato() {
		return cancellato;
	}

	public void setCancellato(int cancellato) {
		this.cancellato = cancellato;
	}

	public static boolean matches(Centro c) {
		if(c.getDenominazione()== null
			|| c.getDenominazione().isBlank()
			|| c.getComune() == null
			|| c.getComune().isBlank()
			|| c.getProvincia()== null
			|| c.getProvincia().isBlank()
			|| c.getIndirizzo() == null
			|| c.getIndirizzo().isBlank()
			|| c.getCapienzaTot() <= 0) {
			return false;
		}
		else return true;
		
		}
}

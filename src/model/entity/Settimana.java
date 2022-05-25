package model.entity;

import static model.entity.Settimana.FIND_BY_SETTIMANE_DISPONIBILI;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Settimana
 *
 */
@Entity
@Table(name="settimana")
@NamedQueries({
	@NamedQuery(name=FIND_BY_SETTIMANE_DISPONIBILI, query="SELECT s FROM Settimana s, CentroSettimana cs WHERE s.idSettimana = cs.idsettimana AND cs.disponibilita >0")
})
public class Settimana implements Serializable {

	@Override
	public String toString() {
		return "Settimana dal " + dataInizio.toString().substring(8, 10) + "-" + dataInizio.toString().substring(5, 7) + " al " + dataFine.toString().substring(8, 10) + "-" + dataFine.toString().substring(5, 7);
	}


	public Settimana() {
	}
	
	
	public int getIdSettimana() {
		return idSettimana;
	}


	public void setIdSettimana(int idSettimana) {
		this.idSettimana = idSettimana;
	}


	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}


	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}


	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}


	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_SETTIMANE_DISPONIBILI = "Settimana.findBySettimaneDisponibili";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSettimana;
	private Date dataInizio;
	private Date dataFine;
	@ManyToMany(mappedBy="settimane")
	private List<Iscrizione> iscrizioni;
   
}
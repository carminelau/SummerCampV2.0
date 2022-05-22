package model.entity;

import static model.entity.CentroSettimana.FIND_WEEKS_AVAILABLE_BY_CENTER;
import static model.entity.CentroSettimana.GET_AVAILABLE_BY_WEEK_AND_CENTER;
import static model.entity.CentroSettimana.FIND_CENTERS_AVAILABLES_BY_WEEK;
import static model.entity.CentroSettimana.FIND_ALL_CENTRISETTIMANA;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="centrosettimana")
@NamedQueries({
	@NamedQuery(name=FIND_WEEKS_AVAILABLE_BY_CENTER, query="SELECT i FROM CentroSettimana i WHERE i.idcentro=:idcent"),
	@NamedQuery(name=GET_AVAILABLE_BY_WEEK_AND_CENTER, query="SELECT i FROM CentroSettimana i WHERE i.idsettimana=:idsett AND i.idcentro=:idcent "),
	@NamedQuery(name=FIND_CENTERS_AVAILABLES_BY_WEEK, query="SELECT i FROM CentroSettimana i WHERE i.idsettimana=:idsett AND i.disponibilita > 0"),
	@NamedQuery(name=FIND_ALL_CENTRISETTIMANA, query="SELECT i FROM CentroSettimana i")
})

public class CentroSettimana implements Serializable{
	
	public static final String FIND_WEEKS_AVAILABLE_BY_CENTER = "CentroSettimana.findByWeek";
	public static final String GET_AVAILABLE_BY_WEEK_AND_CENTER = "CentroSettimana.getAvailableByWeekAndCenter";
	public static final String FIND_CENTERS_AVAILABLES_BY_WEEK = "CentroSettimana.findCentersAvailablesByWeek";
	public static final String FIND_ALL_CENTRISETTIMANA = "CentroSettimana.findAllCentriSettimana";

	public int getIdcentro() {
		return idcentro;
	}

	public void setIdcentro(int idcentro) {
		this.idcentro = idcentro;
	}

	public int getIdsettimana() {
		return idsettimana;
	}

	public void setIdsettimana(int idsettimana) {
		this.idsettimana = idsettimana;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	
	private int idcentro;
	
	private int idsettimana;
	
	private int disponibilita;
	
	@Id
	private int id;

}

package model.dao;

import java.util.List;

import model.entity.Centro;

public interface CentroManage {
	
	/**
	 * Ritorna una settimana dato l'id
	 * @return Settimana, altrimenti null
	 */
	Centro getCentro(int id);
	Centro getCentro(String denominazione);
	List<Centro> getCentri();

}

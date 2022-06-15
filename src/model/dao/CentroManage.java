package model.dao;

import java.util.List;

import model.entity.Centro;

public interface CentroManage {
	
	/**
	 * Ritorna un centro dato l'id
	 * @return Centro, altrimenti null
	 */
	Centro getCentro(int id);
	/**
	 * Ritorna un centro data la denominazione
	 * @return Centro, altrimenti null
	 */
	Centro getCentro(String denominazione);
	/**
	 * Ritorna tutti i centri
	 * @return List<Centro>
	 */
	List<Centro> getCentri();
	
	void inserisciCentro(Centro c);
	
	void setCencellato(int centro);

}

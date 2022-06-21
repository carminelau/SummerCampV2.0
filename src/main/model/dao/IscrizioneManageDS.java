package main.model.dao;

import static main.model.entity.Iscrizione.FIND_ISCRIZIONE_BY_CENTRO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;

import main.listener.LocalEntityManagerFactory;
import main.model.entity.Iscrizione;

public class IscrizioneManageDS implements IscrizioneManage {
	
	public IscrizioneManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	public IscrizioneManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}	
	public void close(){
		em.close();
	}
	
	public void save(Iscrizione i) throws PersistenceException {
		if(i!=null) {
			if(Iscrizione.matches(i) && i.getCentro()!= null) {
				em.getTransaction().begin();
				em.persist(i);
				em.getTransaction().commit();
			} else throw new IllegalArgumentException("I campi non rispettano i controlli");
			
		}
	}

	@Override
	public List<Iscrizione> getIscrizioniByGenitore(String cfGenitore) {
	try {
		return em.createNamedQuery(Iscrizione.FIND_ISCRIZIONE_BY_GENITORE, Iscrizione.class)
				.setParameter("cfGenitore", cfGenitore).getResultList();
	
	} finally {
		close();
		}
	}


	@Override
	public List<Iscrizione> getAll() {
	try {
		return em.createNamedQuery(Iscrizione.FIND_ALL, Iscrizione.class).getResultList();
	} finally {
			close();
			}
	}
	
	
	@Override
	public Iscrizione getIscrizione(int idIscrizione) {
	try {
		return em.createNamedQuery(Iscrizione.FIND_ISCRIZIONE, Iscrizione.class)
				.setParameter("idIscrizione", idIscrizione).getSingleResult();
	} finally {
			close();
	}
	}
	
	
	private EntityManager em;

	@Override
	public List<Iscrizione> getIscrizioneByCentro(int id) {
		try {
			return em.createNamedQuery(Iscrizione.FIND_ISCRIZIONE_BY_CENTRO, Iscrizione.class)
					.setParameter("idcent", id).getResultList();
		} finally {
				close();
		}
	}

	

}

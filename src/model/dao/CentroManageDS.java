package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import listener.LocalEntityManagerFactory;
import model.entity.Bambino;
import model.entity.Centro;
import model.entity.CentroSettimana;
import model.entity.Iscrizione;

public class CentroManageDS implements CentroManage{
	
	private EntityManager em;
	
	public CentroManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	public CentroManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public Centro getCentro(int id) {
		try {
			TypedQuery<Centro> query = em.createNamedQuery(Centro.FIND_BY_ID, Centro.class);
			query.setParameter("idCentro", id);
			
			Centro re = query.getSingleResult();
			return re;
		} finally {
				em.close();
				}
	}

	@Override
	public Centro getCentro(String denominazione) {
		try {
			TypedQuery<Centro> query = em.createNamedQuery(Centro.FIND_BY_NAME, Centro.class);
			query.setParameter("denominazione", denominazione);
			
			Centro re = (Centro) query.getSingleResult();
			return re;
		} finally {
				em.close();
				}
	}

	@Override
	public List<Centro> getCentri() {
		try {
			return em.createNamedQuery(Centro.FIND_ALL_CENTER, Centro.class).getResultList();
		} finally {
				close();
				}
	}
	
	public void close(){
		em.close();
	}
	

}

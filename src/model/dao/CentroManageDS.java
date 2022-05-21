package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import listener.LocalEntityManagerFactory;
import model.entity.Bambino;
import model.entity.Centro;
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
		return em.find(Centro.class,id);
	}

	@Override
	public Centro getCentro(String denominazione) {
		return em.find(Centro.class,denominazione);
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

package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import listener.LocalEntityManagerFactory;
import model.entity.Centro;
import model.entity.CentroSettimana;
import model.entity.Settimana;

public class CentroSettimanaManageDS implements CentroSettimanaManage{
	
	
private EntityManager em;
	
	public CentroSettimanaManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	public CentroSettimanaManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public int getDisponibilita(int s, int c) {
		try {
			TypedQuery<CentroSettimana> query = (TypedQuery<CentroSettimana>) em.createNamedQuery(CentroSettimana.GET_AVAILABLE_BY_WEEK_AND_CENTER);
			query.setParameter("idsett", s);
			query.setParameter("idcent", c);
			
			CentroSettimana re = query.getSingleResult();
			return re.getDisponibilita();
		} finally {
				em.close();
				}
	}

	@Override
	public List<Settimana> getSettimaneDisponibilibyCentro(int c) {
		try {
			TypedQuery<Settimana> query = (TypedQuery<Settimana>) em.createNamedQuery(CentroSettimana.FIND_WEEKS_AVAILABLE_BY_CENTER);
			query.setParameter("idcent", c);
			
			List<Settimana> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}

	@Override
	public List<Centro> getCentriDisponibilibySettimana(int s) {
		try {
			TypedQuery<Centro> query = (TypedQuery<Centro>) em.createNamedQuery(CentroSettimana.FIND_CENTERS_AVAILABLES_BY_WEEK);
			query.setParameter("idsett", s);
			
			List<Centro> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}
	@Override
	public List<CentroSettimana> getCentriSettimana() {
		try {
			TypedQuery<CentroSettimana> query = (TypedQuery<CentroSettimana>) em.createNamedQuery(CentroSettimana.FIND_ALL_CENTRISETTIMANA);
			
			List<CentroSettimana> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}

}

package main.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import main.listener.LocalEntityManagerFactory;
import main.model.entity.Utente;

public class UtenteManageDS implements UtenteManage {

	
	public UtenteManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	
	public UtenteManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	public void close(){
		em.close();
	}
	
	@Override
	public Utente getUserIfExists(String email, String password) throws NoResultException {
		if(!email.matches("\\S+@\\S+\\.\\S+") 
				|| !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
			return null;
		}
		
		try {
			return (Utente) em.createQuery("SELECT u FROM Utente u WHERE email=:email AND password=:password")
					.setParameter("email", email).setParameter("password", password).getSingleResult();
			
		} catch(NoResultException e) {
			return null;
		} finally {
			close();
		} 
	}
	
	public void save(Utente u) throws PersistenceException {
		if(u!=null) {
			if(Utente.matches(u)) {
				em.getTransaction().begin();
				em.persist(u);
				em.flush();
				em.getTransaction().commit();
			}
		} else throw new IllegalArgumentException("Errore sui campi inseriti");
		
	}
	
	private static final String TABLE_NAME = "utente";
	
	private EntityManager em;

}

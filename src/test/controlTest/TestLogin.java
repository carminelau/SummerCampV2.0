package controlTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyString;

import junit.framework.TestCase;
import main.model.dao.UtenteManageDS;
import main.model.entity.Genitore;
import main.model.entity.Utente;

public class TestLogin extends TestCase {

	public TestLogin() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public void setup(){
	}
	
	public void testGetUserIfExists1(){
		entityManager =  Mockito.mock(EntityManager.class);
		userManage = new UtenteManageDS(entityManager);
		query = Mockito.mock(Query.class);
		utente = Mockito.mock(Utente.class);
		
		String email = "mariorossi@gmail.com";
		String password = "Mario2020@";
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);

		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);

		Mockito.when(query.getSingleResult()).thenReturn(utente);
		
		utente = userManage.getUserIfExists(email, password);
		
		assertNotNull(utente);
	}
	
	public void testGetUserIfExists2(){
		entityManager =  Mockito.mock(EntityManager.class);
		userManage = new UtenteManageDS(entityManager);
		query = Mockito.mock(Query.class);
		utente = Mockito.mock(Utente.class);
		
		String email = "mariorossi@gmail.com";
		String password = "Mario2020@";
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);

		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);

		Mockito.when(query.getSingleResult()).thenReturn(utente);
		
		utente = userManage.getUserIfExists(email, password);
		
		assertNotNull(utente);
	}
	
	private EntityManager entityManager;
	private UtenteManageDS userManage;
	private Utente utente;
	private Query query;

}

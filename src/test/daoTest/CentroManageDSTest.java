package test.daoTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;
import main.model.dao.CentroManageDS;
import main.model.entity.Centro;

public class CentroManageDSTest extends TestCase{

	@Before
	public void setUp() {
		entityManager = Mockito.mock(EntityManager.class);
		cen= new CentroManageDS(entityManager);
		query = Mockito.mock(Query.class);
		transaction = Mockito.mock(EntityTransaction.class);
		
		
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
		
	}
	
	
	@After
	public void tearDown() {
		entityManager.close();
		cen.close();
	}
	
	@Test
	public void test1InserimentoCorretto() {
		c.setDenominazione("CentroNuovo");
		c.setComune("Salerno");
		c.setIndirizzo("Via Indirizzo");
		c.setCapienzaTot(30);
		c.setProvincia("Salerno");
		
		cen.inserisciCentro(c);
	}
	
	@Test
	public void test2InserimentoConDenominazioneAssente() {
		c.setComune("Salerno");
		c.setIndirizzo("Via Indirizzo");
		c.setCapienzaTot(30);
		c.setProvincia("Salerno");
		
		try {
			cen.inserisciCentro(c);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void test3InserimentoConComuneAssente() {
		c.setDenominazione("CentroNuovo");
		c.setIndirizzo("Via Indirizzo");
		c.setCapienzaTot(30);
		c.setProvincia("Salerno");
		
		try {
			cen.inserisciCentro(c);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void test3InserimentoConIndirizzoAssente() {
		c.setDenominazione("CentroNuovo");
		c.setComune("Salerno");
		c.setCapienzaTot(30);
		c.setProvincia("Salerno");
		
		try {
			cen.inserisciCentro(c);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void test4InserimentoConProvinciaAssente() {
		c.setDenominazione("CentroNuovo");
		c.setIndirizzo("Via Indirizzo");
		c.setCapienzaTot(30);
		c.setProvincia("Salerno");
		
		try {
			cen.inserisciCentro(c);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void test5InserimentoConCapienzaUguale0() {
		c.setDenominazione("CentroNuovo");
		c.setIndirizzo("Via Indirizzo");
		c.setComune("Salerno");
		c.setProvincia("Salerno");
		c.setCapienzaTot(0);
		
		try {
			cen.inserisciCentro(c);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	private EntityManager entityManager;
	private Query query;
	private EntityTransaction transaction;
	private CentroManageDS cen;
	private Centro c = new Centro();
}

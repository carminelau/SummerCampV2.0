package test.daoTest;

import java.util.GregorianCalendar;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import main.model.dao.IscrizioneManageDS;
import main.model.entity.Bambino;
import main.model.entity.Centro;
import main.model.entity.Genitore;
import main.model.entity.Iscrizione;
import main.model.entity.Settimana;

import org.junit.Test;

public class IscrizioneManageDSTest extends TestCase{

	@Before
	public void setUp() {
		entityManager = Mockito.mock(EntityManager.class);
		isc= new IscrizioneManageDS(entityManager);
		query = Mockito.mock(Query.class);
		transaction = Mockito.mock(EntityTransaction.class);
		settimana= Mockito.mock(Settimana.class);
		genitore=Mockito.mock(Genitore.class);
		bambino=Mockito.mock(Bambino.class);
		
		listaSett= new ArrayList<Settimana>();
		listaSett.add(settimana);
		
		centro = Mockito.mock(Centro.class);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
		
	}
	
	
	@After
	public void tearDown() {
		entityManager.close();
		isc.close();
	}
	
	@Test
	public void testIscrizione1Corretto() {
		
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);
		i.setCentro(centro);
		i.setSettimane(listaSett);
		
	
		isc.save(i);
		
	}
	
	@Test
	public void testIscrizione2TipoDiSoggiornoNonSelezionato() {
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("");
		i.setPagata(false);	
		i.setCentro(centro);
		i.setSettimane(listaSett);		
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testIscrizione3SettimaneNonSelezionate() {
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);
		i.setCentro(centro);
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testIscrizione4CentroNonSelezionato() {
		i.setBambino(bambino);
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);
		i.setSettimane(listaSett);
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
		}
		
	}
	
	@Test
	public void testIscrizione5BambinoNonSpecificato() {
		i.setIdIscrizione(1);
		i.setDataIscrizione(data.getTime());
		i.setQrCode("QRcode");
		i.setPrezzo(100);
		i.setRichiestaDisdetta(false);
		i.setRimborsoDisdetta(0);
		i.setServizioSportivo(true);
		i.setTipoSoggiorno("Part-Time");
		i.setPagata(false);
		i.setSettimane(listaSett);
		i.setCentro(centro);;
		
		
		try {
			isc.save(i);
			fail("Dovrebbe esserci Illegal Argument Exception");
		}catch(IllegalArgumentException e) {
		}
		
	}
	
	private Centro centro;
	private Bambino bambino;
	private Genitore genitore;
	private Settimana settimana;
	private List<Settimana> listaSett;
	private Iscrizione i=new Iscrizione();
	private GregorianCalendar data= new GregorianCalendar(2020,1,20);
	private IscrizioneManageDS isc;
	private EntityManager entityManager;
	private Query query;
	private EntityTransaction transaction;
}

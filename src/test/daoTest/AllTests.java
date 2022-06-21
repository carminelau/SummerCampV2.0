package daoTest;

import daoTest.BambinoManageDSTest;
import daoTest.UtenteManageDSTest;
import junit.framework.*;
import junit.textui.TestRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(value=Suite.class)
@SuiteClasses(value={BambinoManageDSTest.class, IscrizioneManageDSTest.class, UtenteManageDSTest.class, CentroManageDSTest.class})
public class AllTests extends TestSuite{

	/*
	 * Ho modificato l'aspetto di questa classe allTests rispetto a quella indicata poich� 
	 * non era possibile seguire il pattern iniziale(errori di vario tipo, non eseguibilit� della suite)
	 */
	
	/*
	 * public static TestSuite suite() { TestSuite suite = new TestSuite();
	 * suite.addTest(BambinoManageDSTest.suite());
	 * suite.addTest(IscrizioneManageDSTest.suite());
	 * suite.addTest(UtenteManageDSTest.suite()); return suite; }
	 * 
	 * public static TestSuite suite;
	 * 
	 * 
	 * public static void main(String args[]) {
	 * 
	 * TestRunner.run(suite); }
	 */
}

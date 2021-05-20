package sopra.pokebowl.test;

import org.junit.Test;

public class TestJUnitGlobal {

	@Test
	public void globalTest() {
		TestJUnitSalon testSalon = new TestJUnitSalon();
		TestJUnitUtilisateur testUtilisateur = new TestJUnitUtilisateur();
		TestJUnitCombat testCombat = new TestJUnitCombat();
		
		testSalon.salonCreate(); 
		testSalon.salonUpdate(); 
		testSalon.salonFindAllAndDelete();
		
		testUtilisateur.utilisateurCreate(); 
		testUtilisateur.utilisateurUpdate();
		testUtilisateur.utilisateurFindAllAndDelete(); 
		
		testCombat.combatCreate();
		testCombat.combatUpdate();
		testCombat.combatFindAllAndDelete(); 
	} 
}

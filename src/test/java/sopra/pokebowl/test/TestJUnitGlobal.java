package sopra.pokebowl.test;

import org.junit.Test;

public class TestJUnitGlobal {

	@Test
	public void globalTest() {
		
		TestJUnitSalon testSalon = new TestJUnitSalon();
		TestJUnitUtilisateur testUtilisateur = new TestJUnitUtilisateur();
		TestJUnitCombat testCombat = new TestJUnitCombat();  
		TestJUnitTour testTour = new TestJUnitTour();
		TestJUnitPokemonMatch testPokemonMatch = new TestJUnitPokemonMatch();
		
		testSalon.salonCreate(); 
		testSalon.salonUpdate(); 
		testSalon.salonFindAllAndDelete(); 
		
		testTour.tourCreate();
		testTour.tourUpdate();
		testTour.tourFindAllAndDelete();  
		
		testPokemonMatch.pokemonMatchCreate();
		testPokemonMatch.pokemonMatchUpdate();
		testPokemonMatch.pokemonMatchFindAllAndDelete();  
		
		testCombat.combatCreate();
		testCombat.combatUpdate();
		testCombat.combatFindAllAndDelete(); 
		
		testUtilisateur.utilisateurCreate(); 
		testUtilisateur.utilisateurUpdate();
		testUtilisateur.utilisateurFindAllAndDelete();    
		
	} 
}

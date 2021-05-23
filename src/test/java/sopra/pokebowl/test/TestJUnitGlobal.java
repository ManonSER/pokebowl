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
		TestJUnitEquipe testEquipe = new TestJUnitEquipe();
		TestJUnitMonPokemon testMonPokemon = new TestJUnitMonPokemon();
		TestJUnitTypeClass testTypeClass = new TestJUnitTypeClass();
		
		testSalon.salonCreate(); 
		testSalon.salonUpdate(); 
		testSalon.salonFindAllAndDelete(); 
		testSalon.salonFindSalonWithMDP();
		
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
		testUtilisateur.testFindPseudoMailAvatarStatsById();
		testUtilisateur.testFindAvatarsPokeAllEquipesById();
		
		testEquipe.equipeCreate();
		testEquipe.equipeUpdate();
		testEquipe.equipeFindById();
		testEquipe.equipeFindAllAndDelete();  
		testEquipe.equipeFindEquipeByUtilisateurId();
		
		testMonPokemon.monPokeCreate();
		testMonPokemon.monPokeUpdate();
		testMonPokemon.monPokeFindById();
		testMonPokemon.monPokeFindAllAndDelete();
		
		testTypeClass.typeClassCreate();
		testTypeClass.typeClassUpdate();
		testTypeClass.typeClassFindById();
		testTypeClass.typeClassFindAllAndDelete();
		
		
	} 
}

package sopra.pokebowl.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Statut;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;

public class TestJUnitPokemonMatch {
	
	@Test
	public void pokemonMatchCreate() {
		IPokemonMatchRepository pokemonMatchRepo = Application.getInstance().getPokemonMatchRepo();
		ICombatRepository combatRepo = Application.getInstance().getCombatRepo();
		IMonPokemonRepository monPokemonRepo = Application.getInstance().getMonPokemonRepo();
		
		MonPokemon monPokemon = new MonPokemon();
		monPokemon = monPokemonRepo.save(monPokemon);
		
		Combat combat = new Combat();
		combat = combatRepo.save(combat);
		
		PokemonMatch pokemonMatch = new PokemonMatch();
		pokemonMatch.setHpMatch(200);
		pokemonMatch.setAttackMatch(23);
		pokemonMatch.setDefenseMatch(5);
		pokemonMatch.setSpecialAttackMatch(78);
		pokemonMatch.setSpecialDefenseMatch(34);
		pokemonMatch.setSpeedMatch(12);
		pokemonMatch.setNumAttaqueActive(1);
		pokemonMatch.setStatut(Statut.EMPOISONNE);
		pokemonMatch.setPpAttaque1(4);
		pokemonMatch.setPpAttaque2(3);
		pokemonMatch.setPpAttaque3(0);
		pokemonMatch.setPpAttaque4(12);
		pokemonMatch.setCombat(combat);
		pokemonMatch.setMonPokemon(monPokemon);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		PokemonMatch pokemonMatchFind = pokemonMatchRepo.findById(pokemonMatch.getNumero());
		
		Assert.assertEquals(200, pokemonMatchFind.getHpMatch());
		Assert.assertEquals(23, pokemonMatchFind.getAttackMatch());
		Assert.assertEquals(5, pokemonMatchFind.getDefenseMatch());
		Assert.assertEquals(78, pokemonMatchFind.getSpecialAttackMatch());
		Assert.assertEquals(34, pokemonMatchFind.getSpecialDefenseMatch());
		Assert.assertEquals(12, pokemonMatchFind.getSpeedMatch());
		Assert.assertEquals(1, pokemonMatchFind.getNumAttaqueActive());
		Assert.assertEquals(Statut.EMPOISONNE, pokemonMatchFind.getStatut());
		Assert.assertEquals(4, pokemonMatchFind.getPpAttaque1());
		Assert.assertEquals(3, pokemonMatchFind.getPpAttaque2());
		Assert.assertEquals(0, pokemonMatchFind.getPpAttaque3());
		Assert.assertEquals(12, pokemonMatchFind.getPpAttaque4());
		Assert.assertEquals(combat.getId(), pokemonMatchFind.getCombat().getId());
		Assert.assertEquals(monPokemon.getId(), pokemonMatchFind.getMonPokemon().getId());
		
		pokemonMatchRepo.delete(pokemonMatch);
		combatRepo.delete(combat);
		monPokemonRepo.delete(monPokemon);
	}
	
	@Test
	public void pokemonMatchUpdate() {
		IPokemonMatchRepository pokemonMatchRepo = Application.getInstance().getPokemonMatchRepo();
		
		PokemonMatch pokemonMatch = new PokemonMatch();
		pokemonMatch.setHpMatch(200);
		pokemonMatch.setAttackMatch(23);
		pokemonMatch.setDefenseMatch(5);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		pokemonMatch.setHpMatch(120);
		pokemonMatch.setAttackMatch(15);
		pokemonMatch.setDefenseMatch(32);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		PokemonMatch pokemonMatchFind = pokemonMatchRepo.findById(pokemonMatch.getNumero());
		
		Assert.assertEquals(120, pokemonMatchFind.getHpMatch());
		Assert.assertEquals(15, pokemonMatchFind.getAttackMatch());
		Assert.assertEquals(32, pokemonMatchFind.getDefenseMatch());
		
		pokemonMatchRepo.delete(pokemonMatch);
	}
	
	@Test
	public void pokemonMatchFindAllAndDelete() {
		IPokemonMatchRepository pokemonMatchRepo = Application.getInstance().getPokemonMatchRepo();
		
		PokemonMatch pokemonMatch1 = new PokemonMatch();
		PokemonMatch pokemonMatch2 = new PokemonMatch();
		PokemonMatch pokemonMatch3 = new PokemonMatch();   
		PokemonMatch pokemonMatch4 = new PokemonMatch();
		
		pokemonMatch1 = pokemonMatchRepo.save(pokemonMatch1);
		pokemonMatch2 = pokemonMatchRepo.save(pokemonMatch2);
		pokemonMatch3 = pokemonMatchRepo.save(pokemonMatch3);
		pokemonMatch4 = pokemonMatchRepo.save(pokemonMatch4);
		
		List<PokemonMatch> pokemons = pokemonMatchRepo.findAll();
		
		Assert.assertEquals(4, pokemons.size());
		
		pokemonMatchRepo.delete(pokemonMatch1);
		pokemonMatchRepo.delete(pokemonMatch2);
		pokemonMatchRepo.delete(pokemonMatch3);
		pokemonMatchRepo.delete(pokemonMatch4);
		
		pokemons = pokemonMatchRepo.findAll();
		
		Assert.assertEquals(0, pokemons.size());
	}
}

package sopra.pokebowl.test;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;
import sopra.pokebowl.repository.IPokemonRepository;

public class TestJUnitMonPokemon {

	@Test
	public void monPokemonCreate() {
		IMonPokemonRepository monPokemonRepo = Application.getInstance().getMonPokemonRepo();
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		IAttaqueRepository attaqueRepo = Application.getInstance().getAttaqueRepo();
		IPokemonMatchRepository pokemonMatchRepo = Application.getInstance().getPokemonMatchRepo();
		
		Equipe equipe = new Equipe();
		equipe = equipeRepo.save(equipe);
		
		Pokemon pokemon = new Pokemon();
		pokemon = pokemonRepo.save(pokemon);
		
		Attaque attaque1 = new Attaque();
		Attaque attaque2 = new Attaque();
		Attaque attaque3 = new Attaque();
		Attaque attaque4 = new Attaque();
		attaque1 = attaqueRepo.save(attaque1);
		attaque2 = attaqueRepo.save(attaque2);
		attaque3 = attaqueRepo.save(attaque3);
		attaque4 = attaqueRepo.save(attaque4);
		
		PokemonMatch pokemonMatch = new PokemonMatch();
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		MonPokemon monPokemon = new MonPokemon();
		monPokemon.setOrdre(4);
		monPokemon.setEquipe(equipe);
		monPokemon.setPokeReference(pokemon);
		monPokemon.setAttaque1(attaque1);
		monPokemon.setAttaque2(attaque2);
		monPokemon.setAttaque3(attaque3);
		monPokemon.setAttaque4(attaque4);
		//monPokemon.setPokeMatch(pokemonMatch);
	
		monPokemon = monPokemonRepo.save(monPokemon);
		
		MonPokemon monPokemonFind = monPokemonRepo.findById(monPokemon.getId());
		
		Assert.assertEquals((Integer)4, monPokemonFind.getOrdre());
		Assert.assertEquals(equipe.getId(), monPokemonFind.getEquipe().getId());
		Assert.assertEquals(pokemon.getId(), monPokemonFind.getPokeReference().getId());
		//Assert.assertEquals(pokemonMatch.getNumero(), monPokemonFind.getPokeMatch().getNumero());
		Assert.assertEquals(attaque1.getId(), monPokemonFind.getAttaque1().getId());
		Assert.assertEquals(attaque2.getId(), monPokemonFind.getAttaque2().getId());
		Assert.assertEquals(attaque3.getId(), monPokemonFind.getAttaque3().getId());
		Assert.assertEquals(attaque4.getId(), monPokemonFind.getAttaque4().getId());
		
		
		monPokemonRepo.delete(monPokemonFind);
		equipeRepo.delete(equipe);
		pokemonRepo.delete(pokemon);
		pokemonMatchRepo.delete(pokemonMatch);
		attaqueRepo.delete(attaque1);
		attaqueRepo.delete(attaque2);
		attaqueRepo.delete(attaque3);
		attaqueRepo.delete(attaque4);
	}
	
	@Test
	public void monPokemonUpdate() {
		
	}
	
	@Test
	public void monPokemonFindAllAndDelete() {
		
	}
}

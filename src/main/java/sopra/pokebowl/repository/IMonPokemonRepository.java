package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.MonPokemon;

public interface IMonPokemonRepository extends IRepository<MonPokemon, Long> {
	
	List<MonPokemon> findAll();

}

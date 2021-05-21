package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Pokemon;

public interface IPokemonRepository extends IRepository<Pokemon, Long> {
	public List<Attaque> findAllAttaquesPokemonById(Long id);

	public List<Pokemon> findAllPokemonByString(String recherche);
}

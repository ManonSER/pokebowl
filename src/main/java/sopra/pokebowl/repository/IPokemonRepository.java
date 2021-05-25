package sopra.pokebowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeEnum;

public interface IPokemonRepository extends JpaRepository<Pokemon, Long> {
	//public List<Attaque> findAllAttaquesPokemonById(Long id);
	//public List<Pokemon> findAllPokemonByType(TypeEnum type1, TypeEnum type2);
	//public List<Pokemon> findAllPokemonByString(String recherche);
}

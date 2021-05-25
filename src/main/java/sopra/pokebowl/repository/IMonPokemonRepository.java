package sopra.pokebowl.repository;

import sopra.pokebowl.model.MonPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonPokemonRepository extends JpaRepository<MonPokemon, Long> {

}

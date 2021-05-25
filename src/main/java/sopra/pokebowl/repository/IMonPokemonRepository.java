package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.MonPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonPokemonRepository extends JpaRepository<MonPokemon, Long> {

}

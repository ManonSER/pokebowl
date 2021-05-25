package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.MonPokemon;

public interface IMonPokemonRepository extends JpaRepository<MonPokemon, Long> {

}

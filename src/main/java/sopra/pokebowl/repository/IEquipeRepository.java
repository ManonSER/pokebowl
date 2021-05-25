package sopra.pokebowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Equipe;

public interface IEquipeRepository extends JpaRepository<Equipe, Long> {
	List<Equipe> findEquipesByUtilisateurId(Long id);
}

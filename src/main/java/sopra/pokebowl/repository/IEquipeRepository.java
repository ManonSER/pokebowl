package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Equipe;

public interface IEquipeRepository extends IRepository<Equipe, Long> {
	List<Equipe> findEquipesByUtilisateurId(Long id);
}

package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends  IRepository<Utilisateur, Long> {
	public Object[] findPseudoMailAvatarStatsById(Long id);
	public List<List<String>> findAvatarsPokeAllEquipesById(Long id);

}

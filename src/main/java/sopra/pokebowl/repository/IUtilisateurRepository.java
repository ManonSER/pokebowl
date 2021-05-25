package sopra.pokebowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends  JpaRepository<Utilisateur, Long> {
	//public Object[] findPseudoMailAvatarStatsById(Long id);
	//public List<List<String>> findAvatarsPokeAllEquipesById(Long id);

}

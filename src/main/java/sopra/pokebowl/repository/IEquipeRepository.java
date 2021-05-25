package sopra.pokebowl.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Equipe;

public interface IEquipeRepository extends JpaRepository<Equipe, Long> {
	
	@Query("select e from Equipe e where e.utilisateurEquipeSauv.id = :idutil")
	List<Equipe> findEquipesByUtilisateurId(@Param("idutil") Long id);
	
	List<Equipe> findAll();
	
	Equipe findById(Long id);
}

package sopra.pokebowl.repository;

import sopra.pokebowl.model.Salon;

public interface ISalonRepository extends JpaRepository<Salon, Long> {
	@Query("select s from Salon where s.motDePasse = :mdp")
	Salon findSalonWithMDP(@Param("mdp") String mdp);
}

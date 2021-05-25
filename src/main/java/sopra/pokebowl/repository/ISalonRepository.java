package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Salon;

public interface ISalonRepository extends JpaRepository<Salon, Long> {
	@Query("select s from Salon where s.motDePasse = :mdp")
	Salon findSalonWithMDP(@Param("mdp") String mdp);
}

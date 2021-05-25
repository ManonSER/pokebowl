package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Salon;

public interface ISalonRepository extends JpaRepository<Salon, Long> {
	Salon findSalonWithMDP(String mdp);
}

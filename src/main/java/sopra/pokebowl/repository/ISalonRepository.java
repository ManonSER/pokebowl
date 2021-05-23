package sopra.pokebowl.repository;

import sopra.pokebowl.model.Salon;

public interface ISalonRepository extends IRepository<Salon, Long> {
	Salon findSalonWithMDP(String mdp);
}

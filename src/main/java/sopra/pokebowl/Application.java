package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;
import sopra.pokebowl.repository.jpa.SalonRepositoryJpa;
import sopra.pokebowl.repository.jpa.UtilisateurRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final ISalonRepository salonRepo = new SalonRepositoryJpa(); 

	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}

	public ISalonRepository getSalonRepo() {
		return salonRepo;
	}
}
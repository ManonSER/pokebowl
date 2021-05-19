package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.jpa.EquipeRepositoryJpa;
import sopra.pokebowl.repository.jpa.MonPokemonRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final IMonPokemonRepository monPokeRepo = new MonPokemonRepositoryJpa();
	private final IEquipeRepository equipeRepo = new EquipeRepositoryJpa();

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
	
	public IMonPokemonRepository getMonPokemonRepositoryJpa() {
		return monPokeRepo;
	}
	
	public IEquipeRepository getEquipeRepositoryJpa() {
		return equipeRepo;
	}

}
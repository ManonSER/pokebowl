package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;
import sopra.pokebowl.repository.ITourRepository;
import sopra.pokebowl.repository.jpa.CombatRepositoryJpa;
import sopra.pokebowl.repository.jpa.PokemonMatchRepositoryJpa;
import sopra.pokebowl.repository.jpa.TourRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final ICombatRepository combatRepo = new CombatRepositoryJpa();
	private final ITourRepository tourRepo = new TourRepositoryJpa();
	private final IPokemonMatchRepository pokemonMatchRepo = new PokemonMatchRepositoryJpa();
	

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

	public ICombatRepository getCombatRepo() {
		return combatRepo;
	}

	public ITourRepository getTourRepo() {
		return tourRepo;
	}

	public IPokemonMatchRepository getPokemonMatchRepo() {
		return pokemonMatchRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
	
	
	

}
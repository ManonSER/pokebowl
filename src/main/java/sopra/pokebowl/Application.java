package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final ISalonRepository salonRepo = new SalonRepositoryJpa(); 
	
	private final IPokemonRepository pokemonRepo = new PokemonRepositoryJpa();
	private final IAttaqueRepository attaqueRepo = new AttaqueRepositoryJpa();
	private final ITypeClassRepository typeClassRepo = new TypeClassRepositoryJpa();
	
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

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}

	public ISalonRepository getSalonRepo() {
		return salonRepo;
	}
	public IPokemonRepository getPokemonRepo() {
		return pokemonRepo;
	}

	public IAttaqueRepository getAttaqueRepo() {
		return attaqueRepo;
	}

	public ITypeClassRepository getTypeClassRepo() {
		return typeClassRepo;
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
package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;
import sopra.pokebowl.repository.jpa.AttaqueRepositoryJpa;
import sopra.pokebowl.repository.jpa.PokemonRepositoryJpa;
import sopra.pokebowl.repository.jpa.TypeClassRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final IPokemonRepository pokemonRepo = new PokemonRepositoryJpa();
	private final IAttaqueRepository attaqueRepo = new AttaqueRepositoryJpa();
	private final ITypeClassRepository typeClassRepo = new TypeClassRepositoryJpa();

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

	public IPokemonRepository getPokemonRepo() {
		return pokemonRepo;
	}
	
	

}
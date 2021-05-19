package sopra.pokebowl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;
import sopra.pokebowl.repository.jpa.AttaqueRepositoryJpa;
import sopra.pokebowl.repository.jpa.PokemonRepositoryJpa;
import sopra.pokebowl.repository.jpa.TypeClassRepositoryJpa;

import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;
import sopra.pokebowl.repository.jpa.SalonRepositoryJpa;
import sopra.pokebowl.repository.jpa.UtilisateurRepositoryJpa;

import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.jpa.EquipeRepositoryJpa;
import sopra.pokebowl.repository.jpa.MonPokemonRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
	
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final ISalonRepository salonRepo = new SalonRepositoryJpa(); 
	
	private final IPokemonRepository pokemonRepo = new PokemonRepositoryJpa();
	private final IAttaqueRepository attaqueRepo = new AttaqueRepositoryJpa();
	private final ITypeClassRepository typeClassRepo = new TypeClassRepositoryJpa();
	
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
	
	

}
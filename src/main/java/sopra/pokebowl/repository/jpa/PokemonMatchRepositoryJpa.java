package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.repository.IPokemonMatchRepository;

public class PokemonMatchRepositoryJpa implements IPokemonMatchRepository{

	@Override
	public List<PokemonMatch> findAll() {
		List<PokemonMatch> pokemonMatchs = new ArrayList<PokemonMatch>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<PokemonMatch> query = em.createQuery("select e from Evaluation e", PokemonMatch.class);

			pokemonMatchs = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return pokemonMatchs;
	}

	@Override
	public PokemonMatch findById(Long id) {
		PokemonMatch pokemonMatch = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			pokemonMatch = em.find(PokemonMatch.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return pokemonMatch;
	}

}

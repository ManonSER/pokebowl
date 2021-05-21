package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.repository.IPokemonRepository;

public class PokemonRepositoryJpa implements IPokemonRepository{

	public List<Pokemon> findAll() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Pokemon> query = em.createQuery("select p from Pokemon p", Pokemon.class);

			pokemons = query.getResultList();

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

		return pokemons;
	}

	public Pokemon findById(Long id) {
		Pokemon pokemon = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			pokemon = em.find(Pokemon.class, id);

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

		return pokemon;
	}
	
	@Override
	public List<Attaque> findAllAttaquesPokemonById(Long id) {
		List<Attaque> attaques = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Attaque> query = em.createQuery(
					"select p.attaques from Pokemon p where p.id = :idutil",
					Attaque.class);
			query.setParameter("idutil", id);

			attaques = query.getResultList();

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
		return attaques;
	}

}

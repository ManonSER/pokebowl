package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeEnum;
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
	
	public List<Pokemon> findAllPokemonByType(TypeEnum type1, TypeEnum type2) {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Pokemon> query = em.createQuery(
					"select * from Pokemon p WHERE p.type1 = :type1 AND p.type2 = :type2",
					Pokemon.class);

			query.setParameter("type1", type1);
			query.setParameter("type2", type2);

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

}

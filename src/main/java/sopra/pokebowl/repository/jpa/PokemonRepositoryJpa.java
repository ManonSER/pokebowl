package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
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
	
	public String findAvatarWithNom(String nom) {
		String avatar = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<String> query = em.createQuery("select p.avatar from Pokemon p where p.nom = :nom", String.class);
			
			query.setParameter("nom", nom);
			
			avatar = query.getSingleResult();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if(em != null) {
				em.close();
			}
		}
		
		return avatar;
	}
	
	public List<Pokemon> findPokemonsEquipePrecedenteUtilisateur(Long idUtilisateur) {
		List<Pokemon> pokemons = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Pokemon> query = em.createQuery("select u.derniereEquipe.listPokemon from Utilisateur u where u.id = :id", Pokemon.class);
			
			query.setParameter("id", idUtilisateur);
			
			pokemons = query.getResultList();

			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if(em != null) {
				em.close();
			}
		}
		
		return pokemons;	
	}

}

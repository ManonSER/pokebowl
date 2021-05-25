//package sopra.pokebowl.repository.jpa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.TypedQuery;
//
//import sopra.pokebowl.Application;
//import sopra.pokebowl.model.MonPokemon;
//import sopra.pokebowl.repository.IMonPokemonRepository;
//
//public class MonPokemonRepositoryJpa implements IMonPokemonRepository {
//
//	@Override
//	public List<MonPokemon> findAll() {
//		List<MonPokemon> mesPokemons = new ArrayList<MonPokemon>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<MonPokemon> query = em.createQuery("select p from MonPokemon p", MonPokemon.class);
//
//			mesPokemons = query.getResultList();
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return mesPokemons;
//	}
//
//	@Override
//	public MonPokemon findById(Long id) {
//		MonPokemon monPoke = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			monPoke = em.find(MonPokemon.class, id);
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return monPoke;
//	}
//
//}

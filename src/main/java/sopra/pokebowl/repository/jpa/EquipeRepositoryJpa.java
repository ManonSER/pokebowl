package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.repository.IEquipeRepository;

public class EquipeRepositoryJpa implements IEquipeRepository {

	@Override
	public List<Equipe> findAll() {
		List<Equipe> equipes = new ArrayList<Equipe>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Equipe> query = em.createQuery("select e from Equipe e", Equipe.class);

			equipes = query.getResultList();

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

		return equipes;
	}

	@Override
	public Equipe findById(Long id) {
		Equipe equipe = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			equipe = em.find(Equipe.class, id);

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

		return equipe;
	}

	public List<Equipe> findEquipesByUtilisateurId(Long id) {
		List<Equipe> equipes = new ArrayList<Equipe>();
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Equipe> query = em.createQuery("select u.utilisateurEquipeSauv from Utilisateur u where u.id = :idutil", Equipe.class);
			query.setParameter("idutil", id);

			equipes = query.getResultList();

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
		
		return equipes;
	}
}

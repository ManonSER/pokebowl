package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class UtilisateurRepositoryJpa  implements IUtilisateurRepository {

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Utilisateur> query = em.createQuery("select u from Utilisateur u", Utilisateur.class);
			utilisateurs = query.getResultList();
			
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
		
		return utilisateurs;
	}

	@Override
	public Utilisateur findById(Long id) {
		Utilisateur utilisateur = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			utilisateur = em.find(Utilisateur.class, id);
			
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
		
		return utilisateur;
	}

}

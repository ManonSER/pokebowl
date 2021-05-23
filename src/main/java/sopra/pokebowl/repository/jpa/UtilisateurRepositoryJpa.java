package sopra.pokebowl.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Equipe;
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
	
	@Override
	public Object[] findPseudoMailAvatarStatsById(Long id) {
		Object[] resultat = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Object[]> query = em.createQuery(
					"select u.pseudo, u.email, u.avatar, u.statistique from Utilisateur u where u.id = :idutil",
					Object[].class);

			query.setParameter("idutil", id);

			resultat = query.getSingleResult();

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
		return resultat;
	}
	
	@Override
	public List<List<String>> findAvatarsPokeAllEquipesById(Long id) {
		List<List<String>> resultat = new ArrayList<List<String>>();
		List<Equipe> equipes = null;

		EntityManager em = null;
		EntityManager em2 = null;
		EntityTransaction tx = null;
		EntityTransaction tx2 = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			em2 = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx2 = em2.getTransaction();
			tx.begin();
			tx2.begin();

			TypedQuery<Equipe> query = em.createQuery(
					"select e from Equipe e where e.utilisateurEquipeSauv.id = :idutil",
					Equipe.class);

			query.setParameter("idutil", id);

			equipes = query.getResultList();
			
			for(Equipe e : equipes) {
				List<String> avatarsEquipe = new ArrayList<String>();
				for(int j=0; j<e.getNbrPokemons(); j++) {
					TypedQuery<String> q2 = em2.createQuery(
							"select p.pokeReference.avatar from MonPokemon p where p.id = :idpoke",
							String.class);
					q2.setParameter("idpoke", e.getListPokemons().get(j).getId());
					String av = q2.getSingleResult();
					avatarsEquipe.add(av);	
				}
				resultat.add(avatarsEquipe);			
			}
			tx2.commit();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (tx2 != null && tx2.isActive()) {
				tx2.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
			if (em2 != null) {
				em2.close();
			}
		}
		return resultat;
	}
	
}

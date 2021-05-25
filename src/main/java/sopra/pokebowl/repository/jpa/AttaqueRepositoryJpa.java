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
//import sopra.pokebowl.model.Attaque;
//import sopra.pokebowl.repository.IAttaqueRepository;
//
//public class AttaqueRepositoryJpa implements IAttaqueRepository{
//
//	public List<Attaque> findAll() {
//		List<Attaque> attaques = new ArrayList<Attaque>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<Attaque> query = em.createQuery("select a from Attaque a", Attaque.class);
//
//			attaques = query.getResultList();
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
//		return attaques;
//	}
//
//	public Attaque findById(Long id) {
//		Attaque attaque = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			attaque = em.find(Attaque.class, id);
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
//		return attaque;
//	}
//
//}

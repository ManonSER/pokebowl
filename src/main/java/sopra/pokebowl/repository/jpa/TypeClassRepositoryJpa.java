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
//import sopra.pokebowl.model.TypeClass;
//import sopra.pokebowl.repository.ITypeClassRepository;
//
//public class TypeClassRepositoryJpa implements ITypeClassRepository{
//
//	@Override
//	public List<TypeClass> findAll() {
//		List<TypeClass> types = new ArrayList<TypeClass>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<TypeClass> query = em.createQuery("select t from TypeClass t", TypeClass.class);
//
//			types = query.getResultList();
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
//		return types;
//	}
//
//	@Override
//	public TypeClass findById(Long id) {
//		TypeClass type = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			type = em.find(TypeClass.class, id);
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
//		return type;
//	}
//
//}

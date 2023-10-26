
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

	public class UserDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("RobertPU");

		public UserDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(User user) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeUser(User user) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(user));
			em.getTransaction().commit();
			em.close();
		}
		
		public User merge(User user) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			User updatedUser = em.merge(user);
			em.getTransaction().commit();
			em.close();
			return updatedUser;
		}
		
		
		public List<User> getAllUsers() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<User> users = new ArrayList<User>();
			users = em.createQuery("from User").getResultList();
			em.getTransaction().commit();
			em.close();
			return users;
		}

		public User getUserByName(String userName) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			User u = em.createQuery("SELECT p FROM User p WHERE u.userName = :userName", User.class)
	                .setParameter("userName", userName)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return u;
		}
		


	}

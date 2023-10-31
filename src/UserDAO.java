

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

	public class UserDAO {
		
		LoanDAO loandao = new LoanDAO();
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("dbca");

		public UserDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(User user2) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user2);
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
		
		public Loan getLoanByUser(int userID) {
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        
	        User user = em.find(User.class, userID);
	        int loan = user.getLoan();
	        Loan nameOfLoan = loandao.getLoanByID(loan);
	        
	        em.getTransaction().commit();
	        em.close();
	        
	        return nameOfLoan;
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

		public User getUserByID(int userID) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			User u = em.createQuery("SELECT p FROM User p WHERE p.userID = :userID", User.class)
	                .setParameter("userID", userID)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return u;
		}
		
		public List<Transaction> getTransactionsForUser(String userId) {
		    EntityManager em = emf.createEntityManager();
		        em.getTransaction().begin();
		        User user = em.find(User.class, userId);
		        List<Transaction> transactions = user.getTransactions();
		        em.getTransaction().commit();
		        return transactions;
		   
		}


	}

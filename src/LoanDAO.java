import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

	public class LoanDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("dbca");

		public LoanDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(loan);
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeLoan(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(loan));
			em.getTransaction().commit();
			em.close();
		}
		
		public Loan merge(Loan loan) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Loan updatedLoan = em.merge(loan);
			em.getTransaction().commit();
			em.close();
			return updatedLoan;
		}
		
		
		public List<Loan> getAllLoans() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Loan> loans = new ArrayList<Loan>();
			loans = em.createQuery("from Loan").getResultList();
			em.getTransaction().commit();
			em.close();
			return loans;
		}
		
		public Loan getLoanByID(int loanID) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Loan l = em.createQuery("SELECT p FROM Loan p WHERE p.loanID = :loanID", Loan.class)
	                .setParameter("loanID", loanID)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return l;
		}
		
		public List<Transaction> getTransactionsForLoan(String loanID) {
		    EntityManager em = emf.createEntityManager();
		        em.getTransaction().begin();
		        Loan loan = em.find(Loan.class, loanID);
		        List<Transaction> transactions = loan.getTransactions();
		        em.getTransaction().commit();
		        return transactions;
		   
		}


	}

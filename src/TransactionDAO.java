import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

	public class TransactionDAO {
		
		protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("dbca");

		public TransactionDAO() {
			// TODO Auto-generated constructor stub
		}
		 	

		public void persist(Transaction transaction) {
		    EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();

		    Loan loan = transaction.getLoan();
		    int newLoanAmount = loan.getLoanAmount() - transaction.getAmount();
		    loan.setLoanAmount(newLoanAmount);

		    em.merge(loan);
		    em.persist(transaction);

		    em.getTransaction().commit();
		    em.close();
		}

		
		public void removeTransaction(int transactionId) {
		    EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();

		    Transaction transaction = em.find(Transaction.class, transactionId);

		    if (transaction != null) {
		        Loan loan = transaction.getLoan(); 

		        int transactionAmount = transaction.getAmount();
		        int currentLoanAmount = loan.getLoanAmount();
		        loan.setLoanAmount(currentLoanAmount + transactionAmount);

		        em.remove(transaction);
		    }

		    em.getTransaction().commit();
		    em.close();
		}
		
		
		public List<Transaction> getAllTransactions() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions = em.createQuery("from Transaction").getResultList();
			em.getTransaction().commit();
			em.close();
			return transactions;
		}
		
		public Transaction getTransactionByID(String transactionID) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Transaction t = em.createQuery("SELECT p FROM Transaction p WHERE p.transactionID = :transactionID", Transaction.class)
	                .setParameter("transactionID", transactionID)
	                .getSingleResult();
			em.getTransaction().commit();
			em.close();
			return t;
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



import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("dbca");

	public TransactionDAO() {
		// TODO Auto-generated constructor stub
	}

	UserDAO userdao = new UserDAO();
	LoanDAO loandao = new LoanDAO();
	
	public void persist(Transaction transaction, int userID) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		User user = em.find(User.class, userID);
        int loan = user.getLoan();
        Loan nameOfLoan = loandao.getLoanByID(loan);

		int newLoanAmount = nameOfLoan.getLoanAmount() - transaction.getAmount();
		nameOfLoan.setLoanAmount(newLoanAmount);

		em.merge(nameOfLoan);
		em.persist(transaction);

		et.commit();
		em.close();
	}



	public void removeTransaction(Transaction transaction, int userID) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		User user = em.find(User.class, userID);
        int loan = user.getLoan();
        Loan nameOfLoan = loandao.getLoanByID(loan);

		int newLoanAmount = nameOfLoan.getLoanAmount() + transaction.getAmount();
		nameOfLoan.setLoanAmount(newLoanAmount);

		em.merge(nameOfLoan);
		em.remove(transaction);

		et.commit();
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


}

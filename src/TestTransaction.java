public class TestTransaction {

    public TestTransaction() {
        TransactionDAO transactionDAO = new TransactionDAO(); 
        UserDAO userDAO = new UserDAO();
        
        User user = userDAO.getUserByID(1);

        Transaction transaction = new Transaction("31/10/2023", 50);
        transaction.setUser(user);
        
        transactionDAO.persist(transaction, user.getLoan());
    }

    public static void main(String[] args) {
        new TestTransaction();
    }
}

public class Test {

	//Hard Wired Transaction
    public Test() {
        TransactionDAO transactionDAO = new TransactionDAO(); 
        LoanDAO loanDAO = new LoanDAO();
        UserDAO userDAO = new UserDAO();
        
        User user = userDAO.getUserByID(1);
        Loan loan = loanDAO.getLoanByID(1);
        
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            transaction.setLoan(loan);
            transaction.setTransactionUserID(user.getUserID());
            transaction.setTransactionLoanID(loan.getLoanID());
            transaction.setDate("29/10/2023");
            transaction.setAmount(50);

            transactionDAO.persist(transaction);

        
    }

    public static void main(String[] args) {
        new Test();
    }
}

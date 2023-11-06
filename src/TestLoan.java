public class TestLoan {
    //Hard Wired Loan
	public TestLoan() {
		UserDAO userDAO = new UserDAO();
		
        User user = userDAO.getUserByID(1);
        Loan loan = new Loan("A New Car", 1000, user);
        LoanDAO loandao = new LoanDAO(); 
        loandao.persist(loan);
    }

    public static void main(String[] args) {
        new TestLoan();
    }
}

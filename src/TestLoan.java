public class TestLoan {
    //Hard Wired Loan
	public TestLoan() {
        Loan loan = new Loan("A New Car", 1000);
        LoanDAO loandao = new LoanDAO(); 
        loandao.persist(loan);
    }

    public static void main(String[] args) {
        new TestLoan();
    }
}

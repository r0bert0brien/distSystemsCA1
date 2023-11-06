public class UpdateLoan {
    public UpdateLoan() {
        LoanDAO loandao = new LoanDAO(); 
        Loan loan = loandao.getLoanByID(1);
        loan.setLoanAmount(5000);
        loandao.merge(loan);
    }

    public static void main(String[] args) {
        new UpdateLoan();
    }
}

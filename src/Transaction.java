

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transaction")
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionID;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "loanID")
	Loan loan;
	
	private int transactionUserID;
	private int transactionLoanID;
	private String date;
	private int amount;
	
	public Transaction(int transactionID, int transactionUserID, int transactionLoanID, String date, int amount) {
		this.transactionID = transactionID;
		this.transactionUserID = transactionUserID;
		this.transactionLoanID = transactionLoanID;
		this.date = date;
		this.amount = amount;
	}
	
	public Transaction() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getTransactionUserID() {
		return user.getUserID();
	}

	public void setTransactionUserID(int transactionUserID) {
		this.transactionUserID = transactionUserID;
		user.setUserID(transactionUserID);
	}

	public int getTransactionLoanID() {
		return loan.getLoanID();
	}

	public void setTransactionLoanID(int transactionLoanID) {
		this.transactionLoanID = transactionLoanID;
		loan.setLoanID(transactionLoanID);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}

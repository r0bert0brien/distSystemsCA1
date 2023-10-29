

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
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "loan_id")
	Loan loan;
	
	private String transactionUserID;
	private String transactionLoanID;
	private String date;
	private String amount;
	
	public Transaction(String transactionUserID, String transactionLoanID, String date, String amount) {
		this.transactionUserID = transactionUserID;
		this.transactionLoanID = transactionLoanID;
		this.date = date;
		this.amount = amount;
	}
	
	public Transaction() {
		
	}

	public String getTransactionUserID() {
		return user.getUserID();
	}

	public void setTransactionUserID(String transactionUserID) {
		this.transactionUserID = transactionUserID;
		user.setUserID(transactionUserID);
	}

	public String getTransactionLoanID() {
		return loan.getLoanID();
	}

	public void setTransactionLoanID(String transactionLoanID) {
		this.transactionLoanID = transactionLoanID;
		loan.setLoanID(transactionLoanID);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	
	
}

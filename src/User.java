

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class User {

	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	@XmlElement
	private String userName;
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String address;
	@XmlElement
	private int annualSalary;
	

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Loan loan;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public User(String userName, String phoneNumber, String address, int annualSalary) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.annualSalary = annualSalary;
	}


	public User() {

	}

	@XmlElement
	public List<Transaction> getTransactions() {
		return transactions;
	}

	@XmlElement
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@XmlElement
	public int getUserID() {
		return userID;
	}

	@XmlElement
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@XmlElement
	public String getUserName() {
		return userName;
	}

	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@XmlElement
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public int getAnnualSalary() {
		return annualSalary;
	}

	@XmlElement
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	@XmlElement
	public int getLoan() {
		return loan.getLoanID();
	}

	@XmlElement
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
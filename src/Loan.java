

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
public class Loan {
	
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanID;
	@XmlElement
	private String loanReason;
	@XmlElement
	private int loanAmount;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Loan(String loanReason, int loanAmount, User user) {
		this.loanReason = loanReason;
		this.loanAmount = loanAmount;
		this.user = user;
	}

	public Loan() {

	}

	@XmlElement
	public User getUser() {
		return user;
	}

	@XmlElement
	public void setUser(User user) {
		this.user = user;
	}

	@XmlElement
	public int getLoanID() {
		return loanID;
	}

	@XmlElement
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	@XmlElement
	public String getLoanReason() {
		return loanReason;
	}

	@XmlElement
	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	@XmlElement
	public int getLoanAmount() {
		return loanAmount;
	}

	@XmlElement
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

}
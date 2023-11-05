



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Transaction {

	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionID;
	@XmlElement
	private String date;
	@XmlElement
	private int amount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Transaction(String date, int amount) {
		this.date = date;
		this.amount = amount;
		this.user = new User();
	}

	public Transaction() {

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
	public int getTransactionID() {
		return transactionID;
	}

	@XmlElement
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	@XmlElement
	public int getTransactionUserID() {
		return user.getUserID();
	}

	@XmlElement
	public String getDate() {
		return date;
	}

	@XmlElement
	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement
	public int getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(int amount) {
		this.amount = amount;
	}



}
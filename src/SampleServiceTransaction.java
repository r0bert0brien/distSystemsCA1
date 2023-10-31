import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/transactions")
public class SampleServiceTransaction {
	private TransactionDAO transactionDAO = new TransactionDAO();

	@GET
	@Path("/transactionsxml")
	@Produces("application/xml")
	public List<Transaction> gettransFromDB(){
		return transactionDAO.getAllTransactions(); 
	}

	@POST
	@Path("/newtransaction")
	@Consumes("application/xml")
	public String addtransactionToDBXML(Transaction transaction, int UserID){
		transactionDAO.persist(transaction, UserID); 
		return "Transaction added to DB from XML Param " + transaction.getTransactionID();    
	}
}

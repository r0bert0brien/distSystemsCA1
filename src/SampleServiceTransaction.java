import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

@Path("/transactions")
public class SampleServiceTransaction {
	private TransactionDAO transactionDAO = new TransactionDAO();

	@GET
	@Path("/transactionsxml")
	@Produces("application/xml")
	public List<Transaction> getransFromDB(){
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

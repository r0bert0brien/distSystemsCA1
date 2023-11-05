
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



@Path("/sampleserviceDBCRUD")
public class SampleServiceDBCRUD {
    
    UserDAO userDAO = new UserDAO(); 
    LoanDAO loanDAO = new LoanDAO();
    TransactionDAO transactionDAO = new TransactionDAO();
    
    //Transaction Paths
    
    @GET
    @Path("/transactionsxml")
    @Produces("application/xml")
    public List<Transaction> gettransFromDB(){
        return transactionDAO.getAllTransactions(); 
    }
    
    @POST
    @Path("/newtransaction")
    @Consumes("application/xml")
    public String addtransactionToDBXML(Transaction transaction, int userID){
        transactionDAO.persist(transaction, userID); 
        return "Transaction added to DB from XML Param " + transaction.getTransactionID();    
    }
    
    //Loan Paths
    @GET
    @Path("/loansxmlfromdb")
    @Produces("application/xml")
    public List<Loan> getloansFromDB(){
        return loanDAO.getAllLoans(); 
    }
    
    @GET
    @Path("/jsonDB/loan/{loanID}")
    @Produces("application/json")
    public Loan getloanByIDFromDBJSON(@PathParam("loanID")int loanID){
        return loanDAO.getLoanByID(loanID); 
    }
    
    @POST
    @Path("/newloan")
    @Consumes("application/xml")
    public String addloanToDBXML(Loan loan){
        loanDAO.persist(loan); 
        return "Loan added to DB from XML Param " + loan.getLoanID();    
    }
    
    @PUT
    @Path("/updateloan/")
    @Produces("application/json")
    public Loan updateloan(Loan loan){
        return loanDAO.merge(loan); 
    }
    
    @DELETE
    @Path("/deletloan/{loanID}")
    @Produces("text/plain")
    public String deleteloan(@PathParam("loanID")int loanID){
        Loan loan = loanDAO.getLoanByID(loanID);
        loanDAO.removeLoan(loan); 
        return "loan " + loan + " deleted";
    }
    
    //User Paths
    
    @GET
    @Path("/usersxmlfromdb")
    @Produces("application/xml")
    public List<User> getusersFromDB(){
        return userDAO.getAllUsers(); 
    }

    @GET
    @Path("/usersjsonfromdb")
    @Produces("application/json")
    public List<User> getJSONusersFromDB(){
        return userDAO.getAllUsers(); 
    }

    @GET
    @Path("/jsonDB/user/{userID}")
    @Produces("application/json")
    public User getuserByNameFromDBJSON(@PathParam("userID")int userID){
        return userDAO.getUserByID(userID); 
    }

    @GET
    @Path("/userfromDBXML/{userID}")
    @Produces("application/xml")
    public User getuserByNameFromDBXML(@PathParam("userID")int userID){
        return userDAO.getUserByID(userID); 
    }

    @POST
    @Path("/newuser")
    @Consumes("application/json")
    public String adduserToDBJSON(User user){
        userDAO.persist(user); 
        return "user added to DB from JSON Param " + user.getUserName();    
    }

    @PUT
    @Path("/updateuser/")
    @Produces("application/json")
    public User updateuser(User user){
        return userDAO.merge(user); 
    }

    @DELETE
    @Path("/deleteuser/{userID}")
    @Produces("text/plain")
    public String deleteuser(@PathParam("userID")int userID){
        User usr = userDAO.getUserByID(userID);
        userDAO.removeUser(usr); 
        return "user " + usr + " deleted";
    }
}



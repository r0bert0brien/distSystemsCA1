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

@Path("/loans")
public class SampleServiceLoan {
    private LoanDAO loanDAO = new LoanDAO();

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
}

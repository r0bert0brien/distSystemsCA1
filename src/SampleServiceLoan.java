import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

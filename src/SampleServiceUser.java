import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class SampleServiceUser {
    private UserDAO userDAO = new UserDAO();

    @GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
    
    @GET
    @Path("/usersxmlfromdb")
    @Produces("application/json")
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

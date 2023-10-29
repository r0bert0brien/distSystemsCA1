
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
    @Path("/jsonDB/user/{userName}")
    @Produces("application/json")
    public User getuserByNameFromDBJSON(@PathParam("userName")String userName){
        return userDAO.getUserByName(userName); 
    }

    @GET
    @Path("/userfromDBXML/{userName}")
    @Produces("application/xml")
    public User getuserByNameFromDBXML(@PathParam("userName")String userName){
        return userDAO.getUserByName(userName); 
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
    @Path("/deleteuser/{userName}")
    @Produces("text/plain")
    public String deleteuser(@PathParam("userName")String userName){
        User usr = userDAO.getUserByName(userName);
        userDAO.removeUser(usr); 
        return "user " + usr + " deleted";
    }
}



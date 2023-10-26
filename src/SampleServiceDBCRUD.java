
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
	
	private static Map<String, User> users = new HashMap<String, User>();
	
	static {
		
		User user1 = new User();
        user1.setUserID("1");
        user1.setUserName("Robert");
        user1.setPhoneNumber("0871234567");
        user1.setAddress("1 Fairview Road");
        user1.setAnnualSalary(50000);
        users.put(user1.getUserID(), user1);
        
    }

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	@GET
    @Path("/helloworld")
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello World New";    
    }
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
	
	@GET
    @Path("/newEcho/{message}")
    @Produces("text/plain")
    public String newEcho(@PathParam("message")String message){
        return message;  
    }

	
	@GET
    @Path("/users")
    @Produces("application/xml")
    public List<User> listusers(){
        return new ArrayList<User>(users.values());
    }
	
	@GET
    @Path("/user/{userid}")
    @Produces("application/xml")
    public User getuser(@PathParam("userid")String userId){
		return users.get(userId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String adduser(User user){
		
		return "user added " +user.getUserName();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONuser(User user){
		return "user added " +user.getUserName();		
    }
	
	@GET
    @Path("/json/users/")
    @Produces("application/json")
    public List<User> listusersJSON(){
		return new ArrayList<User>(users.values());
    }

	@GET
    @Path("/json/user/{userid}")
    @Produces("application/json")
    public User getuserJSON(@PathParam("userid")String userId){
		return users.get(userId);		
    }
	
	@GET
    @Path("/usersxmlfromdb")
    @Produces("application/xml")
    public List<User> getusersFromDB(){
        UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }
	
	@GET
    @Path("/usersjsonfromdb")
    @Produces("application/json")
    public List<User> getJSONusersFromDB(){
        UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }
	
	@GET
    @Path("/jsonDB/user/{userName}")
    @Produces("application/json")
    public User getuserByNameFromDBJSON(@PathParam("userName")String userName){
		UserDAO dao = new UserDAO();
		return dao.getUserByName(userName);		
    }
	
	@GET
    @Path("/userfromDBXML/{userName}")
    @Produces("application/xml")
    public User getuserByNameFromDBXML(@PathParam("userName")String userName){
		UserDAO dao = new UserDAO();
		return dao.getUserByName(userName);	
    }
	
	@POST
	@Path("/newuser")
    @Consumes("application/json")
    public String adduserToDBJSON(User user){
		UserDAO dao = new UserDAO();
		dao.persist(user);
		return "user added to DB from JSON Param "+user.getUserName();	
    }
	
	@PUT
    @Path("/updateuser/")
    @Produces("application/json")
    public User updateuser(User user){
		UserDAO dao = new UserDAO();
		return dao.merge(user);	
    }
	
	@DELETE
    @Path("/deleteuser/{userName}")
    @Produces("text/plain")
    public String deleteuser(@PathParam("userName")String userName){
		UserDAO dao = new UserDAO();
		User usr = dao.getUserByName(userName);
		dao.removeUser(usr);	
		return "user "+usr+" deleted";
    }
	
	
}


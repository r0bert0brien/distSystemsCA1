
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/sampleservice")
public class SampleService {
	
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
    public String adduser(User user) {
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
	

}


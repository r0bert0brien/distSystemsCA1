public class Test {
	
	
	public Test() {
		User user = new User("2", "Robert", "0871234567", "1 Maryfeild Park", 10000);
		UserDAO userdao = new UserDAO(); 
		userdao.persist(user);
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
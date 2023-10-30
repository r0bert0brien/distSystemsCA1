public class TestUser {
    //Hard Wired User
	public TestUser() {
        User user = new User("Brian", "0871234522", "1 Maryfeild Grove", 100);
        UserDAO userdao = new UserDAO(); 
        userdao.persist(user);
    }

    public static void main(String[] args) {
        new TestUser();
    }
}

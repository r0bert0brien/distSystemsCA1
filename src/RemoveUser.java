public class RemoveUser {
	public RemoveUser() {
        UserDAO userdao = new UserDAO(); 
        userdao.removeUser(userdao.getUserByID(1));
    }

    public static void main(String[] args) {
        new RemoveUser();
    }
}

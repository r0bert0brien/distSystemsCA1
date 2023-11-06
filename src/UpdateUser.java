public class UpdateUser {
	public UpdateUser() {
        UserDAO userdao = new UserDAO(); 
        User user = userdao.getUserByID(1);
        user.setUserName("Robert");
        userdao.merge(user);
    }

    public static void main(String[] args) {
        new UpdateUser();
    }
}

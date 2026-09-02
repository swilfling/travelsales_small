import model.UAC.User;

public class TestUser {
	public static void main(String[] args) {
		System.out.println("Start with test file");
		
		String uname1 = "Test";
		String uname2 = "notinhere";
		User u = new User ("Test","test");
		u.saveToDB();
		boolean in_db1 =  User.in_db(uname1);
		boolean in_db2 = User.in_db(uname2);
		
		System.out.printf("User in database: %s: %s\n", uname1, in_db1);
		System.out.printf("User in database: %s: %s\n", uname2, in_db2);
		
		assert(in_db1 == true);
		assert(in_db2 == false);
		
		try 
		{
			User.addUserToDB("Test", "test");
		}
		catch(Exception e)
		{
			System.out.println("User name already taken");
		}
		
		
		
	}
	
}

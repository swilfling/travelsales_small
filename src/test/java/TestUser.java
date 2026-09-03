import org.junit.Test;

import model.UAC.User;
import model.UAC.UserFactory;

public class TestUser {
	@Test
	public void testSaveUser()
	{
		System.out.println("Start with test file");

		String uname1 = "Test";
		String uname2 = "notinhere";
		UserFactory f = new UserFactory();
		User u = null;
		try {
			u = f.createUser("Test","test");
			u.saveToDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean in_db1 =  User.in_db(uname1);
		boolean in_db2 = User.in_db(uname2);

		System.out.printf("User in database: %s: %s\n", uname1, in_db1);
		System.out.printf("User in database: %s: %s\n", uname2, in_db2);

		assert(in_db1 == true);
		assert(in_db2 == false);

		if(u != null)
			assert(u.saveToDB() == false);

	}

}

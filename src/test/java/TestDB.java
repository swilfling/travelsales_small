import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;
import model.UAC.User;
import model.UAC.UserFactory;
import model.Support.HibernateSupport;


public class TestDB {

	@Test
	public void testSaveLoadUser()
	{
		System.out.println("Start with test file");
		UserFactory f = new UserFactory();
		User userA = null;
		User userB = null;
		try {
			userA = f.createUser("Hello1", "World");
			if (!userA.saveToDB())
				System.out.println("Error saving userA");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			userB = f.createUser("Test", "Test");
			if (!userB.saveToDB())
				System.out.println("Error saving userB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HibernateSupport.beginTransaction();
		List<User> users = HibernateSupport.execute_query("HQL_GET_USER_BY_NAME","username", "Test");
		HibernateSupport.commitTransaction();
		if (!users.isEmpty())
		{
			User user = users.getFirst();
			System.out.printf("Query user: %s %s\n", user.getName(), user.getPwd());
		}

	}


	/*
		var builder = HibernateSupport.getCriteriaBuilder();
		CriteriaQuery <User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		Predicate p = builder.equal(root.get("name"), "Hello");
		query.select(root).where(p);
		User user = (User)s.createQuery(query).getResultList().getFirst();
		System.out.printf("%s %s", user.getName(), user.getPwd());

		HibernateSupport.commitTransaction();
	 */
	/*HibernateSupport.beginTransaction();
		User readUser = HibernateSupport.readOneObjectByID(User.class, 0);
		System.out.printf("%s %s", readUser.getName(), readUser.getPwd());
		HibernateSupport.commitTransaction();
		//if(readUser != null){
		//	System.out.println("User read from DB: " + readUser.getUsername() + " pw: " + readUser.getPassword());
		//}
	 */

	//Legacy

	//Comment comment = new Comment(readUser, "Hallo, dass ist mein erstes Kommentar");

	//HibernateSupport.beginTransaction();
	//comment.saveToDB();
	//HibernateSupport.commitTransaction();



	//List<Criterion> criterions = new ArrayList<Criterion>();
	//criterions.add(Restrictions.eq("originator", readUser));
	//List<Comment> commentsFromUser = HibernateSupport.readMoreObjects(Comment.class, criterions);


	//if(commentsFromUser != null){
	//	for(Comment c: commentsFromUser){
	//		System.out.println("Comment: " + c.getComment() + " from user: " + c.getOriginator().getUsername());
	//	}
	//}

	//Application app = new Application("Meine erste Applikation", ApplicationType.Game1);

	//HibernateSupport.beginTransaction();
	//app.saveToDB();
	//HibernateSupport.commitTransaction();


}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;
import model.UAC.User;
import model.Support.HibernateSupport;


public class TestDB {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("Start with test file");
		
		User userA = new User("Hello", "World");
		User userB = new User("Test", "Test");
		HibernateSupport.beginTransaction();
		if (!userA.saveToDB())
			System.out.println("Error saving userA");
		HibernateSupport.commitTransaction();
		HibernateSupport.beginTransaction();
		if (!userB.saveToDB())
			System.out.println("Error saving userB");
		HibernateSupport.commitTransaction();

		HibernateSupport.beginTransaction();

		List<User> users = HibernateSupport.execute_query("HQL_GET_USER_BY_NAME","name", "Hello");
		HibernateSupport.commitTransaction();
		User user = users.getFirst();
		System.out.printf("Query user: %s %s", user.getName(), user.getPwd());

		
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
		HibernateSupport.beginTransaction();
		User readUser = HibernateSupport.readOneObjectByID(User.class, 1);
		System.out.printf("%s %s", readUser.getName(), readUser.getPwd());
		HibernateSupport.commitTransaction();
		//if(readUser != null){
		//	System.out.println("User read from DB: " + readUser.getUsername() + " pw: " + readUser.getPassword());
		//}
		
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
		
		System.out.println("Finished with test file");

	}
	
	

}

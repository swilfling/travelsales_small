package model.Support;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.sql.ast.tree.predicate.Predicate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.Game.Connection;
import model.Game.GameData;
import model.Game.GamePoint;
import model.UAC.User;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This Class handles everything for communicating with the database
 * 
 * @author Stettinger
 *
 */

public class HibernateSupport {

	private static SessionFactory sessionFactory;

	static {
		System.out.println("HibernateSupport: Constructor");
		init();
	}
	
	public static void create(){
		// function is not necessary it only activates the static construction above
	}
	
	private static void init() {
		File configFile = new File("hibernate.cfg.xml");

		Configuration configuration = new Configuration();
		
		//add all classes you want to annotate
		configuration.addAnnotatedClass(GamePoint.class);
		configuration.addAnnotatedClass(Connection.class);
		configuration.addAnnotatedClass(Path.class);
		configuration.addAnnotatedClass(User.class);
		configuration.configure(configFile);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	protected static EntityManager getEntityManager() {
		return sessionFactory.createEntityManager();
	}
	
	public static CriteriaBuilder getCriteriaBuilder()
	{
		return getEntityManager().getCriteriaBuilder();
	}
	
	public static void beginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}
	
	public static void commitTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	public static boolean commit(Object obj) {
		try {
			sessionFactory.getCurrentSession().persist(obj);
		}
		catch (HibernateException e) {
		e.printStackTrace();
			return false;
		}
		return true;
	}

	/*@SuppressWarnings("unchecked")
	public static <T> List<T> readMoreObjects(Class<?> classToRetrieve, List<Predicate> criterions) {
		beginTransaction();
		//b.createQuery(classToRetrieve);
		//Criteria criteria = getCurrentSession().createCriteria(classToRetrieve);
		//for(Criterion criterion: criterions) {
		//	criteria.add(criterion);
		//}
		//List<T> result = criteria.list();
		commitTransaction();
		//return result;
		return null;
	}*/
	
	/*public static <T> T readOneObject(Class<?> classToRetrieve, List<Criterion> criterions) {
		List<T> result = readMoreObjects(classToRetrieve, criterions);
		return (result.size() > 0) ? (result.get(0)):(null);
	}*/
	public static <T> List<T> execute_query(String name, String parameter_name, String parameter_value)
	{
		EntityManager em = sessionFactory.createEntityManager();
		var query = em.createNamedQuery(name);
		query.setParameter(parameter_name, parameter_value);
		return (List <T>)query.getResultList();
	}
	public static <T> List<T> execute_query(String name, String parameter_name, int parameter_value)
	{
		EntityManager em = sessionFactory.createEntityManager();
		var query = em.createNamedQuery(name);
		query.setParameter(parameter_name, parameter_value);
		return (List <T>)query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T readOneObjectByID(Class<?> classToRetrieve, int id) {
		T result = (T)getEntityManager().getReference(classToRetrieve, id);

		return result;
	}
	
	public static <T> void deleteObject(T objectToDelete) {
		sessionFactory.getCurrentSession().remove(objectToDelete);
	}
}

package model.Support;

import java.nio.file.Path;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.service.ServiceRegistry;

import model.Game.Connection;
import model.Game.ConnectionData;
import model.Game.GameData;
import model.Game.GamePoint;
import model.Game.PointData;
import model.UAC.User;


/**
 * 
 * @author Stettinger
 *
 */

public class DatabaseConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		
		Configuration configuration = new Configuration();
		System.out.println("Adding classes");
		configuration.addAnnotatedClass(GamePoint.class);
		configuration.addAnnotatedClass(GameData.class);
		configuration.addAnnotatedClass(PointData.class);
		configuration.addAnnotatedClass(Connection.class);
		configuration.addAnnotatedClass(ConnectionData.class);
		configuration.addAnnotatedClass(Path.class);
		configuration.addAnnotatedClass(User.class);
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		sessionFactory.getSchemaManager().exportMappedObjects(true);
		//new SchemaExport(configuration).create(true, true);

		System.out.println("Finished");
	}
	
}

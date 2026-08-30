package src.model.Support;

import java.nio.file.Path;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import src.model.Connection;
import src.model.ConnectionData;
import src.model.GameData;
import src.model.GamePoint;
import src.model.PointData;
import src.model.UAC.User;


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

		new SchemaExport(configuration).create(true, true);

		System.out.println("Finished");
	}
	
}

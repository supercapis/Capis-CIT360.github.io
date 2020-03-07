package hibernateSessionFactory;

import entities.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Hibernate session class
 * It loads the configuration project file and adds it as a hibernate configuration
 */
public class HibernateSessionUtil {

    // source of the properties file
    private static final String configFile = "./resources/hibernate.properties";
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                //loading file
                URI streamPath = HibernateSessionUtil.class.getClassLoader().getResource(configFile).toURI();
                Properties props = new Properties();
                props.load(new FileInputStream(String.valueOf(Paths.get(streamPath))));

                //Creating new Hibernate configuration
                Configuration configuration = new Configuration();
                configuration.setProperties(props);

                //building configuration to hiberrnate service
                serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                /**
                 * MAPPING:
                 * Adding Entity classes to hibernate
                 * this is a way to map all entities without putting them in a xml file
                 * A different approach for Mapping entities
                 */
                configuration.addAnnotatedClass(Book.class);
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (serviceRegistry != null) {
                serviceRegistry.close();
            }
        }
    }

    /**
     * Gets an instance of the session Object created by hibernate
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}

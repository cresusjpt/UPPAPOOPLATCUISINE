package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Utils {

    public static SessionFactory sessionFactory;


    static {
        try{
            if (sessionFactory == null) {
                // loads configuration and mappings
                Configuration configuration = new Configuration().configure();
                ServiceRegistry serviceRegistry
                        = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                // builds a session factory from the service registry
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
        }catch (Throwable throwable){
            System.err.println("Erreur lors de la session factory"+throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory  getSession(){
        return sessionFactory;
    }
}

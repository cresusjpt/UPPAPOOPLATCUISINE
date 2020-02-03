package utils;

import javax.persistence.Persistence;

public class EntityManagerFactory {
    public static final javax.persistence.EntityManagerFactory factory;

    static {
        try{
            factory = Persistence.createEntityManagerFactory("com.saltechdigital.poo");
        }catch (Throwable throwable){
            System.err.println("Une erreur s'est produite"+throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static javax.persistence.EntityManagerFactory getInstance(){
        return factory;
    }
}

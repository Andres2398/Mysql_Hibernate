package app;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                
                registry = new StandardServiceRegistryBuilder()
                        .configure() 
                        .build();

               
                MetadataSources sources = new MetadataSources(registry);
                
               
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
               
                System.err.println("---------------------------------------------");
                System.err.println("¡ERROR FATAL AL INICIAR HIBERNATE!");
                System.err.println("Posible causa: El mapeo está mal o la base de datos no conecta.");
                e.printStackTrace(); 
                System.err.println("---------------------------------------------");
                
                
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory;
    }
}
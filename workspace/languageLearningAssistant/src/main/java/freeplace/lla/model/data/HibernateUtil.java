package freeplace.lla.model.data;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * klymenko.ruslan 21/03/2015
 */
public class HibernateUtil {
    
    private HibernateUtil(){}
    
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    static {
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(getConfigProperties()
                ).build();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(getConfigProperties());
        serviceRegistry = builder.build();
    }
    
    final static Logger logger = Logger.getLogger(HibernateUtil.class);
    
    
    public static Configuration getConfig() {
        return new Configuration().configure();
    }
    
    public static Properties getConfigProperties() {
        Configuration config = getConfig();
        return config.getProperties();
    }
    public static SessionFactory getSessionFactory(){
           if(sessionFactory == null) {
               sessionFactory = getConfig().buildSessionFactory(serviceRegistry);
               logger.debug("SessionFactory in HibernateUtil was create");
           }
           return sessionFactory;
    }
}
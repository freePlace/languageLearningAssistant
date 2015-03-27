package freeplace.lla.model.data;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("freeplace.lla.model")
public class DataConfig {
 
        private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
        private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
        private static final String DATABASE_DRIVER = "connection.driver_class";
        private static final String DATABASE_URL = "connection.url";
        private static final String DATABASE_USERNAME = "connection.username";
        private static final String DATABASE_PASSWORD = "connection.password";
        private static final String HIBERNATE_DIALECT = "hibernate.dialect";
        private static final String HIBERNATE_SHOW_SQL = "show_sql";
        private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "freeplace.lla.model.entities";

        private final org.hibernate.cfg.Configuration config = HibernateUtil.getConfig();
        
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(config.getProperty(DATABASE_DRIVER));
            dataSource.setUrl(config.getProperty(DATABASE_URL));
            dataSource.setUsername(config.getProperty(DATABASE_USERNAME));
            dataSource.setPassword(config.getProperty(DATABASE_PASSWORD));
            return dataSource;
        }
     
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(dataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
            entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
     
            return entityManagerFactoryBean;
        }
     
        @Bean
        public JpaTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
     
            return transactionManager;
        }
     
        private Properties getHibernateProperties() {
            Properties properties = new Properties();
            properties.put(PROP_HIBERNATE_DIALECT, config.getProperty(HIBERNATE_DIALECT));
            properties.put(PROP_HIBERNATE_SHOW_SQL, config.getProperty(HIBERNATE_SHOW_SQL));
            //properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, config.getProperty(HIBERNATE_HBM2DDL_AUTO));
     
            return properties;
        }
     
    }
package com.wypeboard.connector.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.wypeboard.connector.database")
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.wypeboard.model.persistence");

        Properties properties = getProperties();

        entityManagerFactoryBean.setJpaProperties(properties);
        return entityManagerFactoryBean;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
        // IMPORTANT! org.hibernate.flushMode = COMMIT must not be changed!!!
        // This is required to make sure we do not commit changes made to jpa object unintentionally.
        // We use detach in the code after changes are made and if we don't run with flushmode COMMIT, there's a risk that changes are pushed prior to the detach command,
        // causing changes to be persisted when really they should not.
        properties.put("org.hibernate.flushMode", "COMMIT");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

package com.spring.start.z_startup.configuration;

import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * this class is used for the database connection. It loads the property file
 * from classpath and inject it.
 * 
 * @author harsh.kumar1
 *
 */
@Configuration
@EnableTransactionManagement
//@PropertySource(value = { "classpath:application.properties" })
public class JpaConfig implements InitializingBean, DisposableBean{
	
	
	
//	@Value("${spring.user.datasource.driver-class-name}")
	private String databaseDriver;

//	@Value("${spring.datasource.url}")
	private String databaseURL;

//	@Value("${spring.datasource.username}")
	private String databaseUserName;

//	@Value("${spring.datasource.password}")
	private String databasePassword;

//	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateDDLAuto;
	
//	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String hibernateDialect;
	
//	@Value("${spring.jpa.show-sql}")
	private String hibernateShowSQL;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		//vendorAdapter.setDatabase(Database.POSTGRESQL);
		//vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.spring.start.z_startup.entity");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	
	

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 ResourceBundle res = PropertyResourceBundle.getBundle("application");
		databaseDriver = res.getString("spring.user.datasource.driver-class-name");
		databaseURL =  res.getString("spring.datasource.url");
		databaseUserName = res.getString("spring.datasource.username");
		databasePassword = res.getString("spring.datasource.password");
		 dataSource.setDriverClassName(databaseDriver);
		 
		dataSource.setUrl(databaseURL);
		dataSource.setUsername(databaseUserName);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		 ResourceBundle res = PropertyResourceBundle.getBundle("application");
		hibernateDDLAuto = res.getString("spring.jpa.hibernate.ddl-auto");
		hibernateDialect = res.getString("spring.jpa.properties.hibernate.dialect");
		hibernateShowSQL = res.getString("spring.jpa.show-sql");
		properties.setProperty("hibernate.hbm2ddl.auto", hibernateDDLAuto);
		properties.setProperty("hibernate.dialect", hibernateDialect);
		// properties.setProperty("hibernate.current_session_context_class",
		// env.getString("spring.jpa.properties.hibernate.current_session_context_class"));
		// properties.setProperty("hibernate.jdbc.lob.non_contextual_creation",
		// env.getString("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
		properties.setProperty("hibernate.show_sql", hibernateShowSQL);
		// properties.setProperty("hibernate.format_sql",
		// env.getString("spring.jpa.properties.hibernate.format_sql"));
		return properties;
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("destroy called......");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("after property set called......");
		
	}
}
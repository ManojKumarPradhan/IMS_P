package com.ims.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ims.model.Employee;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.ims")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	// DataSource
	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("dc"));
		basicDataSource.setUrl(env.getProperty("url"));
		basicDataSource.setUsername(env.getProperty("un"));
		basicDataSource.setPassword(env.getProperty("pwd"));

		basicDataSource.setInitialSize(3);
		basicDataSource.setMaxIdle(3);
		basicDataSource.setMinIdle(2);
		basicDataSource.setMaxTotal(3);
		return basicDataSource;
	}

	// SessionFactory
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		localSessionFactoryBean.setAnnotatedClasses(Employee.class);
		localSessionFactoryBean.setHibernateProperties(props());
		return localSessionFactoryBean;
	}

	private Properties props() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("dialect"));
		properties.put("hibernate.show_sql", env.getProperty("showsql"));
		properties.put("hibernate.format_sql", env.getProperty("fmtsql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return properties;
	}

	// HibernateTemplate
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		return new HibernateTemplate(getSessionFactory().getObject());
	}

	// Transaction Management
	@Bean
	public HibernateTransactionManager getTxManager() {
		return new HibernateTransactionManager(getSessionFactory().getObject());
	}

	// InternalResourceViewResolver
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		return new InternalResourceViewResolver(env.getProperty("mvc.prefix"), env.getProperty("mvc.suffix"));
	}

	// MultiPartResolver from file loading
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}

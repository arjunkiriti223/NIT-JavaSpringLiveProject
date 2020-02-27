package in.nit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
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

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
@ComponentScan("in.nit")
@EnableWebMvc
public class AppConfig {
	//create the Environment variable
	@Autowired
	private Environment evn;
	//DataSourse
	@Bean
	public DataSource ds() {
		
		BasicDataSource b=new BasicDataSource();
		b.setDriverClassName(evn.getProperty("db_driver"));
		b.setUrl(evn.getProperty("db_url"));
		b.setUsername(evn.getProperty("db_username"));
		b.setPassword(evn.getProperty("db_pwd"));
		
		return b;
	}
	//2 SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		s.setDataSource(ds());
		s.setHibernateProperties(props());
		s.setAnnotatedClasses(ShipmentType.class,Uom.class);
	
		return  s;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		
		p.put("hibernate.dialect", evn.getProperty("orm.dialect"));
		p.put("hibernate.show_sql",evn.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", evn.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", evn.getProperty("orm.ddlauto"));
		
		return p;
	}
	// 3 craete the HibernateTepmlete object
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		 return h;
	}
	
	// 4create object for tx
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager ht=new HibernateTransactionManager();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}
	//5 create vieResolver object
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix(evn.getProperty("mvc.prefix"));
		iv.setSuffix(evn.getProperty("mvc.suffix"));
		return iv;
	}
	
	//6 create CommonsMultiPartResolver object
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
}
	

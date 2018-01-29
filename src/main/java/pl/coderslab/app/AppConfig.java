package pl.coderslab.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//import pl.coderslab.converter.TemplateConverter;

/*
 * @Configuration - w klasie będą zawarte ziarna @Bean
 * @ComponentScan - szuka komponentów w podanych pakietach, które należy przeskanować
 * 
 */

@Configuration										
@ComponentScan(basePackages = {"pl.coderslab"})
@EnableTransactionManagement
@EnableJpaRepositories (basePackages = "pl.coderslab.repository")
public class AppConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("testDB");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	// do obsługi widoków
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	// formatery potrzebne do rejestracji convertera
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addConverter(getTemplateConverter());
//	}
//
//
//	// TEMPLATE CONVERTER
//	@Bean
//	public TemplateConverter getTemplateConverter() {
//		return new TemplateConverter();
//	}

	// plik tłumaczeń
	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}

	//walidator
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
package org.posiaden.bank.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

//Spring web and database config
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "org.posiaden.bank")
public class BankConfig implements WebMvcConfigurer {

    //set view folder in WEB-INF directory
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //set location of images, css, and js
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    //set properties file for custom error messages
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages/errors");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    //Establish connection to the MySQL server
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.driverClassName("com.mysql.jdbc.Driver");
        builder.url("jdbc:mysql://localhost:3306/banking?allowPublicKeyRetrieval=true&useSSL=false");
        builder.username("root");
        builder.password("Demetrios21043!");
        return builder.build();
    }

    //Create session factory for queries
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(getDataSource());
        bean.setPackagesToScan("org.posiaden.bank.entity");
        bean.setHibernateProperties(hibernateProperties());
        return bean;
    }

    //set database properties
    public final Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        return properties;
    }
}

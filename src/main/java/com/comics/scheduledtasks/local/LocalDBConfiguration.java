package com.comics.scheduledtasks.local;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "localEntityManagerFactory",
    transactionManagerRef = "localTransactionManager", basePackages = {"com.comics.scheduledtasks.local.repository"})
public class LocalDBConfiguration {
	@Primary
	@Bean(name = "localDataSource")
	  @ConfigurationProperties(prefix = "local.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	@Primary
	  @Bean(name = "localEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("localDataSource") DataSource dataSource) {
//	    return builder.dataSource(dataSource).packages("com.comics.scheduledtasks.entities").persistenceUnit("bar")
//	        .build();
		  return builder.dataSource(dataSource).packages("com.comics.scheduledtasks.entities").build();
	  }

	@Primary
	  @Bean(name = "localTransactionManager")
	  public PlatformTransactionManager barTransactionManager(
	      @Qualifier("localEntityManagerFactory") EntityManagerFactory localEntityManagerFactory) {
	    return new JpaTransactionManager(localEntityManagerFactory);
	  }
}

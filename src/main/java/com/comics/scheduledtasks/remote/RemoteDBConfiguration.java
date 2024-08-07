package com.comics.scheduledtasks.remote;

import javax.sql.DataSource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "remoteEntityManagerFactory",
    transactionManagerRef = "remoteTransactionManager", basePackages = {"com.comics.scheduledtasks.remote.repository"})
public class RemoteDBConfiguration {
	@Bean(name = "remoteDataSource")
	  @ConfigurationProperties(prefix = "remote.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "remoteEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("remoteDataSource") DataSource dataSource) {
//	    return builder.dataSource(dataSource).packages("com.comics.scheduledtasks.entities").persistenceUnit("bar")
//	        .build();
		  return builder.dataSource(dataSource).packages("com.comics.scheduledtasks.entities").build();
	  }

	  @Bean(name = "remoteTransactionManager")
	  public PlatformTransactionManager barTransactionManager(
	      @Qualifier("remoteEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
	    return new JpaTransactionManager(barEntityManagerFactory);
	  }
}

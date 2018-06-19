package com.collectio.configuration;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@SpringBootApplication
@ComponentScan("com.collectio")
@EnableNeo4jRepositories("com.collectio.repository")
public class CollectioApp {

	public static void main(String[] args) {
		SpringApplication.run(CollectioApp.class, args);
	}

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		return new org.neo4j.ogm.config.Configuration.Builder().uri("bolt://localhost").credentials("neo4j", "pwd@123")
				.build();
	}

	@Bean
	public Neo4jTransactionManager transactionManager() throws Exception {
		return new Neo4jTransactionManager(getSessionFactory());
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		return new SessionFactory(configuration(), "com.collectio.model");
	}
}

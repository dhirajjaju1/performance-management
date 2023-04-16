package com.performance.management;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.performance.management.security.EnvironmentPreparedListener;

@SpringBootApplication
@EnableMongoRepositories
public class PerformanceManagementApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PerformanceManagementApplication.class)
		.listeners(new EnvironmentPreparedListener())
		.run(args);
	}
}

package com.siva.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class OracleR2dbcConfig extends AbstractR2dbcConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	@Override
	public ConnectionFactory connectionFactory() {
		return ConnectionFactoryBuilder.withUrl(environment.getProperty("spring.r2dbc.url"))
				.username(environment.getProperty("spring.r2dbc.username"))
				.password(environment.getProperty("spring.r2dbc.password"))
				.build();
	}

	@Bean
	public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
		return new R2dbcEntityTemplate(connectionFactory);
	}

}

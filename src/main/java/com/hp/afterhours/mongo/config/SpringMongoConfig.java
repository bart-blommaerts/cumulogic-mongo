package com.hp.afterhours.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "mdb_test";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("15.185.160.x", 27017);
	}
}

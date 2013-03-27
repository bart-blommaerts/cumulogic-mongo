package com.hp.afterhours.mongo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hp.afterhours.mongo.config.SpringMongoConfig;
import com.hp.afterhours.mongo.model.Car;

public class CarService {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(
			SpringMongoConfig.class);

	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");

	public List<Car> findCars() {
		return mongoOperation.findAll(Car.class, "cars");
	}

	public void save(Car car) {
		mongoOperation.save(car, "cars");
	}

	public void update(Car car) {
		mongoOperation.updateMulti(
				new Query(
						Criteria.where("brand").is(car.getBrand())
						),
				Update.update("model", car.getModel()), "cars");
	}
	
	public Car findCarByBrand(String brand) {
		return mongoOperation
				.findOne(
						new Query(Criteria.where("brand").is(brand)
						),
						Car.class, "cars");
	}
	
	public void removeCarByBrand(String brand) {
		mongoOperation.remove(
					new Query(Criteria.where("brand").is(brand)
					),
					"cars");
	}
}
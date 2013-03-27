package com.hp.afterhours.mongo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.afterhours.mongo.model.Car;
import com.hp.afterhours.mongo.service.CarService;

/**
 * This Servlet was quickly hacked for demonstrating MongoDb.<br />
 * Do not use it for real work. Ever.
 */
public class MongoServlet extends HttpServlet {

	private static final long serialVersionUID = -3353123142320733735L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		CarService carService = new CarService();
		
		Car newCar = makeCar(req);
		if (newCar != null) {
			carService.save(newCar);
		}
		
		for (Car car : carService.findCars()) {
			out.println(car.getBrand() + " - " + car.getModel() + " - " + car.getHorsePower());
		}
		
		out.close();
	}
	
	private Car makeCar(HttpServletRequest req) {
		String[] brand = req.getParameterValues("brand");
		
		if (brand != null && brand.length == 1) {
			String[] model = req.getParameterValues("model");
			String[] horsePower = req.getParameterValues("horsepower");
			
			return new Car(brand[0], model[0], Integer.parseInt(horsePower[0]));
		} else {
			return null;
		}
	}
}

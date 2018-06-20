package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.Employee;

public class Salesman implements Employee {
	private double salary;
	
	private String name;
	
	private double monthlySales;

	public Salesman(double salary, String name, double monthlySales) {
		super();
		this.salary = salary;
		this.name = name;
		this.monthlySales = monthlySales;
	}

	@Override
	public double getSalary() {
		return salary + monthlySales * Challenge03SimpleProgram.SALESMAN_PERCENTAGE;
	}

	@Override
	public String getName() {
		return name;
	}

}

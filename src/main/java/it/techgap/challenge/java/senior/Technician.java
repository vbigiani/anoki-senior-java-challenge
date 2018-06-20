package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.Employee;

public class Technician implements Employee {
	private double salary;
	
	private String name;

	public Technician(double salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public String getName() {
		return name;
	}

}

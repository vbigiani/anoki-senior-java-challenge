package it.techgap.challenge.java.senior;

import java.util.Arrays;
import java.util.stream.Stream;

import it.techgap.challenge.java.senior.beans.Employee;

public class Manager implements Employee {
	private String name;

	private double salary;
	
	private Employee[] directSubordinates;
	
	public Manager(String name, double salary, Employee... directSubordinates) {
		super();
		this.name = name;
		this.salary = salary;
		this.directSubordinates = directSubordinates;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getSalary() {
		if (directSubordinates == null) {
			return salary;
		}
		return salary + getRestOfTeamStream().mapToDouble(Employee::getSalary).sum() * Challenge03SimpleProgram.MANAGER_PERCENTAGE;
	}

	private Stream<Employee> getRestOfTeamStream() {
		if (directSubordinates == null) {
			return Stream.of();
		}
		return Arrays.stream(directSubordinates).flatMap(sub -> {
			if (sub instanceof Manager) {
				return Stream.concat(Stream.of(sub), ((Manager) sub).getRestOfTeamStream());
			} else {
				return Stream.of(sub);
			}
		});
	}
}

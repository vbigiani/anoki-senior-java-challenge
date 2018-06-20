package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.Employee;

public class Challenge03SimpleProgram {
	public static double SALESMAN_PERCENTAGE = 0.1;
	
	public static double MANAGER_PERCENTAGE = 0.005;

    /**
     * A Technician only gets his base salary each month
     *
     * @param name           The name of the {@link Employee}
     * @param startingSalary The starting salary of the {@link Employee}
     * @return A well-built {@link Employee}
     */
    public static Employee getTechnician(String name, int startingSalary) {
        return new Technician(startingSalary, name);
    }

    /**
     * A Salesman gets his base salary plus 10% of his monthly sales
     *
     * @param name           The name of the {@link Employee}
     * @param startingSalary The starting salary of the {@link Employee}
     * @param monthlySales   The monthly sales of that {@link Employee}
     * @return A well-built {@link Employee}
     */
    public static Employee getSalesman(String name, int startingSalary, int monthlySales) {
        return new Salesman(startingSalary, name, monthlySales);
    }

    /**
     * A Manager gets his base salary plus 0,5% of the total salary of all managed members below him (at all levels)
     * E.g. If A manages B that manages C, C's salary will count towards both A and B salaries
     *
     * @param name               The name of the {@link Employee}
     * @param startingSalary     The starting salary of the {@link Employee}
     * @param directSubordinates The direct subordinates of the {@link Employee}. <br />
     *                           In the given example, this is B for the manager A
     * @return A well-built {@link Employee}
     */
    public static Employee getManager(String name, int startingSalary, Employee... directSubordinates) {
        return new Manager(name, startingSalary, directSubordinates);
    }
}

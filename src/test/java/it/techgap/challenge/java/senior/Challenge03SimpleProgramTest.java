package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Challenge03SimpleProgramTest {
    private static final int MANAGER_SALARY = 1_500;
    private static final int SELLER_SALARY = 500;
    private static final int TECH_SALARY = 1_400;

    // =================================================
    // This test class is not meant to be changed!
    // =================================================

    @Test
    public void testTechnician() {
        Employee tech = Challenge03SimpleProgram.getTechnician("Tech#01", 1_500);
        assertNotNull(tech);
        assertEquals(1_500, tech.getSalary(), 1e-10);
        assertEquals("Tech#01", tech.getName());
    }

    @Test
    public void testSalesman() {
        Employee salesman = Challenge03SimpleProgram.getSalesman("Sales#01", 500, 15_000);
        assertNotNull(salesman);
        assertEquals(2_000, salesman.getSalary(), 1e-10);
        assertEquals("Sales#01", salesman.getName());
    }

    @Test
    public void testManager() {
        Employee sub01 = Challenge03SimpleProgram.getTechnician("Subordinate#01", 300);
        Employee manager = Challenge03SimpleProgram.getManager("Manager#01", 1_500, sub01);
        assertNotNull(sub01);
        assertNotNull(manager);
        assertEquals(1_501.5, manager.getSalary(), 1e-10);
        assertEquals("Manager#01", manager.getName());
    }

    @Test
    public void testWholeCompany() {
        Employee sam = Challenge03SimpleProgram.getSalesman("Sam", SELLER_SALARY, 15_000);
        Employee teresa = Challenge03SimpleProgram.getTechnician("Teresa", TECH_SALARY);
        Employee matt = Challenge03SimpleProgram.getManager("Matt", MANAGER_SALARY, sam, teresa);
        Employee susan = Challenge03SimpleProgram.getSalesman("Susan", SELLER_SALARY, 17_000);
        Employee maria = Challenge03SimpleProgram.getManager("Maria", MANAGER_SALARY, matt, susan);

        assertNotNull(sam);
        assertNotNull(teresa);
        assertNotNull(matt);
        assertNotNull(susan);
        assertNotNull(maria);
        assertEquals(2_000, sam.getSalary(), 1e-10);
        assertEquals(1_400, teresa.getSalary(), 1e-10);
        assertEquals(1_517, matt.getSalary(), 1e-10);
        assertEquals(2_200, susan.getSalary(), 1e-10);
        assertEquals(1_535.585, maria.getSalary(), 1e-10);
    }
}
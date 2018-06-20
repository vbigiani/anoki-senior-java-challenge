package it.techgap.challenge.java.senior;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

/**
 * This test uses an in-memory <a href="http://www.h2database.com/">H2 database</a>
 */
public class Challenge04SSQL {

    /**
     * TODO: Implement this
     */
    public static class ManagerWithCount {

        public ManagerWithCount(String cf, long count) {
        }

    }

    /**
     * Gets the CF of all employees aged more than minAge
     *
     * @param connection A JDBC Connection
     * @param minAge     Minimum age to consider
     * @return A set of employees's CF
     * @throws SQLException If anything goes wrong
     */
    public static Collection<String> selectCFOfEmployeesAgedMoreThan(Connection connection, int minAge) throws SQLException {
        return null;
    }

    /**
     * Gets the CF of all employees whose manager has a salary of more than minSalary euros
     *
     * @param connection A JDBC Connection
     * @param minSalary  Minimum salary to consider
     * @return A set of employees' CF
     * @throws SQLException If anything goes wrong
     */
    public static Collection<String> selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan(
            Connection connection,
            int minSalary
    ) throws SQLException {
        return null;
    }

    /**
     * Retrieves all the managers with their respective subordinates count if and only if the manager has more than
     * minSubordinates subordinates
     *
     * @param connection      A JDBC Connection
     * @param minSubordinates Minimum number of subordinates to consider
     * @return A well-built collection of {@link ManagerWithCount}
     * @throws SQLException If anything goes wrong
     */
    public static Collection<ManagerWithCount> getManagersWithMoreThanXSubordinates(
            Connection connection,
            int minSubordinates
    ) throws SQLException {
        return null;
    }

}

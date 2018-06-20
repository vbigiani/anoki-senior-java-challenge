package it.techgap.challenge.java.senior;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This test uses an in-memory <a href="http://www.h2database.com/">H2 database</a>
 */
public class Challenge04SSQL {

    /**
     * TODO: Implement this
     */
    public static class ManagerWithCount {
    	private String cf;
    	
    	private long count;

        public ManagerWithCount(String cf, long count) {
        	this.cf = cf;
        	this.count = count;
        }

		public String getCf() {
			return cf;
		}

		public long getCount() {
			return count;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cf == null) ? 0 : cf.hashCode());
			result = prime * result + (int) (count ^ (count >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ManagerWithCount other = (ManagerWithCount) obj;
			if (cf == null) {
				if (other.cf != null)
					return false;
			} else if (!cf.equals(other.cf))
				return false;
			if (count != other.count)
				return false;
			return true;
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
    	try (PreparedStatement st = connection.prepareStatement("SELECT CF FROM EMPLOYEE WHERE AGE > ?")) {
    		st.setInt(1, minAge);
    		try (ResultSet rs = st.executeQuery()) {
    			List<String> result = new ArrayList<>();
    			while (rs.next()) {
    				result.add(rs.getString(1));
    			}
    			return result;
    		}
    	}
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
    	try (PreparedStatement st = connection.prepareStatement("SELECT E.CF FROM EMPLOYEE E"
    			+ " LEFT JOIN EMPLOYEE M ON E.MANAGER_CF = M.CF"
    			+ " WHERE COALESCE(M.SALARY, 0) > ?")) {
    		st.setInt(1, minSalary);
    		try (ResultSet rs = st.executeQuery()) {
    			List<String> result = new ArrayList<>();
    			while (rs.next()) {
    				result.add(rs.getString(1));
    			}
    			return result;
    		}
    	}
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
    	try (PreparedStatement st = connection.prepareStatement("SELECT MANAGER_CF, COUNT(1) FROM EMPLOYEE "
    			+ " WHERE MANAGER_CF IS NOT NULL"
    			+ " GROUP BY MANAGER_CF"
    			+ " HAVING COUNT(1) > ?")) {
    		st.setInt(1, minSubordinates);
    		try (ResultSet rs = st.executeQuery()) {
    			List<ManagerWithCount> result = new ArrayList<>();
    			while (rs.next()) {
    				result.add(new ManagerWithCount(rs.getString(1), rs.getLong(2)));
    			}
    			return result;
    		}
    	}
    }

}

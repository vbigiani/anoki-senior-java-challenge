package it.techgap.challenge.java.senior;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.Collection;

public class Challenge04SQLTest {

    private static final String JDBC_URL = "jdbc:h2:mem:challenge_sql;DB_CLOSE_DELAY=-1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "";
    private static final String JDBC_DRIVER = "org.h2.Driver";

    private IDatabaseTester databaseTester;

    @BeforeClass
    public static void createTable() throws Exception {
        RunScript.execute(JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD,
                "src/test/resources/it/techgap/challenge/java/senior/schema.sql",
                Charset.forName("UTF-8"),
                false
        );
    }

    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder()
                .setDtdMetadata(true)
                .setMetaDataSetFromDtd(getClass().getResourceAsStream("schema.dtd"))
                .build(getClass().getResourceAsStream("challenge-sql-dataset.xml"));
    }


    @Test
    public void selectCFOfEmployeesAgedMoreThan30() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<String> res = Challenge04SSQL.selectCFOfEmployeesAgedMoreThan(c, 30);
            final String[] expected = {
                    "XXXXX00X00X003M",
                    "XXXXX00X00X002M",
                    "XXXXX00X00X007D",
                    "XXXXX00X00X005D",
                    "XXXXX00X00X004D",
                    "XXXXX00X00X021D",
                    "XXXXX00X00X031D",
                    "XXXXX00X00X041D"
            };
            Assert.assertNotNull(res);
            Assert.assertEquals(expected.length, res.size());
            Assert.assertThat(res, CoreMatchers.hasItems(expected));
        }
    }


    @Test
    public void selectCFOfEmployeesAgedMoreThan999() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<String> res = Challenge04SSQL.selectCFOfEmployeesAgedMoreThan(c, 999);
            Assert.assertNotNull(res);
            Assert.assertEquals(0, res.size());
        }
    }

    @Test
    public void selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan30K() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<String> res = Challenge04SSQL.selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan(c, 30_000);
            final String[] expected = {
                    "XXXXX00X00X031D",
                    "XXXXX00X00X041D",
                    "XXXXX00X00X011D",
                    "XXXXX00X00X021D",
                    "XXXXX00X00X002D",
                    "XXXXX00X00X001D",
                    "XXXXX00X00X004D"
            };
            Assert.assertNotNull(res);
            Assert.assertEquals(expected.length, res.size());
            Assert.assertThat(res, CoreMatchers.hasItems(expected));
        }
    }

    @Test
    public void selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan100K() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<String> res = Challenge04SSQL.selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan(c, 100_000);
            Assert.assertNotNull(res);
            Assert.assertEquals(0, res.size());
        }
    }

    @Test
    public void selectCfOfMangerAndNumberOfHisSubordinatesForManagersWithMoreThan2Subordinates() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<Challenge04SSQL.ManagerWithCount> res = Challenge04SSQL.getManagersWithMoreThanXSubordinates(c, 2);
            final Challenge04SSQL.ManagerWithCount[] expected = {
                    new Challenge04SSQL.ManagerWithCount("XXXXX00X00X001M", 5)
            };
            Assert.assertNotNull(res);
            Assert.assertEquals(expected.length, res.size());
            Assert.assertThat(res, CoreMatchers.hasItems(expected));
        }
    }

    @Test
    public void selectCfOfMangerAndNumberOfHisSubordinatesForManagersWithMoreThan20Subordinates() throws Exception {
        final IDatabaseConnection connection = databaseTester.getConnection();
        try (Connection c = connection.getConnection()) {
            final Collection<Challenge04SSQL.ManagerWithCount> res = Challenge04SSQL.getManagersWithMoreThanXSubordinates(c, 20);
            Assert.assertNotNull(res);
            Assert.assertEquals(0, res.size());
        }
    }

}
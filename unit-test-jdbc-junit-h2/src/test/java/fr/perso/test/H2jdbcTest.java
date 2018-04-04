/**
 *
 */
package fr.perso.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.perso.service.SimplePojoService;

/**
 * @author cnoiray
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beanRefContext.xml" })
public class H2jdbcTest {

    // JDBC driver et url base de donnée
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:~/test.h2.db";

    // Database credentials
    final String USER = "sa";
    final String PASS = "";

    @Autowired
    private SimplePojoService simplePojoDao;

    @Before
    public void before() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            final String sql = simplePojoDao.createTableRequest();
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (final SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (final Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (final SQLException se2) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (final SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Test
    public void test() {

        System.out.println("Goodbye!");
    }
}

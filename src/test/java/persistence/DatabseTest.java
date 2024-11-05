package persistence;

import deployment.Deployment;
import invoice.Invoice;
import org.junit.jupiter.api.Test;

import java.sql.*;

class DatabseTest {

    @Test
    void testAdd() throws Exception {
        Deployment deployment = new Deployment();
        Invoice invoice = new Invoice(deployment);
        //int idBefore = queryId();

        Database.add(invoice);
        //int idAfter = queryId();

        //System.out.println("before: " + idBefore);
        //System.out.println("after: " + idAfter);
    }

    private int queryId() throws Exception {
        int id;

        Connection connection = SQLiteHelper.getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                        SELECT MAX(id) FROM invoice
                        """;
        ResultSet rs = statement.executeQuery(sql);
        id = rs.getInt(1);
        statement.close();

        return id;
    }
}
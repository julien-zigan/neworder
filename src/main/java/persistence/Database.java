package persistence;

import invoice.Invoice;

import java.sql.Connection;
import java.sql.Statement;

public class Database {
    public static void add(Invoice invoice) throws Exception {
        Connection connection = SQLiteHelper.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(
                        """
                        INSERT INTO invoice (invoiceNr, path)
                            values (%d, '%s');
                        """, invoice.getInvoiceNr(), invoice.getPath());
        statement.executeUpdate(sql);
        statement.close();
    }
}

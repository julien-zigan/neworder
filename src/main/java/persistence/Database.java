package persistence;

import invoice.Invoice;
import user.User;

import java.sql.Connection;
import java.sql.ResultSet;
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

    public static void add(User u) throws Exception {
        Connection connection = SQLiteHelper.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(
                """
                INSERT INTO user (
                                company,
                                firstName,
                                additional,
                                lastName,
                                street,
                                zip,
                                city,
                                email,
                                phone,
                                website,
                                bankname,
                                iban,
                                bic)
                values ('%s', '%s', '%s', '%s', '%s',
                        '%s', '%s', '%s', '%s', '%s',
                        '%s', '%s', '%s')
                """,
                u.getCompany(),
                u.getFirstName(),
                u.getAdditional(),
                u.getLastName(),
                u.getStreet(),
                u.getZip(),
                u.getCity(),
                u.getEmail(),
                u.getPhone(),
                u.getWebsite(),
                u.getBankname(),
                u.getIban(),
                u.getBic()
        );
        statement.executeUpdate(sql);
        statement.close();
    }

    public static void loadUserData(User user) throws Exception {
        Connection connection = SQLiteHelper.getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                            SELECT * FROM user ORDER BY ID DESC LIMIT 1
                            """;
        ResultSet rs = statement.executeQuery(sql);


        user.setCompany(rs.getString("company"));
        user.setFirstName(rs.getString("firstName"));
        user.setAdditional(rs.getString("additional"));
        user.setLastName(rs.getString("lastName"));
        user.setStreet(rs.getString("street"));
        user.setZip(rs.getString("zip"));
        user.setCity(rs.getString("city"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setWebsite(rs.getString("website"));
        user.setBankname(rs.getString("bankname"));
        user.setIban(rs.getString("iban"));
        user.setBic(rs.getString("bic"));
    }
}

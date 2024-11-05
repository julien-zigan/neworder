package invoice;

import java.sql.*;
import java.time.LocalDate;

public class InvoiceNrGenerator {
    public static int generate() {
        int id;

        try {
            String url = "jdbc:sqlite:./jdeployments_data/jdeployments.db";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String sql = """
                            SELECT MAX(id) FROM invoice
                            """;
            ResultSet rs = statement.executeQuery(sql);

            id = rs.getInt(1);

            //increment id, to convert lastid to currentid
            id++;


        } catch (SQLException se) {
            System.err.println(se.getMessage());
            id = 0;
        }

        LocalDate date = LocalDate.now();
        int year = date.getYear();

        return concatenateNumbers(year, id);
    }

    private static int concatenateNumbers(int n, int m) {
        return n * 10_000 + m;
    }

}

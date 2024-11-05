package invoice;

import persistence.SQLiteHelper;

import java.sql.*;
import java.time.LocalDate;

public class InvoiceNrGenerator {
    public static int generate() {
        int id;

        try {
            Connection connection = SQLiteHelper.getConnection();
            Statement statement = connection.createStatement();
            String sql = """
                            SELECT MAX(id) FROM invoice
                            """;
            ResultSet rs = statement.executeQuery(sql);

            id = rs.getInt(1);

            //increment id, to convert lastid to currentid
            id++;


        } catch (Exception e) {
            System.err.println(e.getMessage());
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

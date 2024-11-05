package Initializing;

import persistence.SQLiteHelper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUpDataBase {

    public static void main(String[] args) {
        setUpDataFolder();
        setUpFileFolder();
        setUpUserTable();
        setUpInvoiceTable();
    }

    private static void setUpDataFolder() {
        File theDir = new File("./jdeployments_data");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }

    private static void setUpFileFolder() {
        File theDir = new File("./invoices");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }

    private static void setUpUserTable() {
        try {
            Connection connection = SQLiteHelper.getConnection();
            Statement statement = connection.createStatement();
            String sql = """
                            create table if not exists user (
                                id integer primary key autoincrement,
                                company text,
                                firstName text,
                                additional text,
                                lastName text,
                                street text,
                                zip text,
                                city text,
                                email text,
                                phone text,
                                website text,
                                bankname text,
                                iban text,
                                bic text)
                            """;
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception e) {
            System.err.println(e.getMessage() + "in SetUpUserTable");
        }
    }

    private static void setUpInvoiceTable() {
        try {
            Connection connection = SQLiteHelper.getConnection();
            Statement statement = connection.createStatement();
            String sql = """
                            CREATE TABLE IF NOT EXISTS invoice (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                invoiceNr INTEGER,
                                path TEXT
                                );
                            """;
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception e) {
            System.err.println(e.getMessage() + "inSetUpInvoiceTable");
        }
    }

}

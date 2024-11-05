package persistence;

import deployment.Deployment;
import invoice.Invoice;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabseTest {

    @Test
    void testAdd() {
        Deployment deployment = new Deployment();

        Invoice invoice1 = new Invoice(deployment);
        Database.add(invoice1);

        Invoice invoice2 = new Invoice(deployment);
        Database.add(invoice2);

        assertEquals(invoice1.getInvoiceNr() + 1, invoice2.getInvoiceNr());
    }
}

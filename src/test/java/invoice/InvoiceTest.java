package invoice;

import deployment.Deployment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    @Test
    public void testConstructor() {
        LocalDate today = LocalDate.now();
        Deployment deployment = new Deployment();
        Invoice invoice = new Invoice(deployment);
        String expectedPath = String.format(
                "./invoices/%s-%d",
                today.toString(),
                InvoiceNrGenerator.generate()
        );

        assertEquals(today.toString(), invoice.getDate().toString());
        assertEquals(deployment, invoice.getDeployment());
        assertEquals(expectedPath, invoice.getPath());
    }
}
package invoice;

import core.deployment.Deployment;
import core.invoice.Invoice;
import core.invoice.InvoiceNrGenerator;
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
                "./invoices/%s-%d.pdf",
                today.toString(),
                InvoiceNrGenerator.generate()
        );

        assertEquals(today.toString(), invoice.getDate().toString());
        assertEquals(deployment, invoice.getDeployment());
        assertEquals(expectedPath, invoice.getPath());
    }
}
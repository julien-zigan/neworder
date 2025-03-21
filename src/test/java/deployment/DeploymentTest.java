package deployment;

import core.deployment.Deployment;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static deployment.ReferenceTexts.*;
import static org.junit.jupiter.api.Assertions.*;

class DeploymentTest {

    @Test
    public void testConstructor() throws IOException {
        File file = new File("C:\\developer\\neworder\\src\\test\\ressources\\TestConfirmation.pdf");
        PDDocument confirmation = Loader.loadPDF(file);

        Deployment deployment = new Deployment(confirmation);

        assertEquals(50., deployment.getRate());
        assertTrue(deployment.isTravelPaid());
        assertEquals(10., deployment.getTravelcostRate());
        assertEquals(DATE.getText(), deployment.getDate());
        assertEquals(DURATION.getNumber(), deployment.getDuration());
        assertEquals(LANGUAGE.getText(), deployment.getLanguage());
        assertEquals(CONTRACTOR.getText(), deployment.getContractor());
        assertEquals(CLIENT.getText(), deployment.getClient());
        assertEquals(TOTAL.getNumber(), deployment.getTotal());
        assertEquals(INVOICE_ADDRESS.getText(), deployment.getInvoiceAdress());
    }
}
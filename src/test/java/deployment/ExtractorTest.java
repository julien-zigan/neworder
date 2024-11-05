package deployment;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static deployment.Extractor.*;
import static deployment.ReferenceTexts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtractorTest {

    @Test
    void testGetText() throws IOException {
        //String referenceText = Files.readString(Path.of("X:\\neworder\\src\\test\\ressources\\reference.txt"));
        String referenceText = CONFIRMATION.getText();
        File pdfFile = new File("X:\\neworder\\src\\test\\ressources\\TestConfirmation.pdf");
        PDDocument pdf = Loader.loadPDF(pdfFile);

        assertEquals(referenceText, getText(pdf));
    }

    @Test
    void testGetOrderNr() {
        String extractedNr = getOrderNr(CONFIRMATION.getText());
        assertEquals(ORDER_NR.getText(), extractedNr);
    }

    @Test
    void testGetAddress() {
        String extractedNr = getAddress(CONFIRMATION.getText());
        assertEquals(ADDRESS.getText(), extractedNr);
    }

    @Test
    void testGetDate() {
        String extractedDate = getDate(CONFIRMATION.getText());
        assertEquals(DATE.getText(), extractedDate);
    }

    @Test
    void testGetDuration() {
        double extractedDuration = getDuration(CONFIRMATION.getText());
        assertEquals(DURATION.getNumber(), extractedDuration);
    }

    @Test
    void testGetLanguage() {
        String extractedLanguage = getLanguage(CONFIRMATION.getText());
        assertEquals(LANGUAGE.getText(), extractedLanguage);
    }

    @Test
    void testGetContractor() {
        String extractedContractor = getContractor(CONFIRMATION.getText());
        assertEquals(CONTRACTOR.getText(), extractedContractor);
    }

    @Test
    void testGetClient() {
        String extractedClient = getClient(CONFIRMATION.getText());
        assertEquals(CLIENT.getText(), extractedClient);
    }

}
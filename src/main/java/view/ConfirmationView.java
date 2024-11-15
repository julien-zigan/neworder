package view;

import core.invoice.PDFInvoice;
import gui.DeploymentConfirmationFrame;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfirmationView {
    static File confirmation;
    static PDFInvoice invoice;


    public static PDFInvoice getInvoice() {
        return invoice;
    }

    public static void setInvoice(PDFInvoice invoice) {
        ConfirmationView.invoice = invoice;
    }

    public static void setConfirmation(File file) throws IOException {
        ConfirmationView.confirmation = file;
        DeploymentConfirmationFrame.instance.drawConfirmation();
    }

    public static File getConfirmation() {
        return ConfirmationView.confirmation;
    }
}

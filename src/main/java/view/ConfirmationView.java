package view;

import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import gui.DeploymentConfirmationFrame;
import gui.WorkbenchFrame;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfirmationView {
    static File confirmation;
    static PDFInvoice pdfInvoice;

    public static Invoice getInvoice() {
        return invoice;
    }

    public static void setInvoice(Invoice invoice) throws IOException {
        ConfirmationView.invoice = invoice;
        WorkbenchFrame.instance.drawInvoice();
    }

    static Invoice invoice;


    public static PDFInvoice getPDFInvoice() {
        return ConfirmationView.pdfInvoice;
    }

    public static void setPDFInvoice(PDFInvoice invoice) throws IOException {
        ConfirmationView.pdfInvoice = invoice;
        WorkbenchFrame.instance.drawInvoice();
    }

    public static void setConfirmation(File file) throws IOException {
        ConfirmationView.confirmation = file;
        DeploymentConfirmationFrame.instance.drawConfirmation();
    }

    public static File getConfirmation() {
        return ConfirmationView.confirmation;
    }
}

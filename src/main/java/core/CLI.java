package core;

import core.deployment.Deployment;
import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import core.invoice.PDFInvoiceGenerator;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import core.persistence.Database;
import core.user.User;
import view.ConfirmationView;

import java.io.File;

public class CLI {

    public static void main(String[] args) throws Exception {
        User user = Database.loadUserData();

        //File file = new File("C:\\developer\\neworder\\src\\test\\ressources\\TestConfirmation.pdf");
        File file = ConfirmationView.getConfirmation();
        PDDocument confirmation = Loader.loadPDF(file);

        Deployment deployment = new Deployment(confirmation);
       // deployment.setTravelPaid(false);
        Invoice invoice = new Invoice(deployment);

        PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);
        Database.add(invoice);
        pdfInvoice.save(new File(invoice.getPath()));

    }

}

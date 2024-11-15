package gui;

import core.user.User;
import core.deployment.Deployment;
import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import core.invoice.PDFInvoiceGenerator;
import core.persistence.Database;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import view.ConfirmationView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static gui.Layouter.setExternalLayout;

public class UtilitiesFrame extends JInternalFrame {
    public UtilitiesFrame(GridBagLayout gridbag) throws Exception {
        super("Utilities");
        setFrameIcon(null);
        setExternalLayout(this, gridbag, 0, 0, 1, 3);

        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            User user = Database.loadUserData();

            File f = fileChooser.getSelectedFile();
            ConfirmationView.setConfirmation(f);
            PDDocument confirmation = Loader.loadPDF(f);

            Deployment deployment = new Deployment(confirmation);
            // deployment.setTravelPaid(false);
            Invoice invoice = new Invoice(deployment);

            PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);
            ConfirmationView.setInvoice(pdfInvoice);
//            Database.add(invoice);
//            pdfInvoice.save(new File(invoice.getPath()));

            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
        //add(fileChooser);
        setVisible(true);
    }
}
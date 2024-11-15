package gui;

import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.ConfirmationView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static gui.Layouter.setExternalLayout;

public class WorkbenchFrame extends JInternalFrame {
    public static WorkbenchFrame instance;

    public WorkbenchFrame(GridBagLayout gridbag) {
        super("My Invoice");
        setFrameIcon(null);
        setExternalLayout(
                this, gridbag, 1, 0, 1, 3, 2., 1.);

//        GridBagLayout innerGridbag = new GridBagLayout();
//        setLayout(innerGridbag);

        setVisible(true);

        instance = this;
    }

    public void drawInvoice() throws IOException {
        PDDocument invoice = ConfirmationView.getPDFInvoice();
        PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(invoice);
        BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
        ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
        JLabel ConfirmationLabel = new JLabel(confirmationImage);
        JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);
        this.add(confirmationView);
    }
}

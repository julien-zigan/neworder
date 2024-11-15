package gui;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.ConfirmationView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeploymentConfirmationFrame extends JInternalFrame {
    public static DeploymentConfirmationFrame instance;

    public DeploymentConfirmationFrame(GridBagLayout gridbag) {
        super("Deployment Confirmation");
        setFrameIcon(null);
        Layouter.setExternalLayout(this, gridbag, 2, 0, 1, 1);

        setVisible(true);

        instance = this;
    }

    public void drawConfirmation() throws IOException {
        File confirmation = ConfirmationView.getConfirmation();
        PDDocument pdDocument = Loader.loadPDF(confirmation);
        PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(pdDocument);
        BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
        ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
        JLabel ConfirmationLabel = new JLabel(confirmationImage);
        JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);
        this.add(confirmationView);
        this.repaint();
    }
}
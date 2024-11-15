package gui;

import core.deployment.Deployment;
import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import core.invoice.PDFInvoiceGenerator;
import core.persistence.Database;
import core.user.User;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.ConfirmationView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlFrame extends JInternalFrame {
    public ControlFrame(GridBagLayout gridbag) {
        super("Controls");
        setFrameIcon(null);
        Layouter.setExternalLayout(this, gridbag, 2, 1, 1, 1);

        setLayout(new GridLayout());

//        JButton editBtn = new JButton("Daten korrigieren");
//        add(editBtn);

        JPanel hoursPanel = new JPanel();
        JLabel hoursLabel = new JLabel("Geleistete Stunden");
        hoursPanel.add(hoursLabel);
        Float[] h = {1f, 2f, 2.5f, 3f, 3.5f, 4f, 4.5f, 5f};
        JComboBox<Float> hourSetter = new JComboBox<>(h);
        hourSetter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int i = hourSetter.getSelectedIndex();
                float f = h[i];
                System.out.println("Selected" + i + "= " + f);

                Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                deployment.setDuration((double) f);
                System.out.println(ConfirmationView.getInvoice().getDeployment().getDuration());
                // deployment.setTravelPaid(false);
                Invoice invoice = new Invoice(deployment);
                User user;
                try {
                    user = Database.loadUserData();
                    PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);

                    JScrollPane jsp = (JScrollPane) WorkbenchFrame.instance.getContentPane().getComponent(0);
                    WorkbenchFrame.instance.getContentPane().remove(0);

                    PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(pdfInvoice);
                    BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
                    ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
                    JLabel ConfirmationLabel = new JLabel(confirmationImage);
                    JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);


                    WorkbenchFrame.instance.getContentPane().add(confirmationView);

                    WorkbenchFrame.instance.revalidate();
                    WorkbenchFrame.instance.repaint();





                    pdfInvoice.save(new File(invoice.getPath()));



                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }



//            // deployment.setTravelPaid(false);//




            }
        });
        hoursPanel.add(hourSetter);
        add(hoursPanel);

        JPanel ratePanel = new JPanel();
        JLabel rateLabel = new JLabel("Stundensatz in Euro");
        ratePanel.add(rateLabel);
        Float[] r = {30f, 35f, 40f, 45f, 50f, 55f, 60f, 65f, 70f, 75f, 80f, 85f, 90f, 95f, 100f};
        JComboBox<Float> rateSetter = new JComboBox<>(r);
        rateSetter.setSelectedIndex(4);
        rateSetter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int i = rateSetter.getSelectedIndex();
                float f = r[i];

                Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                deployment.setRate((double) f);
                // deployment.setTravelPaid(false);
                Invoice invoice = new Invoice(deployment);
                User user;
                try {
                    user = Database.loadUserData();
                    PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);

                    JScrollPane jsp = (JScrollPane) WorkbenchFrame.instance.getContentPane().getComponent(0);
                    WorkbenchFrame.instance.getContentPane().remove(0);

                    PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(pdfInvoice);
                    BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
                    ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
                    JLabel ConfirmationLabel = new JLabel(confirmationImage);
                    JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);


                    WorkbenchFrame.instance.getContentPane().add(confirmationView);

                    WorkbenchFrame.instance.revalidate();
                    WorkbenchFrame.instance.repaint();


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        ratePanel.add(rateSetter);
        add(ratePanel);

//        JPanel signaturePanel = new JPanel(new GridLayout(3, 0));
//        JLabel signatureLabel = new JLabel("Unterschrift hinzufügen");
//        signaturePanel.add(signatureLabel);
//
//        ButtonGroup bg = new ButtonGroup();
//        JRadioButton manual = new JRadioButton("von Hand");
//        manual.setSelected(true);
//        JRadioButton automatic = new JRadioButton("automatisch");
//        bg.add(manual);
//        bg.add(automatic);
//        signaturePanel.add(manual);
//        signaturePanel.add(automatic);
//
//        add(signaturePanel);


        JPanel signaturePanel = new JPanel(new GridLayout(3, 0));
        JLabel signatureLabel = new JLabel("Anfahrtskosen");
        signaturePanel.add(signatureLabel);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton manual = new JRadioButton("Ja");
        manual.setSelected(true);
        manual.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                    deployment.setTravelPaid(false);
                    Invoice invoice = new Invoice(deployment);
                    User user;
                    try {
                        user = Database.loadUserData();
                        PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);

                        JScrollPane jsp = (JScrollPane) WorkbenchFrame.instance.getContentPane().getComponent(0);
                        WorkbenchFrame.instance.getContentPane().remove(0);

                        PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(pdfInvoice);
                        BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
                        ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
                        JLabel ConfirmationLabel = new JLabel(confirmationImage);
                        JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);


                        WorkbenchFrame.instance.getContentPane().add(confirmationView);

                        WorkbenchFrame.instance.revalidate();
                        WorkbenchFrame.instance.repaint();


                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                    deployment.setTravelPaid(true);
                    Invoice invoice = new Invoice(deployment);
                    User user;
                    try {
                        user = Database.loadUserData();
                        PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);

                        JScrollPane jsp = (JScrollPane) WorkbenchFrame.instance.getContentPane().getComponent(0);
                        WorkbenchFrame.instance.getContentPane().remove(0);

                        PDFRenderer ConfirmationPdfRenderer = new PDFRenderer(pdfInvoice);
                        BufferedImage ConfirmationPageImage = ConfirmationPdfRenderer.renderImage(0);// Render first page
                        ImageIcon confirmationImage = new ImageIcon(ConfirmationPageImage);
                        JLabel ConfirmationLabel = new JLabel(confirmationImage);
                        JScrollPane confirmationView = new JScrollPane(ConfirmationLabel);


                        WorkbenchFrame.instance.getContentPane().add(confirmationView);

                        WorkbenchFrame.instance.revalidate();
                        WorkbenchFrame.instance.repaint();


                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        JRadioButton automatic = new JRadioButton("Nein");
        bg.add(manual);
        bg.add(automatic);
        signaturePanel.add(manual);
        signaturePanel.add(automatic);


        add(signaturePanel);

        JButton saveBtn = new JButton("Speichern");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                deployment.setTravelPaid(false);
                Invoice invoice = new Invoice(deployment);
                User user;
                try {
                    user = Database.loadUserData();
                    PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);
                    Database.add(invoice);
                    pdfInvoice.save(invoice.getPath());

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(saveBtn);

        JButton printBtn = new JButton("Drucken");
        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deployment deployment = ConfirmationView.getInvoice().getDeployment();
                deployment.setTravelPaid(false);
                Invoice invoice = new Invoice(deployment);
                User user;
                try {
                    user = Database.loadUserData();
                    PDFInvoice pdfInvoice = PDFInvoiceGenerator.generate(user, invoice);
                    Database.add(invoice);
                    pdfInvoice.save(invoice.getPath());

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    Desktop.getDesktop().open(new File(invoice.getPath()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(printBtn);



    setVisible(true);
    }
}
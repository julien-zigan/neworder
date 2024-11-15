package gui;

import core.deployment.Deployment;
import core.invoice.Invoice;
import core.invoice.PDFInvoice;
import core.invoice.PDFInvoiceGenerator;
import core.persistence.Database;
import core.user.User;
import view.ConfirmationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
        hoursPanel.add(hourSetter);
        add(hoursPanel);

        JPanel ratePanel = new JPanel();
        JLabel rateLabel = new JLabel("Stundensatz in Euro");
        ratePanel.add(rateLabel);
        Float[] r = {30f, 35f, 40f, 45f, 50f, 55f, 60f, 65f, 70f, 75f, 80f, 85f, 90f, 95f, 100f};
        JComboBox<Float> rateSetter = new JComboBox<>(r);
        rateSetter.setSelectedIndex(4);
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

        JButton refreshBtn = new JButton("Aktualisieren");
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(refreshBtn);

        JButton saveBtn = new JButton("Speichern");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(saveBtn);

        JButton printBtn = new JButton("Drucken");
        add(printBtn);



    setVisible(true);
    }
}
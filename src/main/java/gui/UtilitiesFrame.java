package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static gui.Layouter.setExternalLayout;

public class UtilitiesFrame extends JInternalFrame {
    public UtilitiesFrame(GridBagLayout gridbag) {
        super("Utilities");
        setFrameIcon(null);
        setExternalLayout(this, gridbag, 0, 0, 1, 3);

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
        //add(fileChooser);
        setVisible(true);
    }
}
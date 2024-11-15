package gui;

import javax.swing.*;
import java.awt.*;

public class ControlFrame extends JInternalFrame {
    public ControlFrame(GridBagLayout gridbag) {
        super("Controls");
        setFrameIcon(null);
        Layouter.setExternalLayout(this, gridbag, 2, 1, 1, 1);
        setVisible(true);
    }
}
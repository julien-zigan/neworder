package gui;

import javax.swing.*;
import java.awt.*;

import static gui.Layouter.setExternalLayout;

public class WorkbenchFrame extends JInternalFrame {
    public WorkbenchFrame(GridBagLayout gridbag) {
        super("My Invoice");
        setFrameIcon(null);
        setExternalLayout(
                this, gridbag, 1, 0, 1, 3, 2., 1.);

        GridBagLayout innerGridbag = new GridBagLayout();
        setLayout(innerGridbag);

        setVisible(true);
    }
}

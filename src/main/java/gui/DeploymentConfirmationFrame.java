package gui;

import javax.swing.*;
import java.awt.*;

public class DeploymentConfirmationFrame extends JInternalFrame {
    public static DeploymentConfirmationFrame instance;

    public DeploymentConfirmationFrame(GridBagLayout gridbag) {
        super("Deployment Confirmation");
        setFrameIcon(null);
        Layouter.setExternalLayout(this, gridbag, 2, 0, 1, 1);

        setVisible(true);

        instance = this;
    }
}
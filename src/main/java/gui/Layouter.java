package gui;

import java.awt.*;

public class Layouter {
    public static void setExternalLayout(
            Container container,
            GridBagLayout gridbag,
            int x,
            int y,
            int w,
            int h) {
        setExternalLayout(container, gridbag, x, y, w, h, 1., 1.);
    }

    public static void setExternalLayout(
            Container container,
            GridBagLayout gridbag,
            int x,
            int y,
            int w,
            int h,
            double wx,
            double wy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2,2, 2);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.fill = GridBagConstraints.BOTH;
        gridbag.setConstraints(container, gbc);
    }
}

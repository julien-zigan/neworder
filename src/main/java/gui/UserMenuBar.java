package gui;

import core.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import static gui.StandardText.NO_USER;

public class UserMenuBar extends JMenuBar {
    public UserMenuBar() {
        JMenu m = new JMenu(NO_USER.getText());
        m.add(new LogoutMenuItem());
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(m);
        add(Box.createHorizontalGlue());
    }

    public UserMenuBar(User user) {
        String userName = String.format("<html><p style='color:green'>%s</p></html>", user.getFirstName());
        JMenu m = new JMenu(userName);
        m.add(new LogoutMenuItem());
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(m);
        add(Box.createHorizontalGlue());
    }

    private static class LogoutMenuItem extends JMenuItem {
        private LogoutMenuItem() {
            super(new Action() {

                @Override
                public void actionPerformed(ActionEvent e) {

                }

                @Override
                public Object getValue(String key) {
                    return null;
                }

                @Override
                public void putValue(String key, Object value) {}

                @Override
                public void setEnabled(boolean b) {}

                @Override
                public boolean isEnabled() {
                    return false;
                }

                @Override
                public void addPropertyChangeListener(PropertyChangeListener listener) {}

                @Override
                public void removePropertyChangeListener(PropertyChangeListener listener) {}

            });
            setEnabled(true);
            setText("logout");
        }
    }
}

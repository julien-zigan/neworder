package gui;

import core.persistence.Database;
import core.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Application {

    private JFrame frmJerp;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application window = new Application();
                    window.frmJerp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Application() {
        User user;
        try {
            user = Database.loadUserData();
        } catch (Exception e) {
            System.err.println(e);
            user = new User();
            user.setAdditional("XXX");
        }

        if (Objects.equals(user.getAdditional(), "XXX")) {
            initialize();
            UserMenuBar userMenuBar = new UserMenuBar();
            frmJerp.setJMenuBar((JMenuBar) userMenuBar);
        } else {
            initialize(user);
            UserMenuBar userMenuBar = new UserMenuBar(user);
            frmJerp.setJMenuBar((JMenuBar) userMenuBar);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(User user) {
        this.initialize();
    }

    private void initialize() {
        frmJerp = new JFrame();
        frmJerp.setTitle("Jerp");
        frmJerp.setBounds(100, 100, 900, 600);
        frmJerp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJerp.setLocationRelativeTo(null);
        frmJerp.setExtendedState(Frame.MAXIMIZED_BOTH);

        GridBagLayout gridbag = new GridBagLayout();
        frmJerp.setLayout(gridbag);


        UtilitiesFrame utilities = new UtilitiesFrame(gridbag);
        frmJerp.add(utilities);

        WorkbenchFrame workbenchFrame = new WorkbenchFrame(gridbag);
        frmJerp.add(workbenchFrame);

        ControlFrame controlFrame = new ControlFrame(gridbag);
        frmJerp.add(controlFrame);

        DeploymentConfirmationFrame deploymentConfirmationFrame =
                new DeploymentConfirmationFrame(gridbag);
        frmJerp.add(deploymentConfirmationFrame);

        frmJerp.setGlassPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }
}


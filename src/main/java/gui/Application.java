package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
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
//        FlatIntelliJLaf.setup();
//        FlatLightLaf.setup();
         FlatDarkLaf.setup();


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
    public Application() throws Exception {
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
    private void initialize(User user) throws Exception {
        this.initialize();
    }

    private void initialize() throws Exception {
        frmJerp = new JFrame();
        frmJerp.setTitle("Jerp");
        frmJerp.setBounds(100, 100, 900, 600);
        frmJerp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJerp.setLocationRelativeTo(null);
        frmJerp.setExtendedState(Frame.MAXIMIZED_BOTH);

        GridBagLayout gridbag = new GridBagLayout();
        frmJerp.setLayout(gridbag);


        WorkbenchFrame workbenchFrame = new WorkbenchFrame(gridbag);
        frmJerp.add(workbenchFrame);

        ControlFrame controlFrame = new ControlFrame(gridbag);
        frmJerp.add(controlFrame);

        DeploymentConfirmationFrame deploymentConfirmationFrame =
                new DeploymentConfirmationFrame(gridbag);
        frmJerp.add(deploymentConfirmationFrame);


        UtilitiesFrame utilities = new UtilitiesFrame(gridbag);
        frmJerp.add(utilities);


        frmJerp.setGlassPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }
}


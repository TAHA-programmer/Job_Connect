import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {
        setTitle("Welcome");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add window listener to perform cleanup on close
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Controller.getInstance().clearData();
                dispose(); // Close the window
                System.exit(0); // Terminate the application
            }
        });

        // Set GridBagLayout for precise component alignment
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Add padding around components
        gbc.fill = GridBagConstraints.NONE; // Prevent components from stretching
        gbc.anchor = GridBagConstraints.CENTER; // Center-align components

        // Title label
        JLabel pageTitleLabel = new JLabel("Welcome To JobConnect");
        pageTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pageTitleLabel, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        // Set preferred sizes for buttons
        loginButton.setPreferredSize(new Dimension(150, 40));
        signupButton.setPreferredSize(new Dimension(150, 40));

        // Add buttons to the panel
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);

        // Add button panel to frame
        gbc.gridx = 0;
        gbc.gridy = 1; // Place below the title
        add(buttonPanel, gbc);

        // Add actions for buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                dispose();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupFrame();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomeFrame());
    }
}

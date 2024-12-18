import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JFrame {
    private JPanel sideNavPanel;
    private JButton toggleNavButton;
    private boolean isNavOpen = false;

    public ProfileScreen() {
        setTitle("My Profile");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main container panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Top panel for Back to Home and Bar buttons, now using BoxLayout for vertical arrangement
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.add(Box.createRigidArea(new Dimension(5, 20))); // Adds 20px space vertically


        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);

        // Back to Home Button
        JButton backButton = new JButton("Back to Home");
        backButton.setFont(buttonFont);
        backButton.setPreferredSize(new Dimension(350, 50)); 
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainScreen();
                dispose();
            }
        });
        topPanel.add(backButton);
        
        topPanel.add(Box.createRigidArea(new Dimension(5, 20))); // Adds 20px space vertically


        // Bar Button
        toggleNavButton = new JButton("Bar");
        toggleNavButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        toggleNavButton.setBackground(Color.LIGHT_GRAY);
        toggleNavButton.setPreferredSize(new Dimension(350, 50)); // Set width = 200px, height = 50px
        toggleNavButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleNavBar();
            }
        });
        topPanel.add(toggleNavButton);
       
        // Title Panel for "My Profile" (Centered)
        JPanel titlePanel = new JPanel(new GridBagLayout()); // Center title
        JLabel titleLabel = new JLabel("My Profile", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.CENTER);

        // Side Navigation Panel (Initially hidden)
        sideNavPanel = new JPanel();
        sideNavPanel.setLayout(new BoxLayout(sideNavPanel, BoxLayout.Y_AXIS));
        sideNavPanel.setBackground(Color.LIGHT_GRAY);
        sideNavPanel.setPreferredSize(new Dimension(200, 600)); // Fixed width
        sideNavPanel.setVisible(false);
        mainPanel.add(sideNavPanel, BorderLayout.WEST);

        // Posted Jobs Button
        JButton postedJobsButton = new JButton("Posted Jobs");
        postedJobsButton.setFont(buttonFont);
        postedJobsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        postedJobsButton.setMaximumSize(new Dimension(180, 40));
        postedJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().showPostedJobsScreen();
                dispose();
            }
        });

        // Posted Forms Button
        JButton postedFormsButton = new JButton("Posted Forms");
        postedFormsButton.setFont(buttonFont);
        postedFormsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        postedFormsButton.setMaximumSize(new Dimension(180, 40));
        postedFormsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().showPostedFormsScreen();
                dispose();
            }
        });

        // Add buttons to side navigation panel
        sideNavPanel.add(Box.createVerticalGlue());
        sideNavPanel.add(postedJobsButton);
        sideNavPanel.add(Box.createVerticalStrut(15)); // Vertical gap
        sideNavPanel.add(postedFormsButton);
        sideNavPanel.add(Box.createVerticalGlue());

        setVisible(true);
    }

    // Method to toggle the visibility of the navigation panel
    private void toggleNavBar() {
        isNavOpen = !isNavOpen;
        sideNavPanel.setVisible(isNavOpen);
    }

    public static void main(String[] args) {
        new ProfileScreen();
    }
}

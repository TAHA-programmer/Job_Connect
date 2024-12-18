import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyProfileScreen extends JFrame {
    private JPanel sideNavPanel;
    private JButton toggleNavButton;
    private boolean isNavOpen = false;

    public CompanyProfileScreen() {
        setTitle("Company Profile");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use absolute positioning

        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);

        // Back to Home Button (Top Left)
        JButton backButton = new JButton("Back to Home");
        backButton.setFont(buttonFont);
        backButton.setBounds(10, 10, 150, 40); // Position as per your requirement
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CompanyHomeScreen();
                dispose();
            }
        });
        add(backButton);

        // Bar Button (Below Back to Home Button)
        toggleNavButton = new JButton("Bar");
        toggleNavButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        toggleNavButton.setBackground(Color.LIGHT_GRAY);
        toggleNavButton.setBounds(10, 60, 150, 40); // Positioned below the backButton
        toggleNavButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleNavBar();
            }
        });
        add(toggleNavButton);

        // Title Label (Centered on the Screen)
        JLabel titleLabel = new JLabel("Company Profile", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setBounds(200, 200, 400, 50);
        add(titleLabel);

        // Side Navigation Panel (Initially hidden)
        sideNavPanel = new JPanel();
        sideNavPanel.setLayout(new BoxLayout(sideNavPanel, BoxLayout.Y_AXIS));
        sideNavPanel.setBackground(Color.LIGHT_GRAY);
        sideNavPanel.setBounds(0, 0, 200, 600); // Covers left part of the screen
        sideNavPanel.setVisible(false); // Initially hidden

        // Posted Jobs Button
        JButton postedJobsButton = new JButton("Posted Jobs");
        postedJobsButton.setFont(buttonFont);
        postedJobsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        postedJobsButton.setMaximumSize(new Dimension(180, 40));
        postedJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CompanyPostedJobsScreen();
                dispose();
            }
        });

        // Add Posted Jobs button
        sideNavPanel.add(Box.createVerticalGlue());
        sideNavPanel.add(postedJobsButton);  

        sideNavPanel.add(Box.createVerticalGlue());

        add(sideNavPanel);

        setVisible(true);
    }

    // Method to toggle the visibility of the navigation panel
    private void toggleNavBar() {
        isNavOpen = !isNavOpen;
        sideNavPanel.setVisible(isNavOpen);
    }

    public static void main(String[] args) {
        new CompanyProfileScreen();
    }
}

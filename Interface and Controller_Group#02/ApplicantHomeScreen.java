import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantHomeScreen extends JFrame {
    private JPanel sideNavPanel;
    private JButton toggleNavButton;
    private boolean isNavOpen = false;

    public ApplicantHomeScreen() {
        setTitle("Applicant Home Screen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use absolute positioning

        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);

        // Bar Button (Top Left)
        toggleNavButton = new JButton("Bar");
        toggleNavButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        toggleNavButton.setBackground(Color.LIGHT_GRAY);
        toggleNavButton.setBounds(10, 10, 150, 40);
        toggleNavButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleNavBar();
            }
        });
        add(toggleNavButton);

        // Title Label (Centered on the Screen)
        JLabel titleLabel = new JLabel("Applicant Home Screen", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        titleLabel.setBounds(200, 200, 400, 40);
        add(titleLabel);

        // Side Navigation Panel (Initially hidden)
        sideNavPanel = new JPanel();
        sideNavPanel.setLayout(new BoxLayout(sideNavPanel, BoxLayout.Y_AXIS));
        sideNavPanel.setBackground(Color.LIGHT_GRAY);
        sideNavPanel.setBounds(0, 0, 200, 600); // Covers left part of the screen
        sideNavPanel.setVisible(false); // Initially hidden

        // My Profile Button in the Navigation Panel
        JButton profileButton = new JButton("My Profile");
        profileButton.setFont(buttonFont);
        profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        profileButton.setMaximumSize(new Dimension(180, 40));
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ApplicantProfileScreen();
                dispose();
            }
        });

        sideNavPanel.add(Box.createVerticalGlue());
        sideNavPanel.add(profileButton);
        sideNavPanel.add(Box.createVerticalGlue());

        add(sideNavPanel);

        // Job Forms Button (Top Right)
        JButton JobFormsButton = new JButton("Job Forms");
        JobFormsButton.setFont(buttonFont);
        JobFormsButton.setBounds(570, 10, 180, 40); // Positioned at top right
        JobFormsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = Controller.getInstance(); // Create or get the singleton instance
                new ApplicantJobForms(controller);
                dispose();
            }
        });
        add(JobFormsButton);

        setVisible(true);
    }

    // Method to toggle the visibility of the navigation panel
    private void toggleNavBar() {
        isNavOpen = !isNavOpen;
        sideNavPanel.setVisible(isNavOpen);
    }

    public static void main(String[] args) {
        new ApplicantHomeScreen();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JPanel sideNavPanel;
    private JButton toggleNavButton;
    private boolean isNavOpen = false;

    public MainScreen() {
        setTitle("Home Screen");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use BorderLayout for the frame
        setLayout(new BorderLayout());

        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);

        // Create a top panel for the navigation bar and buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(600, 100));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Top, left, bottom, right padding
        add(topPanel, BorderLayout.NORTH);

        // Bar Button (Top Left)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // No horizontal gap
        leftPanel.setPreferredSize(new Dimension(200, 80));

        // Create and configure the Bar button
        toggleNavButton = new JButton("Bar");
        toggleNavButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        toggleNavButton.setPreferredSize(new Dimension(150, 40)); // Set a preferred width and height
        toggleNavButton.setBackground(Color.LIGHT_GRAY);
        toggleNavButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleNavBar();
            }
        });

        // Add the Bar button to the left panel
        leftPanel.add(toggleNavButton);

        // Add leftPanel to topPanel
        topPanel.add(leftPanel, BorderLayout.WEST);

        // Create a panel for right-side buttons
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 2 rows, 1 column, 10px gaps
        rightPanel.setPreferredSize(new Dimension(200, 100));

        JButton postJobsButton = new JButton("Post Jobs");
        postJobsButton.setFont(buttonFont);
        postJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = Controller.getInstance(); // Create or get the singleton instance
                new PostJobFrame(controller);
                dispose();
            }
        });
        rightPanel.add(postJobsButton);

        JButton jobFormsButton = new JButton("Job Forms");
        jobFormsButton.setFont(buttonFont);
        jobFormsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = Controller.getInstance(); // Create or get the singleton instance
                new JobForm(controller);
                dispose();
            }
        });
        rightPanel.add(jobFormsButton);

        topPanel.add(rightPanel, BorderLayout.EAST);

        // Center panel for the title
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        JLabel titleLabel = new JLabel("Home Screen", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        centerPanel.add(titleLabel);
        
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.add(centerPanel, BorderLayout.CENTER); // Add the title panel to the center wrapper
        add(centerWrapper, BorderLayout.CENTER); // Add wrapper to center region

        // Side Navigation Panel
        sideNavPanel = new JPanel();
        sideNavPanel.setLayout(new BoxLayout(sideNavPanel, BoxLayout.Y_AXIS));
        sideNavPanel.setBackground(Color.LIGHT_GRAY);
        sideNavPanel.setPreferredSize(new Dimension(200, 600));
        sideNavPanel.setVisible(false); // Initially hidden

        // My Profile Button in the Navigation Panel
        JButton profileButton = new JButton("My Profile");
        profileButton.setFont(buttonFont);
        profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        profileButton.setMaximumSize(new Dimension(180, 40));
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileScreen();
                dispose();
            }
        });

        sideNavPanel.add(Box.createVerticalGlue());
        sideNavPanel.add(profileButton);
        sideNavPanel.add(Box.createVerticalGlue());

        add(sideNavPanel, BorderLayout.WEST); // Add the side navigation to the left

        setVisible(true);
    }

    // Method to toggle the visibility of the navigation panel
    private void toggleNavBar() {
        isNavOpen = !isNavOpen;
        sideNavPanel.setVisible(isNavOpen);
    }

    public static void main(String[] args) {
        new MainScreen();
    }
}

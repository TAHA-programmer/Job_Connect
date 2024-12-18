import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostedJobsScreen extends JFrame {
    public PostedJobsScreen() {
        setTitle("Posted Jobs");
        setSize(800, 600); // Small screen size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Main layout with BorderLayout
        setLayout(new BorderLayout());

        // Title Label at the Center
        JLabel titleLabel = new JLabel("Posted Jobs", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(titleLabel, BorderLayout.CENTER);

        // Top Panel for Buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Back Button Panel (for left alignment)
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        JButton backButton = new JButton("Back to Profile");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileScreen(); // Return to Profile Screen
                dispose();
            }
        });
        backButtonPanel.add(backButton);
        topPanel.add(backButtonPanel, BorderLayout.WEST);

        // Right Panel for Edit, Shortlisting, and Scheduling Buttons
        JPanel rightButtonsPanel = new JPanel(new GridLayout(3, 1, 10, 15)); // 3 rows, 1 column, spacing between buttons

        // Edit Post Button
        JButton editFormButton = new JButton("Edit Post");
        editFormButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        editFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the post?", "Edit Post", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new EditPostScreen().setVisible(true);
                    dispose();
                }
            }
        });
        rightButtonsPanel.add(editFormButton);

        // Shortlisting Button
        JButton shortlistingFormButton = new JButton("Shortlisting");
        shortlistingFormButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        shortlistingFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to apply shortlisting on the form?", "Shortlisting Applicants", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Applicants have been Shortlisted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        rightButtonsPanel.add(shortlistingFormButton);

        // Scheduling Button
        JButton schedulingInterviewButton = new JButton("Scheduling");
        schedulingInterviewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        schedulingInterviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to Schedule the Interviews?", "Scheduling Interviews", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Schedule has been made successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        rightButtonsPanel.add(schedulingInterviewButton);

        // Wrap the rightButtonsPanel in another panel with padding to the right
        JPanel outerRightPanel = new JPanel(new BorderLayout());
        outerRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 30)); // Add 50px padding on the right side
        outerRightPanel.add(rightButtonsPanel, BorderLayout.CENTER);

        // Add the outer panel to the top panel
        topPanel.add(outerRightPanel, BorderLayout.EAST);

        // Add the top panel to the JFrame
        add(topPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PostedJobsScreen();
    }
}

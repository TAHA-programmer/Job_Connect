import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyPostedJobsScreen extends JFrame {
    public CompanyPostedJobsScreen() {
        setTitle("Company Posted Jobs");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 16);

        // Back to Profile Button
        JButton backButton = new JButton("Back to Profile");
        backButton.setFont(buttonFont);
        backButton.setBounds(10, 10, 150, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CompanyProfileScreen();  // Return to Profile Screen
                dispose();  // Close Posted Forms Screen
            }
        });
        add(backButton);

        // Edit Job Posts Button (Top Right)
        JButton editFormButton = new JButton("Edit Post");
        editFormButton.setFont(buttonFont);
        editFormButton.setBounds(627, 10, 150, 40);  // Positioned at the top right corner
        editFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show confirmation dialog for editing the form
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the post?", "Edit Post", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new EditCompanyPostJobs().setVisible(true);  // Open Edit Form Screen
                    dispose();  // Close Posted Forms Screen
                }
                // If No is selected, stay on the current screen (do nothing)
            }
        });
        add(editFormButton);

        // Shortlisting Form Button (Below Edit Form Button)
        JButton shortlistingFormButton = new JButton("Shortlisting");
        shortlistingFormButton.setFont(buttonFont);
        shortlistingFormButton.setBounds(627, 60, 150, 40); // Positioned below the Edit Form Button
        shortlistingFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show confirmation dialog
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to apply shortlisting on the form?", "Shortlisting Applicants", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Applicants have been Shortlisted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // You can add the code to actually shortlist the form here if needed
                }
            }
        });
        add(shortlistingFormButton);

        // Scheduling Form Button (Below Shortlisting Form Button)
        JButton schedulingInterviewButton = new JButton("Scheduling");
        schedulingInterviewButton.setFont(buttonFont);
        schedulingInterviewButton.setBounds(627, 110, 150, 40); // Positioned below the Shortlisting Form Button (y=110)
        schedulingInterviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show confirmation dialog
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to Schedule the Interviews?", "Scheduling Interviews", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Schedule has been made successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // You can add the code to actually schedule the interview here if needed
                }
            }
        });
        add(schedulingInterviewButton);

        // Posted Jobs Title
        JLabel titleLabel = new JLabel("Posted Jobs", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setBounds(200, 200, 400, 50);
        add(titleLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CompanyPostedJobsScreen();
    }
}

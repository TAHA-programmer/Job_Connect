import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantPostedFormsScreen extends JFrame {
    public ApplicantPostedFormsScreen() {
        setTitle("Applicant Posted Forms");
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
                new ApplicantProfileScreen();  // Return to Profile Screen
                dispose();  // Close Posted Forms Screen
            }
        });
        add(backButton);

        // Edit Form Button (Top Right)
        JButton editFormButton = new JButton("Edit Form");
        editFormButton.setFont(buttonFont);
        editFormButton.setBounds(627, 10, 150, 40);  // Positioned at the top right corner
        editFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show confirmation dialog for editing the form
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the form?", "Edit Form", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new EditApplicantFormScreen().setVisible(true);  // Open Edit Form Screen
                    dispose();  // Close Posted Forms Screen
                }
                // If No is selected, stay on the current screen (do nothing)
            }
        });
        add(editFormButton);

        // Delete Form Button (Below Edit Form Button)
        JButton deleteFormButton = new JButton("Delete Form");
        deleteFormButton.setFont(buttonFont);
        deleteFormButton.setBounds(627, 60, 150, 40); // Positioned below the Edit Form Button
        deleteFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show confirmation dialog
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the form?", "Delete Form", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Form has been deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // You can add the code to actually delete the form here if needed
                }
            }
        });
        add(deleteFormButton);

        // Posted Forms Title
        JLabel titleLabel = new JLabel("Posted Forms", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setBounds(200, 200, 400, 50);
        add(titleLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ApplicantPostedFormsScreen();
    }
}

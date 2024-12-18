import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostedFormsScreen extends JFrame {
    public PostedFormsScreen() {
        setTitle("Posted Forms");
        setSize(800, 600); // Small screen size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create a main panel with BorderLayout
        setLayout(new BorderLayout());

        // Title at the center
        JLabel titleLabel = new JLabel("Posted Forms", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(titleLabel, BorderLayout.CENTER);

        // Top Panel for buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for top panel

        // Back Button Panel (for alignment customization)
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5)); // Align to left with small vertical gap
        JButton backButton = new JButton("Back to Profile");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileScreen();
                dispose();
            }
        });
        backButtonPanel.add(backButton);

        // Add back button panel to top panel (left side)
        topPanel.add(backButtonPanel, BorderLayout.WEST);

        // Right Panel for Edit and Delete buttons (Vertical Stack)
        JPanel rightButtonsPanel = new JPanel(new GridLayout(2, 1, 10, 15)); // 2 rows, 1 column, with spacing
        JButton editFormButton = new JButton("Edit Form");
        editFormButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        editFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the form?", "Edit Form", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new EditFormScreen().setVisible(true);
                    dispose();
                }
            }
        });

        JButton deleteFormButton = new JButton("Delete Form");
        deleteFormButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        deleteFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the form?", "Delete Form", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Form has been deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Wrap the rightButtonsPanel in another panel with padding to the right
        JPanel outerRightPanel = new JPanel(new BorderLayout());
        outerRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 30)); // Add 50px padding on the right side
        outerRightPanel.add(rightButtonsPanel, BorderLayout.CENTER);

        // Add the outer panel to the top panel
        topPanel.add(outerRightPanel, BorderLayout.EAST);

        // Add buttons to the right panel
        rightButtonsPanel.add(editFormButton);
        rightButtonsPanel.add(deleteFormButton);

        // Add the outer panel to the top panel
        topPanel.add(outerRightPanel, BorderLayout.EAST);

        // Add the top panel to the JFrame
        add(topPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PostedFormsScreen();
    }
}

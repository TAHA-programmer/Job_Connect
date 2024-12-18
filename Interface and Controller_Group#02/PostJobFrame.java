import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;

public class PostJobFrame extends JFrame {

    private Controller controller; // Reference to the Controller instance

    // Constructor
    public PostJobFrame(Controller controller) {
        this.controller = controller ;// Get the singleton Controller instance

        // Set frame properties
        setTitle("Post an Opportunity");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());

        // Title panel with a vertical BoxLayout for the back button and page title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Top, left, bottom, right padding

        // Back to Home Button
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);
        JButton backButton = new JButton("Back to Home");
        backButton.setFont(buttonFont);
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the left
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainScreen();
                dispose();
            }
        });

        // Page Title Label
        JLabel pageTitleLabel = new JLabel("Post an Opportunity");
        pageTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pageTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the left

        // Add components to the title panel
        titlePanel.add(backButton);
        titlePanel.add(Box.createVerticalStrut(10)); // Add spacing between the button and title
        titlePanel.add(pageTitleLabel);

        // Add the title panel to the frame
        add(titlePanel, BorderLayout.NORTH);

        // Create a panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add fields to the form
        JLabel titleLabel = new JLabel("Title *:");
        JTextField titleField = new JTextField(25);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(titleLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(titleField, gbc);

        JLabel descriptionLabel = new JLabel("Description *:");
        JTextArea descriptionArea = new JTextArea(5, 25);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(descriptionScroll, gbc);

        JLabel deadlineLabel = new JLabel("Deadline *:");
        JTextField deadlineField = new JTextField("DD-MM-YYYY", 25); // Placeholder text
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(deadlineLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(deadlineField, gbc);

        JLabel additionalInfoLabel = new JLabel("Job Requirements:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(additionalInfoLabel, gbc);

        // Add subfields for requirements
        JLabel experienceLabel = new JLabel("Experience:");
        JTextField experienceField = new JTextField(25);
        gbc.insets = new Insets(5, 30, 5, 10); // Indent subfields
        gbc.gridx = 0;
        gbc.gridy = 8;
        formPanel.add(experienceLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(experienceField, gbc);

        JLabel qualificationLabel = new JLabel("Qualification:");
        JTextField qualificationField = new JTextField(25);
        gbc.gridx = 0;
        gbc.gridy = 9;
        formPanel.add(qualificationLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(qualificationField, gbc);
        gbc.insets = new Insets(10, 10, 10, 10); // Reset insets

        JLabel domainLabel = new JLabel("Job Domain:");
        String[] domains = {
            "Web Development", "Graphic Designer", "App Development",
            "Front-End Development", "Back-End Development", "UI/UX Designer"
        };
        JComboBox<String> domainComboBox = new JComboBox<>(domains);
        gbc.gridx = 0;
        gbc.gridy = 10;
        formPanel.add(domainLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(domainComboBox, gbc);

        // Add the form panel to the frame
        add(formPanel, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionArea.getText();
                String deadline = deadlineField.getText();
                String experience = experienceField.getText();
                String qualification = qualificationField.getText();
                String domain = (String) domainComboBox.getSelectedItem();

                if (title.isEmpty() || description.isEmpty() || deadline.isEmpty() || !isValidDate(deadline)) {
                    JOptionPane.showMessageDialog(
                            PostJobFrame.this,
                            "Please fill in all required fields or enter a valid date.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    // Use Controller to handle job posting
                    String response = controller.postJob(title, description, deadline, experience, qualification, domain);
                    JOptionPane.showMessageDialog(
                            PostJobFrame.this,
                            response,
                            "Result",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleField.setText("");
                descriptionArea.setText("");
                deadlineField.setText("DD-MM-YYYY");
                experienceField.setText("");
                qualificationField.setText("");
                domainComboBox.setSelectedIndex(0);
            }
        });

        // Add FocusListener to handle placeholder disappearance
        deadlineField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (deadlineField.getText().equals("DD-MM-YYYY")) {
                    deadlineField.setText(""); // Clear placeholder on focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (deadlineField.getText().trim().isEmpty()) {
                    deadlineField.setText("DD-MM-YYYY"); // Restore placeholder if no date entered
                }
            }
        });

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set frame visibility
        setVisible(true);
    }

    // Simple date validation method
    private boolean isValidDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controller controller = Controller.getInstance(); // Create or get the singleton instance
            new PostJobFrame(controller);                    // Pass the controller instance to the frame
        });
    }
    
}
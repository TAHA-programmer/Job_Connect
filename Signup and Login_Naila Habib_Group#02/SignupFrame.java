import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.lang.ModuleLayer.Controller;

public class SignupFrame extends JFrame {
    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JComboBox<String> roleComboBox; // Role dropdown

    public SignupFrame() {
        setTitle("Sign Up");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0; add(usernameLabel, gbc);
        gbc.gridx = 1; add(usernameField, gbc);

        // First Name field
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(25);
        gbc.gridx = 0; gbc.gridy = 1; add(firstNameLabel, gbc);
        gbc.gridx = 1; add(firstNameField, gbc);

        // Last Name field
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(25);
        gbc.gridx = 0; gbc.gridy = 2; add(lastNameLabel, gbc);
        gbc.gridx = 1; add(lastNameField, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(25);
        gbc.gridx = 0; gbc.gridy = 3; add(emailLabel, gbc);
        gbc.gridx = 1; add(emailField, gbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(25);
        gbc.gridx = 0; gbc.gridy = 4; add(passwordLabel, gbc);
        gbc.gridx = 1; add(passwordField, gbc);

        // Confirm Password field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(25);
        gbc.gridx = 0; gbc.gridy = 5; add(confirmPasswordLabel, gbc);
        gbc.gridx = 1; add(confirmPasswordField, gbc);

         // Role selection dropdown
         JLabel roleLabel = new JLabel("Role:");
         roleComboBox = new JComboBox<>(new String[]{"admin", "company", "applicant"});
         gbc.gridx = 0; gbc.gridy = 6; add(roleLabel, gbc);
         gbc.gridx = 1; add(roleComboBox, gbc);

        // Signup button
        JButton signupButton = new JButton("Sign Up");
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE; // Button takes its default size
        add(signupButton, gbc);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignup();
            }
        });
        setVisible(true);
    }

   private void handleSignup() {
    String username = usernameField.getText();
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String email = emailField.getText();
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmPasswordField.getPassword());
    String role = (String) roleComboBox.getSelectedItem(); // Get selected role


    if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!email.matches("^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Controller controller = Controller.getInstance();
    String message = controller.registerUser(username, firstName, lastName, email, password,role);
    JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);

    if (message.equals("Signup successful!")) {
        new LoginFrame();
        dispose();
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignupFrame());
    }
}
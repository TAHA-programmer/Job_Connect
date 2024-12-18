import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class ApplicantJobForms extends JFrame {

    private Controller controller;
    // Constructor
    public ApplicantJobForms(Controller controller) {
        this.controller = controller;
        setTitle("Job Application Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Set Times New Roman font
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Font font = new Font("Times New Roman", Font.PLAIN, 14); // Times New Roman font
            UIManager.put("Label.font", font);
            UIManager.put("TextField.font", font);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
               new ApplicantHomeScreen();
               dispose();
           }
       });

       // Page Title Label
       JLabel pageTitleLabel = new JLabel("Job Application Form for Applicant");
       pageTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
       pageTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the left

       // Add components to the title panel
       titlePanel.add(backButton);
       titlePanel.add(Box.createVerticalStrut(10)); // Add spacing between the button and title
       titlePanel.add(pageTitleLabel);

       // Add the title panel to the frame
       add(titlePanel, BorderLayout.NORTH);


        // Create a panel to hold the form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Personal Information Fields
        formPanel.add(new JLabel("Name:"), gbc);
        JTextField nameField = createTextField("Enter Name (Ibrahim)", 20, 25); // Shorter text field with max characters
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);
        JTextField emailField = createTextField("Enter Email (taha123@gmail.com)", 20, Integer.MAX_VALUE); // No max length here
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Gender:"), gbc);
        String[] genderOptions = { "Male", "Female" };
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions); // Gender dropdown
        genderComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(genderComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Contact Number:"), gbc);
        JTextField contactField = createTextField("Enter Contact Number (03335965010)", 20, 11); // Contact number, max 11 digits
        gbc.gridx = 1;
        formPanel.add(contactField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Country:"), gbc);

       // List of all countries (this can be extended with a complete list of countries)
        String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Congo (Congo-Kinshasa)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City (Holy See)", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};

        // Sort countries alphabetically
        Arrays.sort(countries);

        // Country dropdown
        JComboBox<String> countryComboBox = new JComboBox<>(countries);
        countryComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(countryComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("City:"), gbc);
        JTextField cityField = createTextField("Enter City (Islamabad)", 20, Integer.MAX_VALUE);
        gbc.gridx = 1;
        formPanel.add(cityField, gbc);

        // Academic Information Fields
        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("College Name:"), gbc);
        JTextField collegeField = createTextField("Enter College Name (Sir Syed)", 20, Integer.MAX_VALUE);
        gbc.gridx = 1;
        formPanel.add(collegeField, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        formPanel.add(new JLabel("College Grade:"), gbc);
        String[] grades = { "A", "A-", "B", "C", "D", "F" };
        JComboBox<String> collegeGradeComboBox = new JComboBox<>(grades); // College Grade dropdown
        collegeGradeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(collegeGradeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        formPanel.add(new JLabel("Highest Qualification:"), gbc);
        JTextField qualificationField = createTextField("Enter Highest Qualification (BS CS)", 20, Integer.MAX_VALUE);
        gbc.gridx = 1;
        formPanel.add(qualificationField, gbc);

        gbc.gridx = 0; gbc.gridy = 9;
        formPanel.add(new JLabel("Highest Qualification Grade:"), gbc);
        JComboBox<String> qualificationGradeComboBox = new JComboBox<>(grades); // Qualification Grade dropdown
        qualificationGradeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(qualificationGradeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 10;
        formPanel.add(new JLabel("Current Year:"), gbc);
        JTextField currentYearField = createTextField("Enter Current Year (2)", 20, Integer.MAX_VALUE);
        gbc.gridx = 1;
        formPanel.add(currentYearField, gbc);

        gbc.gridx = 0; gbc.gridy = 11;
        formPanel.add(new JLabel("Domain:"), gbc);
        String[] domains = { "Software Development", "Data Science", "Web Development", "Mobile App Development" };
        JComboBox<String> domainComboBox = new JComboBox<>(domains); // Domain dropdown
        domainComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(domainComboBox, gbc);

        // Add Submit Button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        submitButton.setPreferredSize(new Dimension(80, 30)); // Increased button size

        // Add Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        clearButton.setPreferredSize(new Dimension(80, 30)); // Clear button size
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Feedback Label
        JLabel feedbackLabel = new JLabel("");
        feedbackLabel.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 12; gbc.gridwidth = 2; // Feedback label spans both columns
        formPanel.add(feedbackLabel, gbc);

        // Add panels to frame
        add(titlePanel, BorderLayout.NORTH); // Title at top-left corner
        add(formPanel, BorderLayout.CENTER); // Form fields in the center
        add(buttonPanel, BorderLayout.SOUTH); // Submit button centered at the bottom

        // Submit Button Action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the fields
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String contact = contactField.getText().trim();
                String city = cityField.getText().trim();
                String collegeName = collegeField.getText().trim();
                String qualification = qualificationField.getText().trim();
                String currentYear = currentYearField.getText().trim();
        
                // Validate required fields (check if any field is empty)
                if (name.isEmpty() || name.equals("Enter Name (Ibrahim)")) {
                    feedbackLabel.setText("Please enter a valid name.");
                }
                else if (email.isEmpty() || email.equals("Enter Email (taha123@gmail.com)")) {
                    feedbackLabel.setText("Please enter a valid email.");
                }
                else if (contact.isEmpty() || contact.equals("Enter Contact Number (03335965010)")) {
                    feedbackLabel.setText("Please enter a valid contact number.");
                }
                else if (city.isEmpty() || city.equals("Enter City (Islamabad)")) {
                    feedbackLabel.setText("Please enter a valid city.");
                }
                else if (collegeName.isEmpty() || collegeName.equals("Enter College Name (Sir Syed)")) {
                    feedbackLabel.setText("Please enter a valid college name.");
                }
                else if (qualification.isEmpty() || qualification.equals("Enter Highest Qualification (BS CS)")) {
                    feedbackLabel.setText("Please enter a valid qualification.");
                }
                else if (currentYear.isEmpty() || currentYear.equals("Enter Current Year (2)")) {
                    feedbackLabel.setText("Please enter a valid current year.");
                }
        
                // Validate Name length and only characters
                else if (name.length() < 5 || name.length() > 25) {
                    JOptionPane.showMessageDialog(null, "Name must be between 5 and 25 characters.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!name.matches("[a-zA-Z]+")) { // Only letters (no spaces or special characters)
                    JOptionPane.showMessageDialog(null, "Name must contain only letters.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Validate Email format
                else if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Validate Contact number (only numeric and 11 digits)
                else if (!contact.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Contact number must be exactly 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Validate Current Year as numeric
                else if (!currentYear.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Current year must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String jobId = "JOB-1"; // You can dynamically get this jobId based on your job posting logic
                    String gender = (String) genderComboBox.getSelectedItem();
                    String country = (String) countryComboBox.getSelectedItem();
                    String domain = (String) domainComboBox.getSelectedItem();
        
                    // Call the Controller's submitJobApplication method
                    String result = controller.submitJobApplication(jobId, name, email, gender, contact, country, city, collegeName, 
                                                                    collegeGradeComboBox.getSelectedItem().toString(), qualification, 
                                                                    qualificationGradeComboBox.getSelectedItem().toString(), currentYear, domain);

                            
                         // If all validations pass, proceed with form submission or other logic
                         if (result.equals("Form submitted successfully!")) {
                            JOptionPane.showMessageDialog(null, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, result, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
        });

        // Clear Button Action
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("Enter Name (Ibrahim)");
                nameField.setForeground(Color.GRAY);
                
                emailField.setText("Enter Email (taha123@gmail.com)");
                emailField.setForeground(Color.GRAY);
                
                contactField.setText("Enter Contact Number (03335965010)");
                contactField.setForeground(Color.GRAY);
                
                cityField.setText("Enter City (Islamabad)");
                cityField.setForeground(Color.GRAY);
                
                collegeField.setText("Enter College Name (Sir Syed)");
                collegeField.setForeground(Color.GRAY);
                
                qualificationField.setText("Enter Highest Qualification (BS CS)");
                qualificationField.setForeground(Color.GRAY);
                
                currentYearField.setText("Enter Current Year (2)");
                currentYearField.setForeground(Color.GRAY);
                
                feedbackLabel.setText("");  // Clear any previous feedback message
            }
        });
        
        // Set frame visibility
        setVisible(true);
    }

    // Create a JTextField with hidden text and size constraints
    private JTextField createTextField(String placeholder, int columns, int maxLength) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        // Limit character input length
        if (maxLength != Integer.MAX_VALUE) {
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (textField.getText().length() >= maxLength) {
                        e.consume();
                    }
                }
            });
        }

        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controller controller = Controller.getInstance(); // Create or get the singleton instance
            new ApplicantJobForms(controller);                    // Pass the controller instance to the frame
        });
    }
}

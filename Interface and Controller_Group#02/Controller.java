import java.util.HashMap;
import java.util.Map;

public class Controller {
    private String message;
    private Map<String, User> userDatabase = new HashMap<>();
    private Map<String, JobPost> jobDatabase = new HashMap<>(); // Stores job posts
    private Map<String, JobApplication> jobApplicationDatabase = new HashMap<>(); // Stores job applications
    private static Controller instance;

    private Controller() {
        // Adding default users for different roles
        userDatabase.put("admin", new User("admin", "Admin", "User", "admin@example.com", "admin123", "admin"));
        userDatabase.put("company", new User("company", "Company", "User", "company@example.com", "company123", "company"));
        userDatabase.put("applicant", new User("applicant", "Applicant", "User", "applicant@example.com", "applicant123", "applicant"));
        
        // Add a shutdown hook to clear data on program exit
        Runtime.getRuntime().addShutdownHook(new Thread(this::clearData));
    }

    // Singleton instance
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // Register user with individual fields
    public String registerUser(String username, String firstName, String lastName, String email, String password, String role) {
        if (userDatabase.containsKey(username)) {
            return "Username already exists.";
        }
        User newUser = new User(username, firstName, lastName, email, password, role);
        userDatabase.put(username, newUser);
        return "Signup successful!";
    }
    
    // Modify the authenticateUser method
    public String authenticateUser(String username, String password) {
        if (userDatabase.isEmpty()) {
            return "No users registered. Please sign up first.";
        }

        if (userDatabase.containsKey(username)) {
            User user = userDatabase.get(username);
            if (user.getPassword().equals(password)) {
                return "Login successful!";
            }
        }
        return "Invalid credentials.";
    }

    public String getUserRole(String username) {
        User user = userDatabase.get(username);
        return user != null ? user.getRole() : null;  // Get the role of the user
    }

    public void clearData() {
        userDatabase.clear();
        jobDatabase.clear();
        jobApplicationDatabase.clear();
        instance = null; // Reset the singleton instance
        System.out.println("All data has been cleared.");
    }

    // Submit a job post
    public String postJob(String title, String description, String deadline, String experience, String qualification, String domain) {
        if (title.isEmpty() || description.isEmpty() || deadline.isEmpty()) {
            return "Please fill in all required fields.";
        }

        // Generate a unique job ID
        String jobId = "JOB-" + (jobDatabase.size() + 1);
        JobPost jobPost = new JobPost(jobId, title, description, deadline, experience, qualification, domain);
        jobDatabase.put(jobId, jobPost);

        return "Job posted successfully! ID: " + jobId;
    }

    // Submit job application
    public String submitJobApplication(String jobId, String name, String email, String gender, String contactNumber, String country, String city, 
                                       String collegeName, String collegeGrade, String qualification, String qualificationGrade, 
                                       String currentYear, String domain) {
        // Validate jobId
        if (!jobDatabase.containsKey(jobId)) {
            return "Invalid job ID.";
        }

        // Create a job application
        JobApplication jobApplication = new JobApplication(jobId, name, email, gender, contactNumber, country, city, 
                                                           collegeName, collegeGrade, qualification, qualificationGrade, 
                                                           currentYear, domain);

        // Store the job application
        jobApplicationDatabase.put(jobId + "_" + email, jobApplication);
        return "Job application submitted successfully!";
    }

    // Debug method to view job applications
    public void printJobApplications() {
        for (JobApplication application : jobApplicationDatabase.values()) {
            System.out.println(application);
        }
    }

    // Show the PostJobFrame
    public void showPostJobFrame() {
        new PostJobFrame(this); // Pass controller instance to PostJobFrame
    }
    
    // Show the PostedFormsScreen
    public void showPostedFormsScreen() {
        new PostedFormsScreen(); // Open the PostedFormsScreen
    }

    // Show the JobForm frame
    public void showJobForm() {
        new JobForm(this); // Pass controller instance to JobForm
    }

     // Show the PostedJobsScreen
     public void showPostedJobsScreen() {
        new PostedJobsScreen(); // Open the PostedJobsScreen
    }

    // Debug method to view job posts
    public void printJobPosts() {
        for (JobPost job : jobDatabase.values()) {
            System.out.println(job);
        }
    }
}
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role; // New attribute for role

    public User(String username, String firstName, String lastName, String email, String password,String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
public class JobApplication {
    private String jobId;
    private String name;
    private String email;
    private String gender;
    private String contactNumber;
    private String country;
    private String city;
    private String collegeName;
    private String collegeGrade;
    private String qualification;
    private String qualificationGrade;
    private String currentYear;
    private String domain;

    // Constructor
    public JobApplication(String jobId, String name, String email, String gender, String contactNumber, String country, 
                          String city, String collegeName, String collegeGrade, String qualification, 
                          String qualificationGrade, String currentYear, String domain) {
        this.jobId = jobId;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.country = country;
        this.city = city;
        this.collegeName = collegeName;
        this.collegeGrade = collegeGrade;
        this.qualification = qualification;
        this.qualificationGrade = qualificationGrade;
        this.currentYear = currentYear;
        this.domain = domain;
    }

    // Getters and Setters (if needed)
    public String getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCollegeGrade() {
        return collegeGrade;
    }

    public String getQualification() {
        return qualification;
    }

    public String getQualificationGrade() {
        return qualificationGrade;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "jobId='" + jobId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", collegeGrade='" + collegeGrade + '\'' +
                ", qualification='" + qualification + '\'' +
                ", qualificationGrade='" + qualificationGrade + '\'' +
                ", currentYear='" + currentYear + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}

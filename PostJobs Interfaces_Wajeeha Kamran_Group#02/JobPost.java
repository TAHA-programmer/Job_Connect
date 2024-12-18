public class JobPost {
    private String jobId;
    private String title;
    private String description;
    private String deadline;
    private String experience;
    private String qualification;
    private String domain;

    // Constructor
    public JobPost(String jobId, String title, String description, String deadline, String experience, String qualification, String domain) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.experience = experience;
        this.qualification = qualification;
        this.domain = domain;
    }

    // Getters and setters (if needed)
    public String getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getExperience() {
        return experience;
    }

    public String getQualification() {
        return qualification;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + "\nTitle: " + title + "\nDescription: " + description +
                "\nDeadline: " + deadline + "\nExperience: " + experience +
                "\nQualification: " + qualification + "\nDomain: " + domain;
    }
}

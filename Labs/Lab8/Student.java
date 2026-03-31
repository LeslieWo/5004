public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;

    public Student(String firstName, String lastName, String studentId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return firstName + " " + lastName + " " + studentId + " " + email;
    }
}
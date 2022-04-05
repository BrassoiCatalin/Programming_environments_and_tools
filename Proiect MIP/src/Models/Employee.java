package Models;

public class Employee {

    private String name;
    private String fatherName;
    private String age;
    private String DOB;
    private String address;
    private String phone;
    private String email;
    private String education;
    private String post;

    public Employee() {
    }

    public Employee(String name, String fatherName, String age, String DOB, String address, String phone, String email, String education, String post) {
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAge() {
        return age;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getEducation() {
        return education;
    }

    public String getPost() {
        return post;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPost(String post) {
        this.post = post;
    }
}

package studentInfo;

class Student {
    String firstName;
    String lastName;
    String USN;
    String category;
    String address;
    int age;
    double cgpa;

    Student(String firstName, String lastName, String USN, String category, String address, int age, double cgpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.USN = USN;
        this.category = category;
        this.address = address;
        this.age = age;
        this.cgpa = cgpa;
    }

    public String toString() {
        StringBuilder studentString = new StringBuilder();
        studentString.append("Name: ").append(this.firstName).append(" ").append(this.lastName).append("\n");
        studentString.append("USN: ").append(this.USN).append("\n");
        studentString.append("Age: ").append(this.age).append("\n");
        studentString.append("Category: ").append(this.category).append("\n");
        studentString.append("Address: ").append(this.address).append("\n");
        studentString.append("CGPA: ").append(this.cgpa).append("\n");
        return studentString.toString();
    }
}
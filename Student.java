
package lab;

public class Student {
    String studentID;
    String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
    }
}


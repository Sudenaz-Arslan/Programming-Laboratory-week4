
package lab;

import java.util.ArrayList;

public class Course {

    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        enrolledStudents = new ArrayList<>();
    }

    public void printCourseInfo() {

        System.out.println("Course: " + courseName);
        System.out.println("Capacity: " + capacity);

        System.out.println("Enrolled Students:");

        for (Student s : enrolledStudents) {
            s.printInfo();
        }
    }
}

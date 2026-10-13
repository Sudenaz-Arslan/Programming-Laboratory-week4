
package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        int courseCount;

        do {
            System.out.print("How many courses? (min 3): ");
            courseCount = keyboard.nextInt();
        } while (courseCount < 3);

        keyboard.nextLine();

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Course name: ");
            String name = keyboard.nextLine();
            System.out.print("Classroom capacity: ");
            int capacity = keyboard.nextInt();
            keyboard.nextLine();

            Course c = new Course(name, capacity);
            courses.add(c);
        }

        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.println("Course: " + c.courseName
                    + " | Capacity: " + c.capacity);
        }

        int choice;
        do {
            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1 - Register Student");
            System.out.println("2 - List All Courses");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            
            System.out.println("");
            System.out.println("-------------------");
            
            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    String id = keyboard.nextLine();

                    System.out.print("Student name: ");
                    String studentName = keyboard.nextLine();

                    System.out.print("Course name: ");
                    String courseName = keyboard.nextLine();

                    Course selectedCourse = null;
                    for (Course c : courses) {
                        if (c.courseName.equals(courseName)) {
                            selectedCourse = c;
                            break;
                        }
                    }
                    if (selectedCourse == null) {
                        System.out.println("No course found with that name.");
                    } else if (selectedCourse.enrolledStudents.size() >= selectedCourse.capacity) {
                        System.out.println("This course is full. Registration failed.");
                    } else {
                        boolean duplicate = false;
                        for (Student s : selectedCourse.enrolledStudents) {
                            if (s.studentID.equals(id)) {
                                duplicate = true;
                                break;
                            }
                        }
                        if (duplicate) {
                            System.out.println("This student is already registered for this course.");
                        } else {
                            Student student = new Student(id, studentName);
                            selectedCourse.enrolledStudents.add(student);
                            System.out.println("Registration successful.");
                        }
                    }
                    break;
                    
                case 2:
                    for (Course c : courses) {
                        c.printCourseInfo();
                        System.out.println("--------------------");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        keyboard.close();
    }
}



package com.mycompany.studentgradesystemcli1;

import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    double average;
    char grade;

    Student(String name, int numSubjects) {
        this.name = name;
        this.marks = new int[numSubjects];
    }

    void calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        this.average = (double) sum / marks.length;
    }

    void assignGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }
}

public class StudentGradeSystemCLI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        int s = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of Student " + (i + 1) + ": ");
            sc.nextLine(); // Consume newline
            String name = sc.nextLine();

            students[i] = new Student(name, s);

            for (int j = 0; j < s; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                students[i].marks[j] = sc.nextInt();
            }

            students[i].calculateAverage();
            students[i].assignGrade();
        }

        System.out.println("\n--- Students Report ---");
        for (Student student : students) {
            student.displayInfo();
        }
        sc.close();
    }
}

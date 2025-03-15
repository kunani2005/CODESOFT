package mypackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Student {
	String name;
	int rollNumber;
	String grade;
	public Student(String name,int parts,String grade) {
		this.name = name;
		this.rollNumber = parts;
		this.grade = grade;
	}
	public Student(String name2, String string, String grade2) {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Name: " + name + " , Roll Number: " + rollNumber + ", Grade: " + grade ;
	}
	public String toFileString() {
		return name + "," + rollNumber + "," + grade;
	}
}
class  StudentManagementSystem {
	private List<Student> students;
	private String dataFilePath = "students.txt";
    public StudentManagementSystem (String string) {
    	students = new ArrayList<>();
    	loadStudentsFromFile();
    }
    public void addStudent(Student student) {
    	students.add(student);
    	saveStudentsToFile();
    }
    private void saveStudentsToFile() {
		// TODO Auto-generated method stub
		
	}
	public void removeStudent(int removeRollNumber) {
    	students.removeIf(student -> student.rollNumber == removeRollNumber);
    	saveStudentsToFile();
    }
    public Student searchStudent(int searchRollNumber) {
    	for (Student student :students) {
    		if (student.rollNumber == searchRollNumber) {
    			return student;
    		}
    	}
    	return null;
    }
    public void displayAllStudents() {
    	for (Student student : students) {
    		System.out.println(student);
    	}
    }
    private void loadStudentsFromFile() {
    	try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
    		String line;
    		while((line = reader.readLine()) != null) {
    			String[] parts = line.split(",");
    		if (parts.length == 3) {
    			students.add(new Student(parts[0],parts[1],parts[2]));
    		}
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
}
class StudentManagementApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystem("students.txt");
		while (true) {
			System.out.println("\nStudent Management System");
			System.out.println("1. Add Student");
			System.out.println("2. Remove student");
			System.out.println("3. Search student");
			System.out.println("4. Display All Students ");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("enter name:");
				String name = scanner.nextLine();
				System.out.println("Enter roll number:");
				String rollNumber = scanner.nextLine();
				System.out.println("Enter grade:");
				String grade = scanner.nextLine();
				if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
					System.out.println("All fields are required.");
				break;
				}
				sms.addStudent(new Student(name,rollNumber,grade));
				System.out.println("Student added successfully");
				break;
			case 2:
				System.out.println("Enter roll number to remove:");
				int removeRollNumber = scanner.nextInt();
				sms.removeStudent( removeRollNumber);
				System.out.println("Student removed successfully.");
				break;
			case 3:
				System.out.print("Enter roll number to search");
				int  searchRollNumber = scanner.nextInt();
				Student foundStudent = sms.searchStudent(searchRollNumber);
				if (foundStudent != null) {
					System.out.println("student found: " + foundStudent);
				} else {
					System.out.println("Student not found.");
				}
				break;
			case 4:
				System.out.println("All Students:");
				sms.displayAllStudents();
				break;
			case 5:
				System.out.println("exciting......");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	
      
	}

}

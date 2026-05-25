import java.util.*;

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("-------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Enter a new Student Detail");
            System.out.println("2. Remove Student Detail");
            System.out.println("3. Edit Student Detail");
            System.out.println("4. Display every Student Detail");
            System.out.println("5. Find a Student Detail");
            System.out.println("6. Sort Student Detail");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer
            switch (choice) {
                // ADD STUDENT
                case 1:
                    System.out.print("Enter the name of the student: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the age of the student: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    students.add(new Student(name, age));
                    System.out.println("Student Added Successfully!");
                    break;
                // REMOVE STUDENT
                case 2:
                    System.out.print("Enter the name of the Student: ");
                    name = sc.nextLine();
                    boolean found = false;
                    Iterator<Student> it = students.iterator();
                    while (it.hasNext()) {
                        Student s = it.next();
                        if (s.name.equalsIgnoreCase(name)) {
                            it.remove();
                            found = true;
                        }
                    }
                    if (found) {
                        System.out.println("Student Removed!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                // EDIT STUDENT
                case 3:
                    System.out.println("What needs to be changed?");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    int c = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the student name: ");
                    name = sc.nextLine();
                    found = false;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(name)) {
                            switch (c) {
                                case 1:
                                    System.out.print("Enter new name: ");
                                    String newName = sc.nextLine();
                                    s.name = newName;
                                    break;
                                case 2:
                                    System.out.print("Enter new age: ");
                                    int newAge = sc.nextInt();
                                    sc.nextLine();
                                    s.age = newAge;
                                    break;
                                default:
                                    System.out.println("Invalid Option!");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Student Updated!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                // DISPLAY ALL STUDENTS
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No Student Records Found!");
                    } else {
                        System.out.println("\n===== STUDENT DETAILS =====");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;
                // FIND STUDENT
                case 5:
                    System.out.print("Enter student name to search: ");
                    name = sc.nextLine();
                    found = false;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(name)) {
                            System.out.println("Student Found!");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;
                // SORT STUDENTS
                case 6:
                    System.out.println("Sort By:");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    int sortChoice = sc.nextInt();
                    sc.nextLine();
                    switch (sortChoice) {
                        case 1:
                            students.sort((s1, s2) ->
                                    s1.name.compareToIgnoreCase(s2.name));
                            System.out.println("Sorted by Name!");
                            break;
                        case 2:
                            students.sort((s1, s2) ->
                                    Integer.compare(s1.age, s2.age));
                            System.out.println("Sorted by Age!");
                            break;
                        default:
                            System.out.println("Invalid Option!");
                    }
                    break;
                // EXIT
                case 7:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
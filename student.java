import java.util.*;

class student {
    String name;
    int id;
    int age;
    String department;

    public student(String name, int id, int age, String department) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.department = department;
    }

    void display() {
        System.out.print(name + " " + id + " " + age + " " + department);
        System.out.println();
    }
}

class StudentManagementSystem {
    static ArrayList<student> students = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    static void addStudent() {
        System.out.println("Enter your name:");
        String name = s.next();

        System.out.println("Enter id:");
        int id = s.nextInt();
        s.nextLine();

        System.out.println("Enter your age:");
        int age = s.nextInt();
        s.nextLine();

        System.out.println("Enter yor department:");
        String department = s.nextLine();

        students.add(new student(name, id, age, department));
        System.out.println("Student Added Successfully!");

    }

    static void veiwStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found ");
        }
        for (student st : students) {
            st.display();
        }
    }

    static void updateStudents() {
        System.out.println("Enter id to be update:");
        int id = s.nextInt();
        s.nextLine();

        for (student st : students) {
            if (st.id == id) {
                System.out.println("Enter new name:");
                st.name = s.next();

                System.out.println("Enter new age:");
                st.age = s.nextInt();
                s.nextLine();

                System.out.println("Enter new department:");
                st.department = s.nextLine();

                System.out.println("Student details are updated succesfully");
                return;
            }
        }
        System.out.println("student not found");
    }

    static void deleteStudents() {
        System.out.println("Enter id to be deleted:");
        int id = s.nextInt();

        Iterator<student> it = students.iterator();
        while (it.hasNext()) {
            student st = it.next();
            if (st.id == id) {
                it.remove();
                System.out.println("Student Deleted!");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Management System\n");
            System.out.println("1.Add students\n");
            System.out.println("2.view Students\n");
            System.out.println("3.update students\n");
            System.out.println("4.Delete students\n");
            System.out.println("5.Exit\n");

            choice = s.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    veiwStudents();
                    break;
                case 3:
                    updateStudents();
                    break;
                case 4:
                    deleteStudents();
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        } while (choice != 5);
    }
}

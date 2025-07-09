package smartex;

import java.util.*;

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n📘 Welcome to Smartex Student System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Add Remarks");
            System.out.println("4. Calculate Grade");
            System.out.println("5. Compare Names");
            System.out.println("6. Simulate Exception");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        System.out.print("Enter Section: ");
                        char section = sc.next().charAt(0);

                        Student s = new Student(id, name, marks, section);
                        students.add(s);
                        System.out.println("✅ Student added!");
                        break;

                    case 2:
                        for (Student st : students) {
                            st.printDetails();
                            System.out.println("------------------");
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID to add remark: ");
                        int rid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter remark: ");
                        String remark = sc.nextLine();
                        for (Student st : students) {
                            if (st.studentId == rid) {
                                st.addRemark(remark);
                                System.out.println("✅ Remark added.");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter student ID to get grade: ");
                        int gid = sc.nextInt();
                        for (Student st : students) {
                            if (st.studentId == gid) {
                                System.out.println("Grade: " + st.calculateGrade());
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Enter Name 1: ");
                        String n1 = sc.nextLine();
                        System.out.print("Enter Name 2: ");
                        String n2 = sc.nextLine();
                        Student temp = new Student();
                        temp.name = n1;
                        temp.compareNames(n2);
                        break;

                    case 6:
                        System.out.print("Enter number: ");
                        int a = sc.nextInt();
                        System.out.print("Enter divisor: ");
                        int b = sc.nextInt();
                        System.out.println("Result: " + (a / b));
                        break;

                    case 7:
                        running = false;
                        System.out.println("👋 Exiting the system. Goodbye!");
                        break;

                    default:
                        System.out.println("❌ Invalid choice! Try again.");
                }
            } catch (InvalidMarksException e) {
                System.out.println("❌ Invalid Marks: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("❌ Cannot divide by zero!");
            } catch (Exception e) {
                System.out.println("❌ Something went wrong: " + e.getMessage());
            }
        }

        sc.close();
    }
}

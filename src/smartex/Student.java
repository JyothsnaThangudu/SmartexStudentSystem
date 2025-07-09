package smartex;

public class Student extends Record implements PersonInfo {
    protected int studentId;
    protected String name;
    protected double marks;
    protected char section;
    protected boolean isPassed;
    protected StringBuffer remarks;
    protected static int studentCount = 0;

    // Default constructor
    public Student() {
        studentCount++;
        remarks = new StringBuffer();
    }

    // Parameterized constructor
    public Student(int studentId, String name, double marks, char section) throws InvalidMarksException {
        this();
        if (marks < 0 || marks > 100)
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.section = section;
        this.isPassed = marks >= 40;
    }

    // Copy constructor
    public Student(Student s) {
        this.studentId = s.studentId;
        this.name = s.name;
        this.marks = s.marks;
        this.section = s.section;
        this.isPassed = s.isPassed;
        this.remarks = new StringBuffer(s.remarks.toString());
        studentCount++;
    }

    public void printDetails() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Section: " + section);
        System.out.println("Passed: " + isPassed);
        System.out.println("Remarks: " + (remarks.length() == 0 ? "None" : remarks.toString()));
    }

    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else if (marks >= 40) return 'D';
        else return 'F';
    }

    public void addRemark(String remark) {
        remarks.append(remark).append(" ");
    }

    public void compareNames(String name2) {
        System.out.println("Using == : " + (this.name == name2));
        System.out.println("Using equals() : " + this.name.equals(name2));
        System.out.println("Using equalsIgnoreCase() : " + this.name.equalsIgnoreCase(name2));
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public final void finalizeRecord() {
        System.out.println("Record finalized for student: " + name);
    }

    @Override
    public void displayBasicInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name);
    }

    @Override
    public String getType() {
        return "Regular Student";
    }
}

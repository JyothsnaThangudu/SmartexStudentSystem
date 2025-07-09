package smartex;

public class ScholarStudent extends Student {
    private double scholarshipAmount;

    public ScholarStudent(int id, String name, double marks, char section, double scholarshipAmount) throws InvalidMarksException {
        super(id, name, marks, section);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public char calculateGrade() {
        double bonus = 5;
        double effectiveMarks = Math.min(100, this.marks + bonus);

        if (effectiveMarks >= 90) return 'A';
        else if (effectiveMarks >= 75) return 'B';
        else if (effectiveMarks >= 60) return 'C';
        else if (effectiveMarks >= 40) return 'D';
        else return 'F';
    }

    @Override
    public String getType() {
        return "Scholar Student";
    }
}

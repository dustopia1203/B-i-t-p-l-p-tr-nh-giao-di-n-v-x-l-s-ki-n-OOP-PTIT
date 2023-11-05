package B7;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name, dob;
    private float p1, p2, p3, pS;
    private String comparator;

    public Student(String name, String dob, String p1, String p2, String p3) {
        this.name = name;
        this.dob = dob;
        this.p1 = Float.parseFloat(p1);
        this.p2 = Float.parseFloat(p2);
        this.p3 = Float.parseFloat(p3);
        pS = this.p1 + this.p2 + this.p3;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    public Object[] toObject() {
        Object[] o = new Object[3];
        o[0] = name;
        o[1] = dob;
        o[2] = pS;
        return o;
    }

    @Override
    public int compareTo(Student o) {
        if (Objects.equals(comparator, "Name")) return this.name.compareTo(o.name);
        else if (Objects.equals(comparator, "Date of birth")) return this.dob.compareTo(o.dob);
        else if (Objects.equals(comparator, "Total point")) return Float.compare(this.pS, o.pS);
        return 0;
    }
}

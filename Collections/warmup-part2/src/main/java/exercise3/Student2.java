package exercise3;

/**
 * Created by Ramona.Raducu on 7/7/2017.
 */
public class Student2 extends  Student {
    public Student2() {
    }

    public Student2(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getFirstName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Student)) return false;

        Student student = (Student) obj;

        if (!getFirstName().equals(student.getFirstName()))
            return false;


        return true;
    }
}

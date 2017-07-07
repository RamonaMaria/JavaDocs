package exercise3;

/**
 * Created by Ramona.Raducu on 7/7/2017.
 */
public class Student4 extends Student {

    public Student4(String firstName, String lastName) {
       super(firstName, lastName);
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
}

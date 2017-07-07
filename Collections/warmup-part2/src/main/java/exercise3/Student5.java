package exercise3;

/**
 * Created by Ramona.Raducu on 7/7/2017.
 */
public class Student5 extends Student {
    public Student5(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;


        if (!getFirstName().equals(student.getFirstName())) return false;
        if (!getLastName().equals(student.getLastName())) return false;

        return  true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
}

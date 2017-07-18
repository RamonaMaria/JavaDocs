package ro.teamnet.zth.web;

/**
 * Created by Ramona.Raducu on 7/18/2017.
 */
public
class Person  implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private Long age;
    private boolean  married;

    public
    Person(String s, String s1, Long aLong, Boolean aBoolean) {
        this.firstName = s;
        this.lastName = s1;
        this.age = aLong;
        this.married = aBoolean;
    }

    public
    String getFirstName() {
        return firstName;
    }

    public
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public
    String getLastName() {
        return lastName;
    }

    public
    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public
    Long getAge() {
        return age;
    }

    public
    void setAge(Long age) {
        this.age = age;
    }

    public
    boolean isMarried() {
        return married;
    }

    public
    void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public
    int compareTo(Person o) {
        return this.age > o.age ? 1 : this.age < o.age ? -1 : 0;

    }
}

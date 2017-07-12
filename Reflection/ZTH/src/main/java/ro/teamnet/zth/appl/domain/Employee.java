package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */
@Table(name = "EMPLOYEES")
public class Employee {

    @Id(name = "EMPLOYEE_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hire;

    @Column(name = "JOB_ID")
    private Job job_id;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "COMMISION_PCT")
    private double commission_pct;

    @Column(name = "MANAGER_ID")
    private Employee manager_id;

    @Column(name = "DEPARTMENT_ID")
    private Departament deartment_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hire) {
        this.hire = hire;
    }

    public Job getJob_id() {
        return job_id;
    }

    public void setJob_id(Job job_id) {
        this.job_id = job_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(int commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Employee getManager_id() {
        return manager_id;
    }

    public void setManager_id(Employee manager_id) {
        this.manager_id = manager_id;
    }

    public Departament getDeartment_id() {
        return deartment_id;
    }

    public void setDeartment_id(Departament deartment_id) {
        this.deartment_id = deartment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (Double.compare(employee.commission_pct, commission_pct) != 0) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (!hire.equals(employee.hire)) return false;
        if (!job_id.equals(employee.job_id)) return false;
        if (manager_id != null ? !manager_id.equals(employee.manager_id) : employee.manager_id != null) return false;
        return deartment_id != null ? deartment_id.equals(employee.deartment_id) : employee.deartment_id == null;
    }

//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + lastName.hashCode();
//        result = 31 * result + email.hashCode();
//        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
//        result = 31 * result + hire.hashCode();
//        result = 31 * result + job_id.hashCode();
//        temp = Double.doubleToLongBits(salary);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(commission_pct);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (manager_id != null ? manager_id.hashCode() : 0);
//        result = 31 * result + (deartment_id != null ? deartment_id.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", hire=" + hire +
                ", job_id=" + job_id +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", manager_id=" + manager_id +
                ", deartment_id=" + deartment_id +
                '}';
    }
}

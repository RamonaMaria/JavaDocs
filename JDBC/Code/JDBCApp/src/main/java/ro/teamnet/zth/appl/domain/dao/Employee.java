package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;

import java.util.Date;

@Table(name = "EMPLOYEES")
public class Employee {

    @Id(name = "EMPLOYEE_ID")
    private Long id;

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
    private Long salary;

    @Column(name = "COMMISION_PCT")
    private Long commission_pct;

    @Column(name = "MANAGER_ID")
    private Employee manager_id;

    @Column(name = "DEPARTMENT_ID")
    private Department deartment_id;

    public
    Long getId() {
        return id;
    }

    public
    void setId(Long id) {
        this.id = id;
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
    String getEmail() {
        return email;
    }

    public
    void setEmail(String email) {
        this.email = email;
    }

    public
    String getPhoneNumber() {
        return phoneNumber;
    }

    public
    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public
    Date getHire() {
        return hire;
    }

    public
    void setHire(Date hire) {
        this.hire = hire;
    }

    public
    Job getJob_id() {
        return job_id;
    }

    public
    void setJob_id(Job job_id) {
        this.job_id = job_id;
    }

    public
    Long getSalary() {
        return salary;
    }

    public
    void setSalary(Long salary) {
        this.salary = salary;
    }

    public
    Long getCommission_pct() {
        return commission_pct;
    }

    public
    void setCommission_pct(Long commission_pct) {
        this.commission_pct = commission_pct;
    }

    public
    Employee getManager_id() {
        return manager_id;
    }

    public
    void setManager_id(Employee manager_id) {
        this.manager_id = manager_id;
    }

    public
    Department getDeartment_id() {
        return deartment_id;
    }

    public
    void setDeartment_id(Department deartment_id) {
        this.deartment_id = deartment_id;
    }

    @Override
    public
    boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (hire != null ? !hire.equals(employee.hire) : employee.hire != null) return false;
        if (job_id != null ? !job_id.equals(employee.job_id) : employee.job_id != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (commission_pct != null ? !commission_pct.equals(employee.commission_pct) : employee.commission_pct != null)
            return false;
        if (manager_id != null ? !manager_id.equals(employee.manager_id) : employee.manager_id != null) return false;
        return deartment_id != null ? deartment_id.equals(employee.deartment_id) : employee.deartment_id == null;
    }

    @Override
    public
    int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hire != null ? hire.hashCode() : 0);
        result = 31 * result + (job_id != null ? job_id.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commission_pct != null ? commission_pct.hashCode() : 0);
        result = 31 * result + (manager_id != null ? manager_id.hashCode() : 0);
        result = 31 * result + (deartment_id != null ? deartment_id.hashCode() : 0);
        return result;
    }

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
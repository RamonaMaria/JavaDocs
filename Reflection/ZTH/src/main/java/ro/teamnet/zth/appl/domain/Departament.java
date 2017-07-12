package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */

@Table(name = "DEPARTMENTS")
public class Departament {

    @Id(name = "DEPARTMENT_ID")
    private long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "LOCATION_ID")
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departament)) return false;

        Departament that = (Departament) o;

        if (id != that.id) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
//        result = 31 * result + (location != null ? location.hashCode() : 0);
//        return result;
//    }
}

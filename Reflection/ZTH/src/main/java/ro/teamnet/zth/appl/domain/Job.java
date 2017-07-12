package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */
@Table(name = "JOBS")
public class Job {

    @Id(name = "JOB_ID")
    private String id;

    @Column(name = "JOB_TITLE")
    private String title;

    @Column(name = "MIN_SALARY")
    private int min_salary;

    @Column(name = "MAX_SALARY")
    private int max_salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (min_salary != job.min_salary) return false;
        if (max_salary != job.max_salary) return false;
        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        return title != null ? title.equals(job.title) : job.title == null;
    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + min_salary;
//        result = 31 * result + max_salary;
//        return result;
//    }


    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }
}

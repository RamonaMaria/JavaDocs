package ro.teamnet.zth.appl.domain.dao;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

@Table(name = "JOBS")
public class Job {

    @Id(name = "job_id")
    private String id;

    @Column(name = "job_title")
    private String title;

    @Column(name = "min_salary")
    private Long min_salary;

    @Column(name = "max_salary")
    private Long max_salary;

    public
    String getId() {
        return id;
    }

    public
    void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public
    boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (title != null ? !title.equals(job.title) : job.title != null) return false;
        if (min_salary != null ? !min_salary.equals(job.min_salary) : job.min_salary != null) return false;
        return max_salary != null ? max_salary.equals(job.max_salary) : job.max_salary == null;
    }

    @Override
    public
    int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (min_salary != null ? min_salary.hashCode() : 0);
        result = 31 * result + (max_salary != null ? max_salary.hashCode() : 0);
        return result;
    }

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
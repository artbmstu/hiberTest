package dao;

import javax.persistence.*;

@Entity
@Table(name = "company", schema = "test")
public class CompanyEntity {
    private int idcompany;
    private String employee;

//    @Version
//    @Column(name = "version", nullable = false, insertable = true, updatable = true)
//    public int getVersion() {
//        return version;
//    }
    @Id
    @Column(name = "idcompany", nullable = false, insertable = true, updatable = true)
    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    @Basic
    @Column(name = "employee")
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (idcompany != that.idcompany) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcompany;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}

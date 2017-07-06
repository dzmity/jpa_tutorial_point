package by.rafalovich.study.simple_jpa.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(schema = "home_dzmitry_rafalovich", name = "EMPLOYEES")
@Access(value = PROPERTY)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type")
//@Inheritance( strategy = InheritanceType.JOINED )
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@NamedQueries({
        @NamedQuery(name = "findByMinSalary", query = "from Employee e where e.employeeSalary >= :employeeSalary"),
        @NamedQuery(name = "findByName", query = "from Employee e where e.employeeName = :employeeName"),
        @NamedQuery(name = "findByPosition", query = "from Employee e where e.employeePosition LIKE lower(:employeePosition)")})
public class Employee
{
    private Long employeeId;
    private String employeeName;
    private Integer employeeSalary;
    private String employeePosition;

    @Id
    @Column(name = "EMPL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }

    @Column(name = "EMPL_NAME")
    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    @Column(name = "EMPL_SALARY")
    public Integer getEmployeeSalary()
    {
        return employeeSalary;
    }

    public void setEmployeeSalary(Integer employeeSalary)
    {
        this.employeeSalary = employeeSalary;
    }

    @Column(name = "EMPL_POSITION")
    public String getEmployeePosition()
    {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition)
    {
        this.employeePosition = employeePosition;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("employeeId", employeeId)
                .append("employeeName", employeeName)
                .append("employeeSalary", employeeSalary)
                .append("employeePosition", employeePosition)
                .toString();
    }
}


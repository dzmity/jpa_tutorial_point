package by.rafalovich.study.simple_jpa.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "home_dzmitry_rafalovich", name = "EMPLOYEES")
public class Employee
{
    private Long employeeId;
    private String employeeName;
    private Integer employeeSalary;
    private String employeeDeg;

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

    @Column(name = "EMPL_DEG")
    public String getEmployeeDeg()
    {
        return employeeDeg;
    }

    public void setEmployeeDeg(String employeeDeg)
    {
        this.employeeDeg = employeeDeg;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("employeeId", employeeId)
                .append("employeeName", employeeName)
                .append("employeeSalary", employeeSalary)
                .append("employeeDeg", employeeDeg)
                .toString();
    }
}


package by.rafalovich.study.simple_jpa.entity;

import javax.persistence.*;

@Entity
@Table(schema = "home_dzmitry_rafalovich", name = "EMPLOYEES")
public class Employee
{

    private Long employeeId;
    private String employeeName;
    private Integer employeeSalary;
    private String employeeDeg;

    @Id
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
}


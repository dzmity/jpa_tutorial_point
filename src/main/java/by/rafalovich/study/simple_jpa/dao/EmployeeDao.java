package by.rafalovich.study.simple_jpa.dao;

import by.rafalovich.study.simple_jpa.entity.Employee;

import java.util.List;

public abstract class EmployeeDao extends JpaDao
{
    public abstract List<Employee> findByMinSalary(Integer employeeSalary);

    public abstract List<Employee> findByName(String employeeName);

    public abstract List<Employee> findByPosition(String employeePosition);
}

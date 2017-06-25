package by.rafalovich.study.simple_jpa;

import by.rafalovich.study.simple_jpa.dao.impl.EmployeeDaoImpl;
import by.rafalovich.study.simple_jpa.entity.Employee;

import static by.rafalovich.study.simple_jpa.dao.JpaDao.closeEMF;

public class Start
{
    public static void main(String[] args)
    {
        Employee employee = new Employee();
        employee.setEmployeeName("Dzmitry2");
        employee.setEmployeeSalary(50);
        employee.setEmployeeDeg("developer");

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.create(employee);
        closeEMF();
    }
}

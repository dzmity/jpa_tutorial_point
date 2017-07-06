package by.rafalovich.study.simple_jpa;

import by.rafalovich.study.simple_jpa.dao.impl.EmployeeDaoImpl;
import by.rafalovich.study.simple_jpa.entity.Employee;

import static by.rafalovich.study.simple_jpa.dao.JpaDao.closeEMF;

public class Start
{
    public static void main(String[] args)
    {
        Employee employee = createEmployee();

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.create(employee);
        employee.setEmployeeSalary(150);
        employeeDao.update(employee);
        System.out.println(employeeDao.find(1L));
        employeeDao.delete(employee);
        closeEMF();
    }

    private static Employee createEmployee()
    {
        Employee employee = new Employee();
        employee.setEmployeeName("Dzmitry");
        employee.setEmployeeSalary(50);
        employee.setEmployeeDeg("developer");
        return employee;
    }
}

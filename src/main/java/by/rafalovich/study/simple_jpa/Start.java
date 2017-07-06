package by.rafalovich.study.simple_jpa;

import by.rafalovich.study.simple_jpa.dao.EmployeeDao;
import by.rafalovich.study.simple_jpa.dao.impl.EmployeeDaoImpl;
import by.rafalovich.study.simple_jpa.entity.Employee;

import static by.rafalovich.study.simple_jpa.dao.JpaDao.closeEMF;

public class Start
{
    public static void main(String[] args)
    {
        Employee employee = createEmployee();

        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.create(employee);
//        employee.setEmployeeSalary(150);
//        employeeDao.update(employee);
//        System.out.println(employeeDao.find(1L));
//        employeeDao.delete(employee);
//        employeeDao.findByMinSalary(80).stream().forEach(e -> System.out.println(e));
//        employeeDao.findByName("Dzmitry").stream().forEach(e -> System.out.println(e));
//        employeeDao.findByPosition("devEloper").stream().forEach(e -> System.out.println(e));

        closeEMF();
    }

    private static Employee createEmployee()
    {
        Employee employee = new Employee();
        employee.setEmployeeName("Dzmitry");
        employee.setEmployeeSalary(50);
        employee.setEmployeePosition("developer");
        return employee;
    }
}

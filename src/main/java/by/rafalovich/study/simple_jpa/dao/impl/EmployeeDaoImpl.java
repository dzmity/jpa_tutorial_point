package by.rafalovich.study.simple_jpa.dao.impl;

import by.rafalovich.study.simple_jpa.dao.IDao;
import by.rafalovich.study.simple_jpa.dao.JpaDao;
import by.rafalovich.study.simple_jpa.entity.Employee;

import javax.persistence.EntityManager;

public class EmployeeDaoImpl extends JpaDao implements IDao<Employee>
{
    public void create(Employee employee)
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Employee find(Long employeeId)
    {
        EntityManager entityManager = getEntityManager();

        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.close();
        return employee;
    }

    public void delete(Employee employee)
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Employee persistentEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
        entityManager.remove(persistentEmployee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Employee employee)
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Employee persistentEmployee = entityManager.find(Employee.class, employee.getEmployeeId());

        //should be converted with dozzer instead of this
        persistentEmployee.setEmployeeDeg(employee.getEmployeeDeg());
        persistentEmployee.setEmployeeName(employee.getEmployeeName());
        persistentEmployee.setEmployeeSalary(employee.getEmployeeSalary());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

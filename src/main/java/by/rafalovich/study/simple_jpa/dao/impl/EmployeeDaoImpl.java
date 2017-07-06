package by.rafalovich.study.simple_jpa.dao.impl;

import by.rafalovich.study.simple_jpa.dao.EmployeeDao;
import by.rafalovich.study.simple_jpa.dao.IDao;
import by.rafalovich.study.simple_jpa.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDaoImpl extends EmployeeDao implements IDao<Employee>
{
    private static final String FIND_BY_MIN_SALARY_QUERY_NAME = "findByMinSalary";
    private static final String FIND_BY_NAME_QUERY_NAME = "findByName";
    private static final String FIND_BY_POSITION_QUERY_NAME = "findByPosition";
    private static final String EMPLOYEE_POSITION_PARAMETER_NAME = "employeePosition";
    private static final String EMPLOYEE_NAME_PARAMETER_NAME = "employeeName";
    private static final String EMPLOYEE_SALARY_PARAMETER_NAME = "employeeSalary";

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
        persistentEmployee.setEmployeePosition(employee.getEmployeePosition());
        persistentEmployee.setEmployeeName(employee.getEmployeeName());
        persistentEmployee.setEmployeeSalary(employee.getEmployeeSalary());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> findByMinSalary(Integer employeeSalary)
    {
        EntityManager entityManager = getEntityManager();
        List<Employee> employees = entityManager.createNamedQuery(FIND_BY_MIN_SALARY_QUERY_NAME)
                .setParameter(EMPLOYEE_SALARY_PARAMETER_NAME, employeeSalary).getResultList();
        entityManager.close();
        return employees;
    }

    @Override
    public List<Employee> findByName(String employeeName)
    {
        EntityManager entityManager = getEntityManager();
        List<Employee> employees = entityManager.createNamedQuery(FIND_BY_NAME_QUERY_NAME)
                .setParameter(EMPLOYEE_NAME_PARAMETER_NAME, employeeName).getResultList();
        entityManager.close();
        return employees;
    }

    @Override
    public List<Employee> findByPosition(String employeePosition)
    {
        EntityManager entityManager = getEntityManager();
        List<Employee> employees = entityManager.createNamedQuery(FIND_BY_POSITION_QUERY_NAME)
                .setParameter(EMPLOYEE_POSITION_PARAMETER_NAME, employeePosition).getResultList();
        entityManager.close();
        return employees;
    }
}

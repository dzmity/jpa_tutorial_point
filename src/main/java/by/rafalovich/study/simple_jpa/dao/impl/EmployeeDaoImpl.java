package by.rafalovich.study.simple_jpa.dao.impl;

import by.rafalovich.study.simple_jpa.entity.Employee;
import by.rafalovich.study.simple_jpa.dao.IDao;
import by.rafalovich.study.simple_jpa.dao.JpaDao;

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

    public void delete(Long id)
    {

    }

    public void delete(Employee employee)
    {

    }

    public void update(Employee employee)
    {

    }
}

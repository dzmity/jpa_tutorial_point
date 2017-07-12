package by.rafalovich.study.simple_jpa;

import by.rafalovich.study.simple_jpa.dao.DevelopmentTeamDao;
import by.rafalovich.study.simple_jpa.dao.EmployeeDao;
import by.rafalovich.study.simple_jpa.dao.impl.DevelopmentTeamDaoImpl;
import by.rafalovich.study.simple_jpa.dao.impl.EmployeeDaoImpl;
import by.rafalovich.study.simple_jpa.entity.DevelopmentTeam;
import by.rafalovich.study.simple_jpa.entity.Employee;
import by.rafalovich.study.simple_jpa.entity.NonProductionEmployee;
import by.rafalovich.study.simple_jpa.entity.ProductionEmployee;

import static by.rafalovich.study.simple_jpa.dao.JpaDao.closeEMF;

public class Start
{
    public static void main(String[] args)
    {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        DevelopmentTeamDao developmentTeamDao = new DevelopmentTeamDaoImpl();

        DevelopmentTeam team = createDevTeam();
        developmentTeamDao.create(team);

        ProductionEmployee productionEmployee = createProductionEmployee(team);
        employeeDao.create(productionEmployee);

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

    private static ProductionEmployee createProductionEmployee(DevelopmentTeam team)
    {
        ProductionEmployee employee = new ProductionEmployee();
        employee.setEmployeeName("Dzmitry_Rafalovich");
        employee.setEmployeeSalary(500);
        employee.setEmployeePosition("developer");
        employee.setPositionTitle("D1");
        employee.setDevelopmentTeam(team);
        return employee;
    }

    private static NonProductionEmployee createNonProductionEmployee()
    {
        NonProductionEmployee employee = new NonProductionEmployee();
        employee.setEmployeeName("Antoha");
        employee.setEmployeeSalary(300);
        employee.setEmployeePosition("plumber");
        employee.setOfficeAddress("N58");
        return employee;
    }

    private static DevelopmentTeam createDevTeam()
    {
        DevelopmentTeam team = new DevelopmentTeam();
        team.setTeamName("Phoenix");
        return team;
    }
}

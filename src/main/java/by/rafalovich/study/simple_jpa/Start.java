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
//        Employee employee = createEmployee();

//        NonProductionEmployee nonProductionEmployee = createNonProductionEmployee();

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        DevelopmentTeamDao developmentTeamDao = new DevelopmentTeamDaoImpl();
        developmentTeamDao.create(createDevTeam());
        DevelopmentTeam developmentTeam = developmentTeamDao.find(1L);
        ProductionEmployee productionEmployee = createProductionEmployee(developmentTeam);
//        employeeDao.create(employee);
//        employee.setEmployeeSalary(150);
//        employeeDao.update(employee);
//        System.out.println(employeeDao.find(1L));
//        employeeDao.delete(employee);
//        employeeDao.findByMinSalary(80).stream().forEach(e -> System.out.println(e));
//        employeeDao.findByName("Dzmitry").stream().forEach(e -> System.out.println(e));
//        employeeDao.findByPosition("devEloper").stream().forEach(e -> System.out.println(e));
        employeeDao.create(productionEmployee);
//        employeeDao.create(nonProductionEmployee);
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

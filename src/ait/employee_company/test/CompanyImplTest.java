package ait.employee_company.test;

import ait.employee_company.dao.Company;
import ait.employee_company.dao.CompanyImpl;
import ait.employee_company.model.Employee;
import ait.employee_company.model.Manager;
import ait.employee_company.model.SalesManager;
import ait.employee_company.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {
    Company company;
    Employee[] firma;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firma = new Employee[5];
        firma[0] = new Manager(1000, "Bill", "Smith", 160, 35, 5000);
        firma[1] = new Worker(2000, "Anne", "Müller", 170, 28);
        firma[2] = new SalesManager(3000, "Peter", "Jackson", 160, 50, 19000);
        firma[3] = new SalesManager(4000, "Robin", "Good", 180, 45, 20000);

        for (int i = 0; i < firma.length; i++) {
            company.addEmployee(firma[i]);
        }
    }

    @Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertFalse(company.addEmployee(firma[0]));
        Employee employee = new SalesManager(5000, "Michael", "Schuhmacher", 160, 30000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Nick", "Lohman", 160, 25000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @Test
    void findEmployee() {
        assertEquals(firma[1], company.findEmployee(2000));
        assertNull(company.findEmployee(5000));
    }

    @Test
    void updateEmployee() {
        // создать нового сотрудника с новой фамилией
        Employee worker = new Worker(2000, "Anne", "Краллер", 160, 28); // updated
        assertEquals(firma[1], company.updateEmployee(worker));
        worker = new Worker(6000, "Anne", "Müller1", 160, 28);
        assertNull(company.updateEmployee(worker));

    }

    @Test
    void removeEmployee() {
        Employee employeeVictim = company.revoveEmployee(3000);
        assertEquals(firma[2], employeeVictim);
        assertEquals(3, company.quantity());
        assertNull(company.revoveEmployee(3000));
    }

    @Test
    void printEmployee() {
        company.printEmployee();
    }

    @Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @Test
    void totalSalary() {
        assertEquals(2654795.0, company.totalSalary());

    }

    @Test
    void totalSales() {
        assertEquals(95, company.totalSales());
    }

    @Test
    void findEmployeeGrateHoursThan() {
        Employee[] expected = {firma[1], firma[3]};
        Employee[] actual = company.findEmployeeGrateHoursThan(160);
        assertArrayEquals(expected, actual);
    }

}
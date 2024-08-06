package ait.employee_company.dao;


import ait.employee_company.model.Employee;

public interface Company {

    // only abstract methods for Employee and children

    //================================================
   /*
    CRUD - методы
    C - create
    R - read
    U - update
    D - delete
   */

    // нанимать - create
   // Employee addEmployee(Employee employee);
    boolean addEmployee(Employee employee); // boolean - отвечает за то, что удалось добавить или нет

    // искать в списке
    Employee findEmployee(int id);

    // обновлять данные
    Employee updateEmployee(Employee employee);

    // уволить (удалить)
    Employee removeEmployee(int id);

    // напечатать
    void printEmployee();

    // кол-во сотрудников
    int quantity();

    // считать зарплату
    double totalSalary();
    // оборот, продажи
    double totalSales();

    Employee[] findEmployeeGrateHoursThan(double hours);

}

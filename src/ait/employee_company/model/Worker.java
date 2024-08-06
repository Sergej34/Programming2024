package ait.employee_company.model;

public class Worker extends Employee {

    private double wage;    // заработная плата

    public Worker(int id, String firstName, String lastName, double hours, int age) {
        super(id, firstName, lastName, hours, age);
    }

    public Worker(int id, String lastName, double hours) {
        super(id, lastName, hours);
    }

    public Worker(int id, String firstName, String lastName, double hours) {
        super(id, firstName, lastName, hours);
    }


    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double salary() {
        double salary = wage * hours; // calculate salary
       // salary = ensureSalary(salary);
        return ensureSalary(salary); // check salary
    }
}

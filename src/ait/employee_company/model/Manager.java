package ait.employee_company.model;
//- создать дочерние классы practice.model.Manager, practice.model.SalesManager и Worker,
// реализовать в них методы начисления зарплаты:
//    - practice.model.Manager: base + grade*hours
//    - practice.model.SalesManager: salesValue * percent
//    - Worker: grade*hours

public class Manager extends Employee {
    private double baseSalary;
    private int grade;

    public Manager(int id, String firstName, String lastName, int i, double hours, double baseSalary, int grade) {
        super(id, firstName, lastName, hours);
        this.baseSalary = baseSalary;
        this.grade = grade; // разряд, тарифная сетка
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public double salary() {
        double salary = baseSalary + hours * grade;
        return ensureSalary(salary);
    }
}

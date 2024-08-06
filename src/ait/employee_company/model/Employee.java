package ait.employee_company.model;

import java.util.Objects;

public abstract class Employee {

    protected static double minWage = 13; // 13 euro/hour // protected видит только внутри этого пакета
    protected final int id;
    protected String firstName;
    protected String lastName;
    protected double hours;
    protected int age;

    public Employee(int id, String firstName, String lastName, double hours, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
        this.age = age;
    }

    public Employee(int id, String lastName, double hours) {
        this.id = id;
        this.lastName = lastName;
        this.hours = hours;
    }

    public Employee(int id, String firstName, String lastName, double hours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
    }

    public static double getMinWage() {
        return minWage;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    // защищает
    // protect from mistake in salary department // проверить навернека
    protected double ensureSalary(double salary) {
        if (salary < hours * minWage) {
            salary = hours * minWage;
        }
        return salary;
    }


    public static void setMinWage(double minWage) {
        if (minWage >= Employee.minWage) {
            Employee.minWage = minWage;
        }
    }

    public abstract double salary(); // абстрактный метод, требует реализации в дочернем классе

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", hours=").append(hours);
        sb.append('}');
        return sb.toString();
    }
}

package homework_28;

import java.util.Objects;

//Задание 1. Придумайте класс МойКласс с полями типа:
//String
//int
//double
//например: Person - name, weight, age City - name, population, area ...
public class City implements Comparable<City> {

    private String name;
    private int population;
    private double area;
    private int age;

    public City(String name, int population, double area, int age) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof City city)) return false;
        return population == city.population && Double.compare(area, city.area) == 0 && age == city.age && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, area, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", population=").append(population);
        sb.append(", area=").append(area);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(this.population, o.population);
    }
}

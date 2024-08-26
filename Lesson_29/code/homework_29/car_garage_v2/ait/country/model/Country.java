package homework_29.car_garage_v2.ait.country.model;

import java.util.Objects;

//Задание 2. Взять на выбор любой из классов: Country - name, population
// River - name, length свой пример и выполнить с ним примеры
// по аналогии с City, которые мы делали на занятии.
public class Country implements Comparable<Country> {

    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
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



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country country)) return false;
        return population == country.population && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }
    @Override
    public String toString(){
        return String.format("Country name - %s, population - %d", name, population);
    }

    @Override
    public int compareTo(Country country) {
        //return this.population - country.population;
        return Integer.compare(this.population, country.population);
    }
}

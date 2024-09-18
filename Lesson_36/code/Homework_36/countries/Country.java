package Homework_36.countries;

import java.util.Objects;

//Задача 3. Создайте класс Country со следующими полями:
//название;
//население(в млн.);
//континент. Создайте связный список, содержащий 11 стран из разных континентов. Получите списки этих стран, отсортированные по:
//алфавиту;
//по размеру населения в стандартном и обратном порядках;
//принадлежности континенту и размеру населения в порядке от большего к меньшему.
public class Country implements Comparable<Country> {

    private String name;
    private int population;
    private String continent;

    public Country(String name, int population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country country)) return false;
        return population == country.population && Objects.equals(name, country.name) && Objects.equals(continent, country.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, continent);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("name='").append(name).append('\'');
        sb.append(", population=").append(population);
        sb.append(", continent='").append(continent).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }
}

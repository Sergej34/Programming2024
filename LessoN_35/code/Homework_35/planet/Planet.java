package Homework_35.planet;
// Задача 2. Занести планеты солнечной системы в список, содержащий:
//наименование;
//расстояние до Солнца;
//массу;
//количество спутников.
//Вывести список планет отсортированный по:
//порядку расположения в солнечной системе;
//алфавиту;
//массе;
//количеству спутников.

public class Planet {

    private String name;
    private Double distanceFromSun;
    private Double mass;
    private int numberOfMoons;

    public Planet(String name, Double distanceFromSun, Double mass, int numberOfMoons) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.mass = mass;
        this.numberOfMoons = numberOfMoons;
    }

    public String getName() {
        return name;
    }

    public Double getDistanceFromSun() {
        return distanceFromSun;
    }

    public Double getMass() {
        return mass;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("name='").append(name).append('\'');
        sb.append(", distanceFromSun=").append(distanceFromSun);
        sb.append(", mass=").append(mass);
        sb.append(", numberOfMoons=").append(numberOfMoons);
        sb.append('}');
        return sb.toString();
    }
}

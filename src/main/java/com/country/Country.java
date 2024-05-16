package com.country;

public class Country implements Comparable<Country> {
    private int id;
    private String name;
    private int population;
    private String continent;

    public Country() {
    }

    public Country(int id, String name, String continent, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.continent = continent;

    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                '}';
    }


    public int compareTo(Country that) {
        if (that.population < this.population)
            return 1;
        else
            return -1;
    }
}

package com.country;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country(5, "Bahrain", "Asia", 90000));
        countries.add(new Country(1, "Algeria", "Africa", 50000));
        countries.add(new Country(2, "Angola", "Africa", 60000));
        countries.add(new Country(7, "Belgium", "Europe", 110000));
        countries.add(new Country(3, "Egypt", "Africa", 70000));
        countries.add(new Country(9, "Denmark", "Europe", 130000));
        countries.add(new Country(4, "Armenia", "Asia", 80000));
        countries.add(new Country(6, "China", "Asia", 100000));
        countries.add(new Country(8, "Croatia", "Europe", 120000));
        countries.add(new Country(10, "Finland", "Europe", 140000));
Comparator<Country> comparatorByPoplation = new Comparator<Country>(){
    @Override
    public int compare(Country o1, Country o2) {
        if (o1.getPopulation() > o2.getPopulation()) {
            return 1;
        } else
            return -1;
    }
};
        Comparator<Country> comparatorById = new Comparator<Country>(){
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else
                    return -1;
            }
        };
        // Collections.sort(countries);
        //Collections.sort(countries,comparatorByPoplation);
        Collections.sort(countries,comparatorById);

        System.out.println(countries);

        /*Map that have population as value and country name as key*/
        Map<String, Integer> countryPopulationMap = countries.stream()
                .collect(Collectors.toMap(Country::getName, Country::getPopulation));
        countryPopulationMap.forEach((s, integer) -> System.out.println("Country Name: " + s + " Country Population: " + integer));


        /*Number of Courtries  have Population more than 100000 */
        long countriesStreamBiggestPop = countries.stream()
                .filter(country -> country.getPopulation() > 100000)
                .count();
        System.out.println("Number of Courtries  have Population more than 100000 " + countriesStreamBiggestPop);
        /*Max Number of Population  */
        Optional<Country> mostCrowdedCountry = countries.stream()
                .max(Comparator.comparing(Country::getPopulation));
        System.out.println(mostCrowdedCountry);
        /*Min Number of Population*/
        Optional<Country> leastCrowdedCountry = countries.stream()
                .min(Comparator.comparing(Country::getPopulation));
        System.out.println(leastCrowdedCountry);




        Map<String, List<Country>> continentToCountriesMap = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent));
        continentToCountriesMap.forEach((continent, countryList) -> {
            System.out.println("Continent: " + continent + " -> Countries: " + countryList);
        });

    }
}


package com.clover.springdemo.old;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private String favoriteLanguage;
    private String[] operatingSystems;

    private Map<String, String> favoriteLangOptions;
    private Map<String, String> osOptions;

    public Student() {
//        // populate country options: used ISO country codes
//        countryOptions = new LinkedHashMap<>();
//
//        countryOptions.put("BR", "Brazil");
//        countryOptions.put("FR", "France");
//        countryOptions.put("ITA", "Italy");
//        countryOptions.put("JP", "Japan");
//        countryOptions.put("US", "United States of America");

        favoriteLangOptions = new LinkedHashMap<>();

        favoriteLangOptions.put("Java", "Java");
        favoriteLangOptions.put("C#", "C#");
        favoriteLangOptions.put("PHP", "PHP");
        favoriteLangOptions.put("Ruby", "Ruby");
        favoriteLangOptions.put("JavaScript", "JavaScript");

        osOptions = new LinkedHashMap<>();

        osOptions.put("Windows", "Windows");
        osOptions.put("Mac OS", "Mac OS");
        osOptions.put("Linux", "Linux");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Map<String, String> getFavoriteLangOptions() {
        return favoriteLangOptions;
    }

    public void setFavoriteLangOptions(Map<String, String> favoriteLangOptions) {
        this.favoriteLangOptions = favoriteLangOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public Map<String, String> getOsOptions() {
        return osOptions;
    }

    public void setOsOptions(Map<String, String> osOptions) {
        this.osOptions = osOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}


package ua.artcode.model;

import java.util.Scanner;

/**
 * Created by IT on 21.08.2016.
 */
public class Location {

    private long id;
    private String country;
    private String city;


    // constructors --------------------------------------------------------------------------------
    public Location() {
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }



    //metods----------------------------------------------------------------------------------------

    // создание локаций (городов)
    public Location setLocationMenu(Scanner scanner) {

        System.out.println("Input country");
        String country = scanner.nextLine();
        System.out.println("Input city");
        String city = scanner.nextLine();

        Location location = new Location(country,city);
        return location;
    }
    // geters & seters -----------------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

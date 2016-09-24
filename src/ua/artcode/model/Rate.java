package ua.artcode.model;

/**
 * Created by work on 23.08.2016.
 */
public class Rate {

    public String rateService = "*";

    public Rate(String rateService) {
        this.rateService = rateService;
    }

    public String toString() {
        return rateService;
    }

}

package exercise.model;

import exercise.annotation.Inspect;

public class Address {
    private String city;
    private int postalCode;

    public Address(String city, int postalCode) {
        this.city = city;
        this.postalCode = postalCode;
    }

    // BEGIN
    @Inspect(logArgs = false, logReturn = false)
    // END
    public String getCity() {
        return city;
    }

    // BEGIN
    @Inspect(logArgs = false, logReturn = false)
    // END
    public int getPostalCode() {
        return postalCode;
    }

    public String getFullAddress() {
        return city + " " + postalCode;
    }
}

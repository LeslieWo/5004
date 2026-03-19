package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a non-profit organization that tracks donations.
 */
public class NonProfit {
    private String name;
    private List<Donation> donations;

    /**
     * Constructor for NonProfit
     * @param name the name of the non-profit organization
     */
    public NonProfit(String name) {
        this.name = name;
        this.donations = new ArrayList<>();
    }

    /**
     * Gets the organization name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a donation to the collection
     * @param donation the donation to add
     */
    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    /**
     * Gets all donations
     * @return a copy of the donations list
     */
    public List<Donation> getDonations() {
        return new ArrayList<>(donations);
    }

    /**
     * Calculates the total donations processed in a given year.
     * Uses polymorphism - each donation type calculates its own total.
     * @param year the year to calculate donations for
     * @return the total donation amount for the specified year
     */
    public double getTotalDonationsForYear(int year) {
        double total = 0.0;
        for (Donation donation : donations) {
            total += donation.getTotalForYear(year);
        }
        return total;
    }
}

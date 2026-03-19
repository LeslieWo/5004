package problem1;

import java.time.LocalDateTime;

/**
 * Abstract base class representing a donation to a non-profit organization.
 * All donations have an amount and creation date/time.
 */
public abstract class Donation {
    private double amount;
    private LocalDateTime creationDateTime;

    /**
     * Constructor for Donation
     * @param amount the donation amount
     * @param creationDateTime the date and time the donation was created
     * @throws IllegalArgumentException if amount is negative
     */
    public Donation(double amount, LocalDateTime creationDateTime) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Gets the donation amount
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the creation date and time
     * @return the creation date time
     */
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Abstract method to calculate the total donation amount for a given year.
     * Each donation type implements its own logic.
     * @param year the year to calculate donations for
     * @return the total donation amount for the specified year
     */
    public abstract double getTotalForYear(int year);
}

package problem1;

import java.time.LocalDateTime;

/**
 * Represents a one-time donation made on a specific date.
 */
public class OneTimeDonation extends Donation {

    /**
     * Constructor for OneTimeDonation
     * @param amount the donation amount
     * @param creationDateTime the date and time the donation was made
     */
    public OneTimeDonation(double amount, LocalDateTime creationDateTime) {
        super(amount, creationDateTime);
    }

    /**
     * Calculates the total donation for a given year.
     * One-time donations only count in the year they were created.
     * @param year the year to calculate donations for
     * @return the donation amount if created in the specified year, 0 otherwise
     */
    @Override
    public double getTotalForYear(int year) {
        if (getCreationDateTime().getYear() == year) {
            return getAmount();
        }
        return 0.0;
    }
}
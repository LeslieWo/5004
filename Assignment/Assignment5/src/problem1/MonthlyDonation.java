package problem1;

import java.time.LocalDateTime;

/**
 * Represents a monthly recurring donation that continues until cancelled.
 */
public class MonthlyDonation extends Donation {
    private LocalDateTime cancellationDateTime;

    /**
     * Constructor for MonthlyDonation
     * @param amount the monthly donation amount
     * @param creationDateTime the date and time the donation was created
     */
    public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
        super(amount, creationDateTime);
        this.cancellationDateTime = null;
    }

    /**
     * Sets the cancellation date and time for this monthly donation
     * @param cancellationDateTime the date and time to cancel the donation
     * @throws IllegalArgumentException if cancellation date is before creation date
     */
    public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
        if (cancellationDateTime.isBefore(getCreationDateTime())) {
            throw new IllegalArgumentException(
                "Cancellation date cannot be before creation date");
        }
        this.cancellationDateTime = cancellationDateTime;
    }

    /**
     * Gets the cancellation date and time
     * @return the cancellation date time, or null if not cancelled
     */
    public LocalDateTime getCancellationDateTime() {
        return cancellationDateTime;
    }

    /**
     * Calculates the total donation for a given year.
     * Counts all monthly donations that occurred in the specified year.
     * @param year the year to calculate donations for
     * @return the total amount donated in the specified year
     */
    @Override
    public double getTotalForYear(int year) {
        int creationYear = getCreationDateTime().getYear();
        int creationMonth = getCreationDateTime().getMonthValue();
        
        // If donation hasn't started yet in this year
        if (year < creationYear) {
            return 0.0;
        }
        
        // Determine the last month of donation in this year
        int lastMonth = 12;
        
        if (cancellationDateTime != null) {
            int cancellationYear = cancellationDateTime.getYear();
            if (year > cancellationYear) {
                return 0.0; // Donation already cancelled before this year
            }
            if (year == cancellationYear) {
                lastMonth = cancellationDateTime.getMonthValue();
            }
        }
        
        // Calculate number of months in this year
        int monthsInYear;
        if (year == creationYear) {
            // First year: from creation month to end of year (or cancellation)
            monthsInYear = lastMonth - creationMonth + 1;
        } else {
            // Subsequent years: all 12 months (or until cancellation)
            monthsInYear = lastMonth;
        }
        
        return getAmount() * Math.max(0, monthsInYear);
    }
}

package problem1;

import java.time.LocalDateTime;

/**
 * Represents a pledge - a promise to donate at some point in the future.
 */
public class Pledge extends Donation {
    private LocalDateTime processingDateTime;

    /**
     * Constructor for Pledge with processing date
     * @param amount the pledge amount
     * @param creationDateTime the date and time the pledge was made
     * @param processingDateTime the date and time the pledge will be processed (can be null)
     */
    public Pledge(double amount, LocalDateTime creationDateTime, 
                  LocalDateTime processingDateTime) {
        super(amount, creationDateTime);
        if (processingDateTime != null && 
            processingDateTime.isBefore(creationDateTime)) {
            throw new IllegalArgumentException(
                "Processing date cannot be before creation date");
        }
        this.processingDateTime = processingDateTime;
    }

    /**
     * Constructor for Pledge without processing date
     * @param amount the pledge amount
     * @param creationDateTime the date and time the pledge was made
     */
    public Pledge(double amount, LocalDateTime creationDateTime) {
        this(amount, creationDateTime, null);
    }

    /**
     * Sets or updates the processing date and time
     * @param processingDateTime the new processing date (can be null to remove)
     * @throws IllegalArgumentException if processing date is before creation date
     */
    public void setProcessingDateTime(LocalDateTime processingDateTime) {
        if (processingDateTime != null && 
            processingDateTime.isBefore(getCreationDateTime())) {
            throw new IllegalArgumentException(
                "Processing date cannot be before creation date");
        }
        this.processingDateTime = processingDateTime;
    }

    /**
     * Gets the processing date and time
     * @return the processing date time, or null if not set
     */
    public LocalDateTime getProcessingDateTime() {
        return processingDateTime;
    }

    /**
     * Calculates the total donation for a given year.
     * Pledge only counts in the year it is processed.
     * @param year the year to calculate donations for
     * @return the pledge amount if processed in the specified year, 0 otherwise
     */
    @Override
    public double getTotalForYear(int year) {
        if (processingDateTime != null && 
            processingDateTime.getYear() == year) {
            return getAmount();
        }
        return 0.0;
    }
}

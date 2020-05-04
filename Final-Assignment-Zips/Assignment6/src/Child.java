package Implementations.Assignment6;

/**
 * Extension of Ticket with values specific to children
 *
 * @author James Pham
 */
public class Child extends Ticket {

    public static final double EARLY_PRICE = 5.75;
    public static final double LATE_PRICE = 10.75;
    public static final double IMAX_ADDON = 2;
    public static final double THREEDIM_ADDON = 1.5;

    /**
     * Default constructor
     * @param name name of movie
     * @param rating movie rating
     * @param day day of viewing
     * @param time time of viewing
     * @param format movie format
     */
    public Child(String name,
                 String rating,
                 int day,
                 int time,
                 String format){
        super(name, rating, day, format, time, -1);
    }

    /**
     * calculate price based on certain conditions
     * @return Expected ticket price
     */
    @Override
    public double calculateTicketPrice() {
        double modifiedPrice = (time < SIX_PM) ? EARLY_PRICE : LATE_PRICE;
        if(format == Format.IMAX){
            modifiedPrice += IMAX_ADDON;
        }
        if(format == Format.THREE_D){
            modifiedPrice += THREEDIM_ADDON;
        }
        return modifiedPrice * TAX_MULTIPLIER;
    }

    /**
     * Invalidate ID, regular purchasers should be anonymous
     * @return invalid ID
     */
    @Override
    public int getId() {
        return -1;
    }
}

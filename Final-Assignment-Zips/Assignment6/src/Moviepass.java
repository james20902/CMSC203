package Implementations.Assignment6;

/**
 * Extension of Ticket with values specific to MoviePass tickets
 *
 * @author James Pham
 */

public class Moviepass extends Ticket {

    public static final double FIRST_PRICE = 9.99;

    boolean extraMovie;

    /**
     * Default constructor
     * @param name name of movie
     * @param rating movie rating
     * @param day day of viewing
     * @param time time of viewing
     * @param format movie format
     * @param id account ID
     * @param extraMovie flag set by MovieTicketManager to change price
     */
    public Moviepass(String name,
                    String rating,
                    int day,
                    int time,
                    String format, int id, boolean extraMovie){
        super(name, rating, day, format, time, id);
        this.extraMovie = extraMovie;
        this.price = calculateTicketPrice();
    }

    /**
     * calculate price based on certain conditions
     * @return Expected ticket price
     */
    @Override
    public double calculateTicketPrice() {
        double modifiedPrice = ((time < SIX_PM) ? Adult.EARLY_PRICE : Adult.LATE_PRICE);
        if(format == Format.IMAX){
            modifiedPrice += Adult.IMAX_ADDON;
            extraMovie = true;
        }
        if(format == Format.THREE_D){
            modifiedPrice += Adult.THREEDIM_ADDON;
            extraMovie = true;
        }
        return (extraMovie) ? (modifiedPrice * TAX_MULTIPLIER): 0;
    }

    /**
     * Get the ID of this MoviePass owner as an integer
     * @return the ID of this ticket
     */
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return super.toString() + ", ID: " + id;
    }
}

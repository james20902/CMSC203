package Implementations.Assignment6;

/**
 * Extension of Ticket with values specific to employees
 *
 * @author James Pham
 */
public class Employee extends Ticket {

    int movieCount;

    /**
     * Default constructor
     * @param name name of movie
     * @param rating movie rating
     * @param day day of viewing
     * @param time time of viewing
     * @param format movie format
     * @param id account ID
     * @param movieCount flag set by MovieTicketManager to change price
     */
    public Employee(String name,
                 String rating,
                 int day,
                 int time,
                 String format, int id, int movieCount){
        super(name, rating, day, format, time, id);
        this.movieCount = movieCount;
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
        }
        if(format == Format.THREE_D){
            modifiedPrice += Adult.THREEDIM_ADDON;
        }
        return (movieCount > 1) ? (modifiedPrice * TAX_MULTIPLIER) / 2 : 0;
    }

    /**
     * Get the ID of this employee as an integer
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

package Implementations.Assignment6;

import java.text.DecimalFormat;

/**
 * A base ticket class to store various properties of movies
 *
 * @author James Pham
 */
public abstract class Ticket {

    /**
     * Enum class for representing the various movie formats
     */
    public enum Format {
        IMAX, THREE_D, NONE
    }

    public static final double TAX_MULTIPLIER =  1.096;
    public static final int SIX_PM = 18;

    Format format;
    String name;
    String rating;
    int day;
    int time;
    int id;
    double price;

    /**
     * Default constructor, fills instance variables with nil values
     */
    public Ticket(){
        this("", "", 0, "NONE", 0, 0);
    }
    /**
     * Parameterized constructor
     * @param name name of movie
     * @param rating movie rating
     * @param day day of viewing
     * @param time time of viewing
     * @param format movie format
     * @param id account ID
     */
    public Ticket(String name,
                  String rating,
                  int day,
                  String format,
                  int time,
                  int id) {
        this.name = name;
        this.rating = rating;
        this.id = id;

        //use methods for these specific instance variables to validate
        setFormat(format);
        setTime(time);
        setDay(day);
        this.price = calculateTicketPrice();
    }

    /**
     * Abstract method to be implemented by base classes to accordingly calculate ticket price
     * @return the price of the ticket
     */
    public abstract double calculateTicketPrice();

    /**
     * Abstract method to be implemented by base classes to override whether or not ID is needed
     * @return the ID as an integer
     */
    public abstract int getId();

    /**
     * To get the name of the movie associated with this ticket
     * @return the movie name
     */
    public String getMovieName(){
        return name;
    }

    /**
     * To override the name of the movie currently set
     * @param name name of the new movie
     */
    public void setMovieName(String name){
        this.name = name;
    }

    /**
     * To get the movie rating associated with this ticket
     * @return the movie rating
     */
    public String getMovieRating(){
        return rating;
    }

    /**
     * To override the rating for the movie currently set
     * @param rating the new movie rating
     */
    public void setMovieRating(String rating){
        this.rating = rating;
    }

    /**
     * Get the format of the movie playing
     * @return the format enumeration currently set
     */
    public Format getFormat(){
        return format;
    }

    /**
     * Override the format of the movie playing
     * @param format the new format as a string
     */
    public void setFormat(String format){
        switch(format) {
            case "IMAX":
                this.format = Format.IMAX;
                break;
            case "3D":
                this.format = Format.THREE_D;
                break;
            default:
                this.format = Format.NONE;
        }
    }

    /**
     * The day the movie is set to play this month
     * @return the day of the month
     */
    public int getDay(){
        return day;
    }

    /**
     * To override and validate the day the movie is set to play
     * @param day the new day of the month
     */
    public void setDay(int day){
        if(day > 31){
            this.day = 31;
        } else {
            this.day = Math.max(day, 1);
        }
    }

    /**
     * To get the time the movie is scheduled to play
     * @return the time in 24 hour format
     */
    public int getTime(){
        return time;
    }

    /**
     * To override and validate the time
     * @param time the new time in 24 hour format
     */
    public void setTime(int time){
        if(time > 23){
            this.time = 23;
        } else {
            this.time = Math.max(time, 8);
        }
    }

    /**
     * To override the currently set ID
     * @param id the new ID as an integer
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * To get the current price of the ticket
     * @return the price of the ticket
     */
    public double getPrice(){
        return price;
    }

    /**
     * To override the current price of the ticket
     * @param price the new price in USD
     */
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat priceformat = new DecimalFormat("##0.00");

        return this.getClass().getSimpleName() + ", " + format.toString() + ", Movie: " + name + ", Rating: " + rating + ", Day: " + day
                + ", Time: " + time + ", Price: $" + priceformat.format(price);
    }



}

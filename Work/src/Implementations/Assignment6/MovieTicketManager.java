package Implementations.Assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing an ArrayList to manage various tickets
 *
 * @author James Pham
 */

public class MovieTicketManager implements MovieTicketManagerInterface{

    private ArrayList<Ticket> ticketList;
    private DecimalFormat format = new DecimalFormat("##0.00");

    /**
     * Default constructor
     */
    public MovieTicketManager() {
        this.ticketList = new ArrayList<>();
    }

    /**
     * To get the total visits in a month with a given ID
     * @param id the id of the patron
     * @return the number of visits to the theater
     */
    @Override
    public int numVisits(int id) {
        int count = 0;
        for(Ticket ticket: ticketList){
            if(ticket.getId() == id)
                count++;
        }
        return count;
    }

    /**
     * To get the total number of visits to a specific movie in a month with a given ID
     * @param id the id of the patron
     * @param movie name of the movie
     * @return the number of visits to a specific movie
     */
    @Override
    public int numThisMovie(int id, String movie) {
        int count = 0;
        for(Ticket ticket: ticketList){
            if(ticket.getId() == id && ticket.getMovieName().equals(movie))
                count++;
        }
        return count;
    }

    /**
     * To get the total number of visits in a specific day of the month
     * @param id the id of patron
     * @param date the day of the month to check
     * @return the number of visits on a given day
     */
    @Override
    public int numMoviesToday(int id, int date) {
        int count = 0;
        for(Ticket ticket: ticketList){
            if(ticket.getId() == id && ticket.getDay() == date)
                count++;
        }
        return count;
    }

    /**
     * Given parameters, create a new ticket instance based on type parameter
     * @param movieN the name of the movie
     * @param rating movie rating
     * @param d date
     * @param t time
     * @param f feature
     * @param type type of patron
     * @param id id of the patron
     * @return the cost of the new ticket
     */
    @Override
    public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
        Ticket storage;
        switch(type){
            case "Adult":
                storage = new Adult(movieN, rating, d, t, f);
                break;
            case "Child":
                //invalidate ticket if not G or PG rating
                if(!rating.equals("G") && !rating.equals("PG")){
                    return 0;
                }
                storage = new Child(movieN, rating, d, t, f);
                break;
            case "Employee":
                storage = new Employee(movieN, rating, d, t, f, id, numVisits(id));
                break;
            case "MoviePass":
                storage = new Moviepass(movieN, rating, d, t, f, id,
                        numMoviesToday(id, d) > 1 || numThisMovie(id, movieN) > 1);
                if(numVisits(id) == 0){
                    storage.setPrice(Moviepass.FIRST_PRICE);
                }
                break;
            default:
                return 0;
        }
        ticketList.add(storage);
        return storage.getPrice();
    }

    /**
     * Iterate through the list to calculate the total sales for the month
     * @return the total in ticket sales
     */
    @Override
    public double totalSalesMonth() {
        double total = 0;
        for(Ticket ticket : ticketList){
            total += ticket.getPrice();
        }
        return total;
    }

    /**
     * Generate a sales report for each ticket category for management viewing
     * @return a string representing the sales report
     */
    @Override
    public String monthlySalesReport() {
        StringBuilder stringBuilder = new StringBuilder();

        //both operations are terminal, need to open two streams
        double adultSales = ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Adult")).mapToDouble(Ticket::getPrice).sum();
        double childSales = ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Child")).mapToDouble(Ticket::getPrice).sum();
        double employeeSales = ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Employee")).mapToDouble(Ticket::getPrice).sum();
        double moviePassSales = ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Moviepass")).mapToDouble(Ticket::getPrice).sum();

        int adultCount = (int)ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Adult")).count();
        int childCount = (int)ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Child")).count();
        int employeeCount = (int)ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Employee")).count();
        int moviePassCount = (int)ticketList.stream().filter(ticket -> ticket.getClass().getSimpleName().equals("Moviepass")).count();

        double totalSales = adultSales + childSales + employeeSales + moviePassSales;

        stringBuilder.append("\tMonthly Sales Report\n\n");
        stringBuilder.append("\t\t\tSales\tNumber\n");
        stringBuilder.append("ADULT:\t\t$").append(format.format(adultSales)).append("\t\t").append(adultCount).append("\n");
        stringBuilder.append("CHILD:\t\t$").append(format.format(childSales)).append("\t\t").append(childCount).append("\n");
        stringBuilder.append("EMPLOYEE:\t$").append(format.format(employeeSales)).append("\t\t").append(employeeCount).append("\n");
        stringBuilder.append("MOVIEPASS:\t$").append(format.format(moviePassSales)).append("\t\t").append(moviePassCount).append("\n\n");
        stringBuilder.append("Total Monthly Sales: $").append(format.format(totalSales));

        return stringBuilder.toString();
    }

    /**
     * To get an arraylist containing only 3D format tickets
     * @return ArrayList containg metadata for all 3D tickets
     */
    @Override
    public ArrayList<String> get3DTickets() {
        ArrayList<String> list = new ArrayList<>();
        sortByDate(ticketList);
        for(Ticket ticket : ticketList){
            if(ticket.getFormat() == Ticket.Format.THREE_D){
                list.add(ticket.toString());
            }
        }
        return list;
    }

    /**
     * To get an arraylist containing all tickets
     * @return ArrayList containg metadata for all tickets
     */
    @Override
    public ArrayList<String> getAllTickets() {
        ArrayList<String> list = new ArrayList<>();
        sortByDate(ticketList);
        for(Ticket ticket : ticketList){
            list.add(ticket.toString());
        }
        return list;
    }

    /**
     * To get an arraylist containing only MoviePass tickets
     * @return ArrayList containg metadata for all MoviePass tickets
     */
    @Override
    public ArrayList<String> getMoviePassTickets() {
        ArrayList<String> list = new ArrayList<>();
        sortById(ticketList);
        for(Ticket ticket : ticketList){
            if(ticket.getClass().getSimpleName().equals("Moviepass")){
                list.add(ticket.toString());
            }
        }
        return list;
    }

    /**
     * To read a file and parse ticket data from each line
     * @param file file to be read from
     * @throws FileNotFoundException if the given file doesn't exist
     */
    @Override
    public void readFile(File file) throws FileNotFoundException {
        Scanner filesc = new Scanner(file);
        while(filesc.hasNextLine()){
            String[] storage = filesc.nextLine().split(":");
            addTicket(storage[0],
                    storage[1],
                    Integer.parseInt(storage[2]),
                    Integer.parseInt(storage[3]),
                    storage[4],
                    storage[5],
                    Integer.parseInt(storage[6]));
        }
    }

    /**
     * To sort a given ticket arraylist in the natural order of IDs
     * @param ticketList the arraylist to be sorted
     */
    private void sortById(ArrayList<Ticket> ticketList){
        for (int j = 1; j < ticketList.size(); j++) {
            Ticket current = ticketList.get(j);
            int i = j-1;
            while ((i > -1) && (ticketList.get(i).getId() > current.getId())){
                ticketList.set(i+1, ticketList.get(i));
                i--;
            }
            ticketList.set(i+1, current);
        }
    }

    /**
     * To sort a given ticket arraylist in the natural order of days
     * @param ticketList the arraylist to be sorted
     */
    private void sortByDate(ArrayList<Ticket> ticketList){
        for (int j = 1; j < ticketList.size(); j++) {
            Ticket current = ticketList.get(j);
            int i = j-1;
            while ((i > -1) && (ticketList.get(i).getDay() > current.getDay())){
                ticketList.set(i+1, ticketList.get(i));
                i--;
            }
            ticketList.set(i+1, current);
        }
    }
}

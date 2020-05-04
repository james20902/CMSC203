import Implementations.Assignment6.MovieTicketManager;

public class Main {
    //this class is only for testing, no important code here

    public static void main(String[] args){
        MovieTicketManager ticketList = new MovieTicketManager();

        //add adults
        ticketList.addTicket("Infinity Wars", "PG13", 4,19,"NONE","Adult",0);
        ticketList.addTicket("A Quiet Place", "PG13", 2,12,"NONE","Adult",0);
        ticketList.addTicket("Black Panther", "PG13", 3,14,"3D","Adult",0);

        //add children
        ticketList.addTicket("Little Mermaid", "G", 5,19,"NONE","Child",0);
        ticketList.addTicket("Little Mermaid", "G", 2,12,"NONE","Child",0);
        ticketList.addTicket("Show Dogs", "PG", 2,14,"3D","Child",0);

        //add employees
        ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","Employee",12345);
        ticketList.addTicket("Action Point", "NR", 2,12,"NONE","Employee",23456);
        ticketList.addTicket("Book Club", "PG13", 1,13,"IMAX","Employee",45678);

        //add MoviePass members
        ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","MoviePass",22222);
        ticketList.addTicket("Deadpool", "G", 1,13,"IMAX","MoviePass",55555);
        ticketList.addTicket("Solo", "PG13", 2,12,"NONE","MoviePass",33333);

        System.out.println(ticketList.totalSalesMonth());
    }
}

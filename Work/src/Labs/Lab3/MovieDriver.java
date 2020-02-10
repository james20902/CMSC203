package Labs.Lab3;

import java.util.Scanner;

public class MovieDriver {

    Scanner scanner;

    Movie movie;

    String name;
    String rating;
    int tickets;
    char response;

    public MovieDriver(){
        scanner = new Scanner(System.in);
        movie = new Movie();
        do {
            System.out.println("Movie name? ");
            name = scanner.next();
            System.out.println("Movie rating? ");
            rating = scanner.next();
            System.out.println("Tickets sold? ");
            tickets = scanner.nextInt();

            movie.setTitle(name);
            movie.setRating(rating);
            movie.setSoldTickets(tickets);
            System.out.println(movie);
            System.out.println("Go again?");
            response = scanner.next().charAt(0);
        } while (response != 'n' && response != 'N');
        System.out.println("goodbye");
    }
}

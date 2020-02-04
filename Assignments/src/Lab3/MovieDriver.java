package Lab3;

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
        while(true){
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
            if(response == 'n' || response == 'N'){
                break;
            }
        }
        System.out.println("goodbye");
    }
}

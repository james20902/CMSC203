package Implementations.Assignment1;

import java.util.Scanner;

public class WindChill {
    /**
     * WindChill class
     *
     * Prompts user for two parameters, Temperature and wind speed. Then outputs the new expected temperature with wind speed factored in
     * Written by James Pham
     * @param args N/A
     */
    public static void main(String[] args){
        //define variables
        Scanner scanner = new Scanner(System.in);
        double temperature, windspeed;

        System.out.println("Wind chill calculator \n");
        System.out.println("Note: Temperature should be in Fahrenheit between -45 and 40, and wind speed should be between 5 and 60 mph");

        //store user variables
        System.out.print("Enter temperature(F): ");
        temperature = scanner.nextDouble();
        System.out.print("Enter wind speed(MPH): ");
        windspeed = scanner.nextDouble();

        //calculate with given equation
        //35.74 + 0.6215T - 35.75(V^0.16) + 0.4275T(V^0.16)

        System.out.println("Wind chill temperature: " +
                (35.74 + 0.6215 * temperature - 35.75 * Math.pow(windspeed, 0.16) + 0.4275 * temperature * Math.pow(windspeed, 0.16))
        + " degrees Fahrenheit");

        System.out.println("Programmer: James Pham");
    }
}

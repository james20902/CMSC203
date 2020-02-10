package Labs.Lab2;

import java.util.Scanner;

public class SphereVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program(hopefully) returns the volume of a sphere given a diameter!");
        System.out.println("diameter?");
        System.out.println("Volume: " + (4/3.) * Math.PI * Math.pow(scanner.nextDouble() / 2 , 3));
    }
}

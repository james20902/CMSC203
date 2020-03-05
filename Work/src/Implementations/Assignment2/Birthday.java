package Implementations.Assignment2;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;

/**
 * Birthday class to be used with Toy class,
 * Gives users several prompts and input on gift chosen for child
 * On their birthday
 *
 * @author James Pham
 */
public class Birthday {

    //instance variables for later use
    public static final String windowName = "Gift Chooser!";
    private static String name = "";
    private static int age = 0;
    private static double totalCost = 0;
    private static String toytype;
    private static Toy toy;
    private static String[] options = { "plushie", "book", "blocks" };

    public static void main(String[] args){
        //instance variable to be changed by user later
        boolean runLoop = true;

        System.out.println("BIRTHDAY GIFTS");

        //greeting prompt
        JOptionPane.showInternalMessageDialog(null,
            "Welcome to the Toy Company to choose gifts for young children",
            windowName,
            JOptionPane.INFORMATION_MESSAGE);

        //start loop to accept multiple gifts
        do {
            name = JOptionPane.showInputDialog("Please input the child's name");

            //input dialog always returns string so use static method to unbox
            String userInput = JOptionPane.showInputDialog("Please input the child's age");
            age = Integer.parseInt(userInput == null || userInput.equals("") ? "0" : userInput);

            //pass option parameter in to give dropdown options
            toytype = (String) JOptionPane.showInputDialog(null,
                "Choose a toy",
                windowName,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

            toy = new Toy(toytype, age);
            //check for age restriction and prompt
            if(!toy.ageOK()){
                int option = JOptionPane.showConfirmDialog(null,
                    "The suggested age for this toy is significantly different from "
                        + "your child's age, continue?",
                    windowName,
                    JOptionPane.YES_NO_OPTION);
                //if no selected, skip next calls and loop back
                if(option == JOptionPane.NO_OPTION){
                    continue;
                }
            }

            //prompt for card/balloon
            int cardcheck = JOptionPane.showConfirmDialog(null,
                "Would you like a card to go along with it?",
                windowName,
                JOptionPane.YES_NO_OPTION);
            if(cardcheck == JOptionPane.YES_OPTION){
                toy.addCard("yes");
            }

            int ballooncheck = JOptionPane.showConfirmDialog(null,
                "Would you like a balloon to go along with it?",
                windowName,
                JOptionPane.YES_NO_OPTION);
            if(ballooncheck == JOptionPane.YES_OPTION){
                toy.addCard("yes");
            }

            //add to total cost
            totalCost += toy.getCost();
            //print to console for this child
            System.out.println("The gift for " + name + " who is " + age + " years old is " + toytype
                + " which is " + getFormattedCurrency(toy.getCost()));

            //change runLoop condition based on
            runLoop = JOptionPane.showConfirmDialog(null,
                "Would you like another toy?",
                windowName,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        } while (runLoop);

        /*
            Program footer text
            Math.random generates a decimal from 0 to 1, so to get a specific range add the bottom
            range and multiply by the top range
         */
        System.out.println("The total cost of your order is " + getFormattedCurrency(totalCost) + ", "
            + "Order number " + (10000 + (int)(Math.random() * 99999)));
        System.out.println("Programmer: James Pham");
    }

    private static String getFormattedCurrency(double original){
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(original);
    }
}

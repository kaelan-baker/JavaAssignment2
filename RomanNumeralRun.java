package RomanNumeral;

import java.util.Scanner;

public class RomanNumeralRun {
    public static void main(String[] args) {
        //set default variables
        Scanner keyboard = new Scanner(System.in);
        String choice = "";

        //using while to allow the user to quit with "X"
        while (!choice.equals("X")) {

            //ask user what they want to input
            System.out.printf(
                    "Choose whether you are inputting an INTEGER(I/i) or ROMAN NUMERAL(R/r) quit with (X/x) : ");
            choice = keyboard.next().toUpperCase();

            //check that the input is one of the three choices
            while (!choice.equals("I") && !choice.equals("R") && !choice.equals("X")) {
                System.out.printf("The choice you entered was not \"I\" or \"R\" or \"X\" please try again : ");
                choice = keyboard.next().toUpperCase();
            }

            
            //if the user entered I, then return the String Value
            if (choice.equals("I")) {
                System.out.printf(
                        "You chose to convert an INTEGER to a roman numeral. \n Please enter the integer you want converted. : ");
                int inputInt = keyboard.nextInt();
                //checking the the number entered is within the bounds of reason
                while (inputInt > 3999 || inputInt <= 0) {
                    System.out.printf(
                            "The choice you entered was not a number that can be converted. \nPlease try again : ");
                    inputInt = keyboard.nextInt();
                }
                //print out the final String
                RomanNumeral convertint = new RomanNumeral(inputInt);
                System.out.printf("\n");
                System.out.printf("Converting %d\n", inputInt);
                System.out.printf("The converted numeral is : %s\n", convertint.getStrValue());


            //if the user entered R, then return the Integer Value
            } else if (choice.equals("R")) {

                System.out.printf(
                        "You chose to convert a ROMAN NUMERAL to an integer. \n please enter the roman numeral you want converted. : ");
                String inputStr = keyboard.next().toUpperCase();
                RomanNumeral convertStr = new RomanNumeral(inputStr);
                //checking the the string entered is within the bounds of reason
                while ((convertStr.getIntegerValue() > 3999) || (convertStr.getIntegerValue() <= 0)) {
                    System.out.printf(
                            "The choice you entered was not a string that can be converted. \nPlease try again : ");
                    inputStr = keyboard.next().toUpperCase();
                    convertStr.setStrValue(inputStr);
                }
                //printing out the final integer for the Roman Numeral entered
                System.out.printf("\n");
                System.out.printf("Converting %s\n", inputStr);
                System.out.printf("The converted numeral is : %d\n", convertStr.getIntegerValue());


            //allowing the user to quit the program
            } else {
                System.out.println("Have a great day!");
            }

        //loop back to the top and go again
        }

        keyboard.close();
    }
}

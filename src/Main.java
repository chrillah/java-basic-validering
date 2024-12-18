import java.awt.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Global variables
        String fName;
        String lName;
        String address;
        String streetNumber;
        String socialNumber;

        Scanner userInput = new Scanner(System.in);

        /*
        do{
            System.out.println("Enter first name: ");
            fName = userInput.nextLine().trim();
        }
        while (!validateName(fName));

        do{
            System.out.println("Enter last name: ");
            lName = userInput.nextLine().trim();
        }
        while (!validateName(lName));

        System.out.println(fName + " " + lName);
         */

        /*
        do{
            System.out.println("Enter street name");
            address = userInput.nextLine();
        }
        while(!validateAddress(address));

        System.out.println(address);

         */

        /*
        do{
            System.out.println("Enter street number");
            streetNumber = userInput.nextLine().trim();
        }
        while(!validateStreetNumber(streetNumber));
        System.out.println(streetNumber);
         */


        do{
            // System.out.println("Enter social number: ");
            // socialNumber = userInput.nextLine();
            socialNumber = "8112189876";
        }
        while(!validateSocialNumber(socialNumber));

        System.out.println(socialNumber);





    }

    public static boolean checkForStreck(String name){
        int checkStreck = 0;

        if(name.charAt(0) == '-' || name.charAt(name.length() -1 ) == '-'){
            checkStreck++;
        }

        return checkStreck <= 0;
    }

    public static boolean checkLength(String name){
        return name.length() >= 2;
    }

    public static boolean checkForNumbers(String text){
        int checkNumbers = 0;

        for(int i = 0; i < text.length(); i++){
           if(Character.isDigit(text.charAt(i))){
               checkNumbers++;
           }
        }
        return checkNumbers <= 0;
    }

    public static boolean checkDigits(String numbers){
        if(!checkForLetters(numbers)){
            return false;
        }
        if(numbers.length() != 10){
            System.out.println("Too short");
            return false;
        }
        return true;
    }
    public static boolean checkForLetters(String numbers){
        try{
            Long.parseLong(numbers);
            return true;
        }
        catch (Exception e){
            System.out.println("No letters!");
            return false;
        }
    }
    public static void checkLastDigit(String stringNumbers){

        int[] nArray = new int[9];
        int[] calculateArray = new int[9];
        for (int i = 0; i < stringNumbers.length() -1; i++) {
            nArray[i] = Integer.parseInt(String.valueOf(stringNumbers.charAt(i)));
        }
        for(int i = 0; i < nArray.length; i++){
            if(i % 2 == 0){
                calculateArray[i] = nArray[i]* 2;
            } else {
                calculateArray[i] = nArray[i];
            }
        }
    }

    public static boolean validateName(String name){
        int check = 0;
        if(!checkLength(name)){
            System.out.println("Too short, must have at least 2 letters");
            check++;
        }
        if(!checkForNumbers(name)){
            System.out.println("No numbers, I don't care if you are Elon Snusk child");
            check++;
        }
        if(!checkForStreck(name)){
            System.out.println("What the heck! No streck!");
            check++;
        }
        return check == 0;
    }

    public static boolean validateAddress(String address){
        int check = 0;
        if(!checkForNumbers(address)){
            System.out.println("No numbers, I don't care if you are Elon Snusk child");
            check++;
        }
        return check == 0;
    }

    public static boolean validateStreetNumber(String streetNumber){
        int check = 0;
        for (int i = 0; i < streetNumber.length() - 1; i++){
            if(!Character.isDigit(streetNumber.charAt(i))){
                check++;
            }
        }
        if(check > 0){
            System.out.println("NOOO LETTERS!! You can have one letter at the end");
        }

        return check == 0;
    }

    public static boolean validateSocialNumber(String socialNumber){
        if(checkDigits(socialNumber)) {
            String firstDigit = socialNumber.substring(0,6);
            String lastDigit = socialNumber.substring(6);
            checkLastDigit(socialNumber);
            socialNumber = firstDigit+"-"+lastDigit;
            System.out.println(socialNumber);
            return true;
        }
        return false;
    }
}

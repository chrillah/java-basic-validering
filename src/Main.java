import java.awt.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Global variables
        String fName = "";
        String lName = "";
        String address = "";
        String streetNumber = "";
        String socialNumber = "";

        String[] personalInformation = new String[5];

        Scanner userInput = new Scanner(System.in);

        int choice = 0;
        do{
            try {
                System.out.println("LUHN - form");
                System.out.println("Choose:");
                System.out.println("1) Input personal information");
                System.out.println("2) View personal information");
                System.out.println("3) Exit LUHN");
                choice = userInput.nextInt();

                switch(choice){
                    case 1 -> input(fName, lName, address, streetNumber, socialNumber, userInput);
                    case 2 -> display(personalInformation);
                    case 3 -> System.out.println("Good bye");
                    default -> System.out.println("Wrong input");
                }
            }
            catch(Exception e) {
                System.out.println("Wrong input");
                userInput.nextLine();
            }
        }while(choice !=3 );


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


        /*
        do{
            System.out.println("Enter social number: ");
            socialNumber = userInput.nextLine();
        }
        while(!validateSocialNumber(socialNumber));


        socialNumber = format(socialNumber);
        System.out.println(socialNumber);
        */

    }

    public static void input(String fName, String lName, String adress, String streetNumber, String socialNumber, Scanner userInput){
        userInput.nextLine();
        nameInput(fName, lName, userInput);
        addressInput(adress, userInput);
        streetNumberInput(streetNumber, userInput);
        socialNumberInput(socialNumber, userInput);
    }

    public static void display(String[] personalInformation){
        int check = 0;
        if (personalInformation.length == 0){
            System.out.println("Nothing to display");
        }
        else{
            for (String information : personalInformation) {
                if(information != null){
                    System.out.println(information);
                }
                else{
                    check++;
                }
            }
        }
        if(check>0){
            System.out.println("Nothing to see");
        }
    }

    public static void nameInput(String fName, String lName, Scanner userInput){
        String answer = "";
        do{
            try {
                do{
                    System.out.println("Enter first name: ");
                    fName = userInput.nextLine().trim();
                }
                while (!validateName(fName, userInput));
                System.out.println(fName);
                do{
                    System.out.println("Enter last name: ");
                    lName = userInput.nextLine().trim();
                }
                while (!validateName(lName, userInput));
                System.out.println(lName);
                answer = "N";
            }
            catch(Exception e) {
                System.out.println("Wrong input");
                System.out.println("Do it again? Y / N");
                answer = userInput.nextLine();
                userInput.nextLine();
            }
        }while(!answer.equals("N"));
    }

    public static void addressInput(String address, Scanner userInput){
        do{
            System.out.println("Enter street name");
            address = userInput.nextLine();
        }
        while(!validateAddress(address));

        System.out.println(address);
    }

    public static void streetNumberInput(String streetNumber, Scanner userInput){
        do{
            System.out.println("Enter street number");
            streetNumber = userInput.nextLine().trim();
        }
        while(!validateStreetNumber(streetNumber));
        System.out.println(streetNumber);
    }

    public static void socialNumberInput(String socialNumber, Scanner userInput){
        do{
            System.out.println("Enter social number: ");
            socialNumber = userInput.nextLine();
        }
        while(!validateSocialNumber(socialNumber));


        socialNumber = format(socialNumber);
        System.out.println(socialNumber);
    }

    public static String format(String socialNumber){
        String firstDigit = socialNumber.substring(0,6);
        String lastDigit = socialNumber.substring(6);
        return firstDigit+"-"+lastDigit;
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
        if(numbers.length() < 10){
            System.out.println("Too short");
            return false;
        }
        if(numbers.length() > 10){
            System.out.println("Too long");
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
    public static boolean checkLastDigit(String stringNumbers){

        int[] tempArray = new int[stringNumbers.length() -1];
        int[] calculateArray = new int[stringNumbers.length() -1];
        StringBuilder tempString = new StringBuilder();
        int calculateLastDigit = 0;
        int lastDigit = 0;
        int checkLastDigit = Integer.parseInt(String.valueOf(stringNumbers.charAt(stringNumbers.length()-1)));

        for (int i = 0; i < stringNumbers.length() -1; i++) {
            tempArray[i] = Integer.parseInt(String.valueOf(stringNumbers.charAt(i)));
        }
        for(int i = 0; i < tempArray.length; i++){
            if(i % 2 == 0){
                calculateArray[i] = tempArray[i]* 2;
            } else {
                calculateArray[i] = tempArray[i];
            }
        }

        for (int number : calculateArray){
            tempString.append(number);
        }

        for(int i = 0; i < tempString.length(); i++){
            calculateLastDigit += Integer.parseInt(String.valueOf(tempString.charAt(i)));
        }

        if(calculateLastDigit % 10 != 0){
            int closestTen = calculateLastDigit + (10 - calculateLastDigit % 10);
            lastDigit = closestTen - calculateLastDigit;
        }

        if(checkLastDigit != lastDigit){
            System.out.println("Not valid");
            return false;
        }

        return true;
    }

    /*
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

     */

    public static boolean validateName(String name, Scanner userInput){
        String answer = "";
        String msg = "Continue? Y / N";
        do{
            try{
                if(!checkLength(name)){
                    System.out.println("Too short, must have at least 2 letters");
                    System.out.println(msg);
                    answer = userInput.nextLine();
                }
                if(!checkForNumbers(name)){
                    System.out.println("No numbers, I don't care if you are Elon Snusk child");
                    System.out.println(msg);
                    answer = userInput.nextLine();
                }
                if(!checkForStreck(name)){
                    System.out.println("What the heck! No streck!");
                    System.out.println(msg);
                    answer = userInput.nextLine();
                }
            }
            catch (Exception e){
                System.out.println("Use Y or N");
            }
        }while(!answer.equals("N"));

        return answer.equals("N");

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
            if(checkLastDigit(socialNumber)){
                return true;
            }
        }
        return false;
    }
}

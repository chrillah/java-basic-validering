import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Global variables
        String fName;
        String lName;
        String address;
        int streetNumber;
        int socialNumber;

        validate();

    }

    public static void validate(){
        Scanner input = new Scanner(System.in);
/*
        int choice = 0;
        Scanner menu = new Scanner(System.in);

        do{
            try {
                choice = 0;
                System.out.println("MENU BITCH");
                System.out.println("1) Option 1");
                System.out.println("2) Option 2");
                System.out.println("3) Exit 3");
                System.out.println("Enter your choice bitch");
                choice = menu.nextInt();

                switch(choice){
                    case 1 -> System.out.println("Choice 1");
                    case 2 -> System.out.println("Choice 2");
                    case 3 -> System.out.println("Exiting bitch");
                    default -> System.out.println("Invalid choice bitch try again");
                }
            } catch(InputMismatchException e){
                System.out.println("No po, otra vez");
                menu.nextLine();
            }


        } while(choice != 3);
*/

        String fName = "";
        String lName = "";
        boolean validated = false;

        // Check first name
        while(!validated){
            System.out.println("Input first name: ");
            fName = input.nextLine().trim();
            validated = check(fName);
        }

        // reset validation
        validated = false;

        // check last name
        while(!validated){
            System.out.println("Input last name: ");
            lName = input.nextLine().trim();
            validated = check(lName);
        }
        System.out.println(fName + " " + lName);

    }

    public static boolean check(String name){
        boolean validated = false;
        int checkNumbers = 0;
        int checkLetters = 0;
        // int checkBindesStreck = 0;

        for(int i = 0; i < name.length(); i++){
            if(!Character.isDigit(name.charAt(i)) && name.charAt(0) != '-' && name.charAt(name.length() -1) != '-'){
                checkLetters++;
            }
            else {
                checkNumbers++;
            }
        }
        if(checkNumbers <= 0 && checkLetters >= 2){
            validated = true;
        } else {
            System.out.println("No po");
        }

        return validated;
    }
}

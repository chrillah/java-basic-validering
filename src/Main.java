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
        System.out.println("Input first name: ");
        String fName = input.nextLine().trim();
        System.out.println("Input last name: ");
        String lName = input.nextLine().trim();


        System.out.println(fName+" "+lName);
    }
}

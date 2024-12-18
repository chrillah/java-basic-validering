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
        System.out.println("Input first name: ");
        String fName = input.nextLine().trim();
         */

        boolean validated = false;

        while(!validated){
            System.out.println("Input first name: ");
            String fName = "";
            fName = input.nextLine().trim();
            int checkNumbers = 0;
            int checkLetters = 0;

            for(int i = 0; i < fName.length(); i++){
                if(!Character.isDigit(fName.charAt(i))) {
                    System.out.println("Good");
                } else {
                    System.out.println("No diggity");
                    checkNumbers++;
                }
            }
            if(checkNumbers <= 0){
                validated = true;
            } else {
                System.out.println("No po");
            }
        }




        /*
        System.out.println("Input last name: ");
        String lName = input.nextLine().trim();


        System.out.println(fName+" "+lName);
         */
    }
}

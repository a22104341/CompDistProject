import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        /* Initiialize all the Variables and Lists */
        Functions.start();

        /*input
        Functions.dia = day;
        Functions.mes = month;
        Functions.ano = year;
        Functions.horadeInicio=startHour;
        Functions.horaFim = endHour;
        Functions.user = email;
        */
        //CREATE BUFFREADER
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String input;
        String password;
        String email="";

        if (!Functions.loggedIn) {
            /* Login or register? */
            System.out.println("Do you wish to Login or Register? \n 1 - Login \n 2 - Register");
            input = reader.readLine();
            char thisInput = '0';
            if (input != null) {
                thisInput = input.charAt(0);
            } else {
                System.out.println("Invalid input");
            }
            /* Check if input is correct */
            if (!(thisInput == '1' || thisInput == '2')) {
                System.out.println("Invalid input");
            }

            // Reading data using readLine
            System.out.println("Please type in your email:");
            input = reader.readLine();

            if (thisInput == '1') {
                /* Login */
                if (input != null && !User.user_verificarDisponibilidade(input)){
                    email = input;
                    System.out.println("Please type in your password:");
                    input = reader.readLine();
                    if(input != null && !User.verifyLogin(email, input)){
                        System.out.println("Incorrect login credentials!");
                    }
                }
            } else {
                /* Register */
                /* Check if email already is registered */
                if (input != null && User.user_verificarDisponibilidade(input)) {

                    //Register Section
                    email = input;

                    /* Email-Format Check */
                    if (!(email.length() < 254)) {
                        System.out.println("Email is too long");
                    }

                    /* @ Checks */
                    int position = 0;
                    if (email.contains("@")) {
                        /* Check how many @'s */
                        int counter = 0;
                        for (int i = 0; i < email.length(); i++) {
                            if (email.charAt(i) == '@' && (i != 0 && i != email.length() - 1)) {
                                counter++;
                                position = i;
                            } else {
                                /* @ cant be in 1st or last position */
                                System.out.println("You can't have the @ be in the first or last position in your email");
                            }
                        }
                        if (counter != 1) {
                            /* Too many @'s */
                            System.out.println("You can only have 1 @ in your email");
                        }
                    } else {
                        /* Missing an @ */
                        System.out.println("Incorrect Format, you need to have and @ in your email");
                    }
                    /* Check for Spaces */
                    if (email.contains(" ")) {
                        System.out.println("The email can't contain a space");
                    }

                    /* . Checks */
                    /* Save the start and Endsection */
                    String prefix = email.substring(0, position);
                    String endSectionEmail = email.substring(position + 1);

                    /* Check 1st and last position of email for weird symbols */
                    char char_pos0 = email.charAt(0);
                    char char_posEnd = email.charAt(email.length() - 1);
                    char char_posEndMin1 = email.charAt(email.length() - 2);

                    if (!endSectionEmail.contains(".")) {
                        System.out.println("After the @ you need a .");
                    }

                    /* 1st pos Checks */
                    if (!(Character.isLetter(char_pos0) || Character.isDigit(char_pos0))) {
                        System.out.println("The email needs to begin with a Letter or Digit");
                    }

                    /* Last 2 positions Checks */
                    if (!(Character.isLetter(char_posEnd) || Character.isLetter(char_posEndMin1))) {
                        System.out.println("The last 2 positions of your email need to be Letters");
                    }

                    /* Check if they not two Symbols's in a row + automatically checks if there is a symbol b4/after the @*/
                    char b4Char = email.charAt(1);
                    for (int i = 2; i < email.length() - 1; i++) {
                        char currentChar = email.charAt(i);
                        /* Checks: both letter, both digit, 1digit 1letter, 1letter 1 digit */
                        if (!((Character.isLetter(b4Char) && Character.isLetter(currentChar)) || (Character.isDigit(b4Char) && Character.isDigit(currentChar))
                                || (Character.isLetter(b4Char) && Character.isDigit(currentChar)) || (Character.isDigit(b4Char) && Character.isLetter(currentChar)))) {
                            System.out.println("The email can't have two Symbols following each other");
                        }
                        b4Char = currentChar;
                    }
                } else {
                    System.out.println("Email already in use, use a different email");
                }
                /* Password Section */
                System.out.println("Please pick your password here:");
                input = reader.readLine();
                if (input != null) {
                    password = input;
                    /* length Check */
                    if (!(password.length() >= 8)) {
                        System.out.println("Password too short, needs to contain at least 8 characters");
                    }
                    /* Stuff it needs to contain */
                    boolean special = false;
                    boolean upper = false;
                    boolean lower = false;
                    boolean digit = false;

                    boolean passwordApproved = false;

                    for (int i = 0; i < password.length(); i++) {
                        char thisCharacter = password.charAt(i);
                        if (Character.isLetter(thisCharacter)) {
                            if (Character.isLowerCase(thisCharacter)) {
                                lower = true;
                            } else {
                                upper = true;
                            }
                        } else if (Character.isDigit(thisCharacter)) {
                            digit = true;
                        } else {
                            special = true;
                        }

                        if (special && upper && lower && digit) {
                            passwordApproved = true;
                            break;
                        }
                    }
                    if (!passwordApproved){
                        System.out.println("Password needs to contain at least 1 of each: Lowercase, Uppercase, Digit, Special Character");
                    }

                    System.out.println("Retype your password here:");
                    input = reader.readLine();
                    if (input != null){
                        if (input.equals(password)){
                            /* Locale Root is good practice */
                            User.register(email, password);
                        }else {
                            System.out.println("Password incorrect, retype password");
                        }
                    }
                }
            }

            Functions.loggedIn = true;
        }

        /* After Login Steps */
    }
}
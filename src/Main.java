import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //variaveis do Functions

    /* Define variables that won't change */
    static final int max2 = 0;
    static final int max3 = 1;
    static final int max4 = 2;


    static final int day = 0;
    static final int month = 1;
    static final int year = 2;
    static final int startHour = 3;
    static final int endHour = 4;
    static final int idSombra = 5;
    static final int email = 5;

    /*
    static final int praiaASombrinhas2 = 10;
    static final int praiaASombrinhas3 = 5;
    static final int praiaASombrinhas4 = 5;
    static final int praiaBSombrinhas2 = 5;
    static final int praiaBSombrinhas3 = 5;
    static final int praiaBSombrinhas4 = 1;
    static final int praiaCSombrinhas2 = 10;*/

    /* Array com os numeros das sombrinhas */

    static final int[] max2A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    static final int[] max3A = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    static final int[] max4A = new int[]{16, 17, 18, 19, 20};

    static final int[] max2B = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    static final int[] max3B = new int[]{6, 7, 8, 9, 10, 11};

    static final int[] max4B = new int[]{11};

    static final int[] max2C = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    /* Sombrinha Lists */
    static Sombrinha[][] praia_A;
    static Sombrinha[] max2_A;
    static Sombrinha[] max3_A;
    static Sombrinha[] max4_A;
    static Sombrinha[][] praia_B;
    static Sombrinha[] max2_B;
    static Sombrinha[] max3_B;
    static Sombrinha[] max4_B;
    static Sombrinha[][] praia_C;
    static Sombrinha[] max2_C;

    static int used = 0;
    static String user = "";
    static int dia = 0;
    static int mes = 0;
    static int ano = 0;
    static int horadeInicio = 0;
    static int horaFim = 0;
    static String idSombrinha = "";
    static String praia = "";
    static int maxPessoas = 0;
    static boolean loggedIn = false;


    //Variaveis do USER


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
        String email = "";

        if (!Main.loggedIn) {
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
                if (input != null && !Functions.user_verificarDisponibilidade(input)) {
                    email = input;
                    System.out.println("Please type in your password:");
                    input = reader.readLine();
                    if (input != null && !Functions.user_verifyLogin(email, input)) {
                        System.out.println("Incorrect login credentials!");
                    }
                }
            } else {
                /* Register */
                /* Check if email already is registered */
                if (input != null && Functions.user_verificarDisponibilidade(input)) {

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
                    if (!passwordApproved) {
                        System.out.println("Password needs to contain at least 1 of each: Lowercase, Uppercase, Digit, Special Character");
                    }

                    System.out.println("Retype your password here:");
                    input = reader.readLine();
                    if (input != null) {
                        if (input.equals(password)) {
                            /* Locale Root is good practice */
                            Functions.user_register(email, password);
                        } else {
                            System.out.println("Password incorrect, retype password");
                        }
                    }
                }
            }

            Main.loggedIn = true;
        }

        /* After Login Steps */
        /* which operation? */

        System.out.println("Which operation do you wish to do? \n" +
                "Pick the correct number for the related operation:\n" +
                "1 - Reserve Umbrella\n" +
                "2 - Cancel Umbrella\n" +
                "3 - List Umbrellas\n" +
                "4 - Logout\n" +
                "Exit - If you type in exit at any stage of the process, you will be redirected to this question.");

        /* 1 - Needs to know amnt of people */
        /* 2 - Just list the umbrellas from that Functions.*/
        /* 1 & 3 - ask for day/Hour... + which beach */
        /* 4 - Ask: Are you sure you wish to logout? */

        input = reader.readLine().trim();
        String day, month, year, startHour, endHour;
        int amntPpl;
        switch (input) {

            case "1":

                /* Reserve umbrella */

                System.out.println("How many people will be going to the beach with you?");
                input = reader.readLine().trim();
                if (Character.isDigit(input.charAt(0))) {
                    Functions.praia_quantidadePessoasSombrinha(Integer.parseInt(input));
                } else {
                    System.out.println("Invalid Input");
                }

                System.out.println("What is the beach you want to go to?\n A\nB\nC");
                input = reader.readLine().trim();
                switch (input) {
                    case "A", "B", "C":
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                Main.praia = input;

                System.out.println("Which day do you want to go to the beach?");
                day = reader.readLine().trim();
                System.out.println("What month you want to go to the beach?");
                month = reader.readLine().trim();
                System.out.println("What year you want to go to the beach?");
                year = reader.readLine().trim();

                System.out.println("At what time do you wish to go? Opening times: 8-20");
                startHour = reader.readLine().trim();
                int start = Integer.parseInt(startHour);
                if (!(start >= 8 && start < 20)) {
                    System.out.println("Invalid Option");
                }

                System.out.println("When do you want to leave the beach? 8-20");
                endHour = reader.readLine().trim();
                int end = Integer.parseInt(endHour);
                if (!(end > 8 && end <= 20)) {
                    System.out.println("Invalid Option");
                }

                /* Now we need to check, which umbrella's are valid options for the amount of people */
                /* We need a function, that returns an Array, with only UmbrellaNrs, that are valid for this Functions.*/
                /* thisArray = CallsTheFunction */
                int theFileNr = -1;
                int[] thisArray = Functions.praia_umbrellasNr();
                if (thisArray != null) {
                    for (int i = 0; i < thisArray.length; i++) {
                        String fileName = Main.praia + thisArray[i] + ".txt";
                        if (Functions.praia_verificarDisponibilidade(fileName)) {
                            theFileNr = thisArray[i];

                            System.out.println("This Umbrella: " + Main.praia + thisArray[i] + "will be reserved in your name");
                            break;
                        }
                    }
                }

                if (theFileNr != -1) {
                    //escreve no ficheiro praia
                    Functions.praia_reservarSombrinha(Functions.pathGetter(Main.praia + theFileNr), Functions.write_combiner(day, month, year, startHour, endHour, email));
                    Functions.user_reservarSombrinha(email, Functions.write_combiner(day, month, year, startHour, endHour, Main.praia + theFileNr));
                } else {
                    System.out.println("Unfortunately, there are no Umbrellas available for your specifications");
                }


            case "2":

                /* Cancel Umbrella */

                String file = Functions.pathGetter(Main.user + ".txt");
                String[][] thisUserFile = Functions.user_listarSombrinhas(file);

                System.out.println("Which of these reservations, do you wish to cancel?");
                input = reader.readLine().trim();

                /* check if its a valid option */
                if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= thisUserFile.length)) {
                    System.out.println("Invalid input");
                }

                String id = thisUserFile[Integer.parseInt(input) - 1][Main.idSombra];

                Functions.user_cancelarSombrinha( Integer.parseInt(input) - 1, thisUserFile, email);

            case "3":

                /* List umbrella's on beach */

                System.out.println("What is the beach you want to go to?\n A\nB\nC");
                input = reader.readLine().trim();
                switch (input) {
                    case "A", "B", "C":
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                Main.praia = input;

                System.out.println("Which day do you want to go to the beach?");
                day = reader.readLine().trim();
                System.out.println("What month you want to go to the beach?");
                month = reader.readLine().trim();
                System.out.println("What year you want to go to the beach?");
                year = reader.readLine().trim();

                System.out.println("At what time do you wish to go? Opening times: 8-20");
                startHour = reader.readLine().trim();
                start = Integer.parseInt(startHour);
                if (!(start >= 8 && start < 20)) {
                    System.out.println("Invalid Option");
                }

                System.out.println("When do you want to leave the beach? 8-20");
                endHour = reader.readLine().trim();
                end = Integer.parseInt(endHour);
                if (!(end > 8 && end <= 20)) {
                    System.out.println("Invalid Option");
                }

                String date = day + "/" + month + "/" + year;

                Functions.praia_listarSombrinhas(date, start, end);

            case "4":
                /* Logout */
                Main.loggedIn = false;
                break;

            case "Exit":
                break;
            default:
                System.out.println("Invalid option try again!");

        }

        // Send user back to the loginScreen
        if (!Main.loggedIn){
            //break;
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class FunctionsClient {

    public void comeca() throws Exception {
        String addServerURL = "rmi://192.168.56.101/FunctionsServer";
        FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
        try {

            while (true) {
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

            //variaveis do Functions

            /* Define variables that won't change */

            String praia = addServerIntf.getpraia();
            int day1 = addServerIntf.getday();
            int month1 = addServerIntf.getmonth();
            int year1 = addServerIntf.getyear();
            int startHour1 = addServerIntf.getstartHour();
            int endHour1 = addServerIntf.getendHour();
            int idSombra = addServerIntf.getidSombra();
            int email1 = addServerIntf.getemail1();


            /* Array com os numeros das sombrinhas */

            int[] max2A = addServerIntf.getmax2A();

            int[] max3A = addServerIntf.getmax3A();

            int[] max4A = addServerIntf.getmax4A();

            int[] max2B = addServerIntf.getmax2B();

            int[] max3B = addServerIntf.getmax3B();

            int[] max4B = addServerIntf.getmax4B();

            int[] max2C = addServerIntf.getmax2C();
            String user = addServerIntf.getuser();
            int dia = addServerIntf.getdia();
            int mes = addServerIntf.getmes();
            int ano = addServerIntf.getano();
            int horadeInicio = addServerIntf.gethoradeInicio();
            int horaFim = addServerIntf.gethoraFim();
            String idSombrinha = addServerIntf.getidSombrinha();
            int maxPessoas = addServerIntf.getmaxPessoas();
            boolean loggedIn = addServerIntf.getloggedIn();





            /* Initiialize all the Variables and Lists */
            addServerIntf.start();


            //CREATE BUFFREADER
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));



                String input;
                String password;
                String email = "";

                if (!loggedIn) {
                    /* Login or register */
                    char thisInput = '0';
                    while (true) {
                        System.out.println("Do you wish to Login or Register? \n 1 - Login \n 2 - Register");
                        input = reader.readLine();

                        if (input != null) {
                            thisInput = input.trim().charAt(0);

                            /* Check if input is correct */
                            if (!(thisInput == '1' || thisInput == '2')) {
                                System.out.println("Invalid input");
                            }
                            break;
                        } else {
                            System.out.println("Invalid input");
                        }
                    }

                    boolean reaskEmail = true;
                    while (reaskEmail) {
                        System.out.println("Please type in your email:");
                        input = reader.readLine();

                        if (thisInput == '1') {

                            /* give him 3 attempts at getting the password right */
                            int counter = 0;
                            while (counter < 3) {
                                /* Login */
                                if (input != null && !addServerIntf.user_verificarDisponibilidade(input)) {
                                    email = input;
                                    System.out.println("Please type in your password:");
                                    String input2 = reader.readLine();
                                    if (input2 != null && !addServerIntf.user_verifyLogin(email.trim(), input2)) {
                                        System.out.println("Incorrect login credentials!(Attempt " + counter + "/3 )");
                                    } else {
                                        System.out.println("You are logged in!");
                                        reaskEmail = false;
                                        break;
                                    }
                                }
                                counter++;
                            }
                            if (reaskEmail) {
                                break;
                            }

                        } else {
                            while (true) {
                                /* Register */
                                /* Check if email already is registered */
                                if (input != null && addServerIntf.user_verificarDisponibilidade(input)) {

                                    //Register Section
                                    email = input.trim();

                                    /* Email-Format Check */
                                    if (!(email.length() < 255)) {
                                        System.out.println("Email is too long (maximum 254 Characters)");
                                        break;
                                    }

                                    /* @ Checks */
                                    int position = 0;
                                    if (email.contains("@")) {
                                        /* Check how many @'s */
                                        int counter = 0;
                                        boolean cutItShort = false;
                                        for (int i = 0; i < email.length(); i++) {
                                            if (email.charAt(i) == '@' && (i != 0 && i != email.length() - 1)) {
                                                counter++;
                                                position = i;
                                            } else {
                                                /* @ cant be in 1st or last position */
                                                System.out.println("You can't have the @ be in the first or last position of your email");
                                                cutItShort = true;
                                                break;
                                            }

                                            if (counter > 1) {
                                                /* Too many @'s */
                                                System.out.println("You can only have 1 @ in your email");
                                                cutItShort = true;
                                                break;
                                            }
                                        }
                                        if (cutItShort) {
                                            break;
                                        }

                                    } else {
                                        /* Missing an @ */
                                        System.out.println("Incorrect Format, you need to have at least 1 @ in your email");
                                        break;
                                    }


                                    /* Check for Spaces */
                                    if (email.contains(" ")) {
                                        System.out.println("The email can't contain a space");
                                        break;
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
                                        break;
                                    }

                                    /* 1st pos Checks */
                                    if (!(Character.isLetter(char_pos0) || Character.isDigit(char_pos0))) {
                                        System.out.println("The email needs to begin with a Letter or Digit");
                                        break;
                                    }

                                    /* Last 2 positions Checks */
                                    if (!(Character.isLetter(char_posEnd) || Character.isLetter(char_posEndMin1))) {
                                        System.out.println("The last 2 positions of your email need to be Letters");
                                        break;
                                    }

                                    /* Check if they not two Symbols's in a row + automatically checks if there is a symbol b4/after the @*/
                                    char b4Char = email.charAt(1);
                                    boolean cutItShort = false;
                                    for (int i = 2; i < email.length() - 1; i++) {
                                        char currentChar = email.charAt(i);
                                        /* Checks: both letter, both digit, 1digit 1letter, 1letter 1 digit */
                                        if (!((Character.isLetter(b4Char) && Character.isLetter(currentChar)) || (Character.isDigit(b4Char) && Character.isDigit(currentChar))
                                                || (Character.isLetter(b4Char) && Character.isDigit(currentChar)) || (Character.isDigit(b4Char) && Character.isLetter(currentChar)))) {
                                            System.out.println("The email can't have two Symbols following each other");
                                            cutItShort = true;
                                            break;
                                        }
                                        b4Char = currentChar;
                                    }
                                    if (cutItShort) {
                                        break;
                                    }

                                } else {
                                    System.out.println("Email already in use, use a different email");
                                    break;
                                }
                            }

                            /* reasking password Section */
                            boolean reaskPw = true;
                            while (reaskPw) {
                                while (true) {
                                    /* Password Section */
                                    System.out.println("Please pick your password here:");
                                    input = reader.readLine();
                                    if (input != null) {
                                        password = input;
                                        /* length Check */
                                        if (!(password.length() >= 8)) {
                                            System.out.println("Password too short, needs to contain at least 8 characters");
                                            break;
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
                                            break;
                                        }

                                        /* Make em Retype the Password 3 times */
                                        int counter = 0;
                                        while (counter < 3) {
                                            System.out.println("Retype your password here:");
                                            input = reader.readLine();
                                            if (input != null) {
                                                if (input.equals(password)) {
                                                    /* Locale Root is good practice */
                                                    addServerIntf.user_register(email, password);
                                                    reaskPw = false;
                                                    break;
                                                } else {
                                                    System.out.println("Password incorrect, retype password(Attempt " + counter + "/3)");
                                                }
                                            }
                                            counter++;
                                        }

                                        /* if password was wrong 3 times, they gotta type in their email and Password AGAIN*/
                                        if (!reaskPw) {
                                            reaskEmail = false;
                                        }
                                        break;
                                    }
                                }
                            } /* reaskPW */

                        }

                    } /* reaskEmail */
                    loggedIn = true;
                }

                /* After Login Steps */
                boolean stayLoggedIn = true;
                while (stayLoggedIn) {
                    /* which operation? */
                    System.out.println("Which operation do you wish to do? \n" +
                            "Pick the correct number for the related operation:\n" +
                            "1 - Reserve Umbrella\n" +
                            "2 - Cancel Umbrella\n" +
                            "3 - List Umbrellas\n" +
                            "4 - Logout\n");

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
                                addServerIntf.praia_quantidadePessoasSombrinha(Integer.parseInt(input));
                            } else {
                                System.out.println("Invalid Input");
                            }

                            System.out.println("What is the beach you want to go to?\n A\nB\nC");
                            input = reader.readLine().trim();
                            switch (input) {
                                case "A":
                                case "B":
                                case "C":
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                            }
                            addServerIntf.changepraia(input);
                            praia = input;

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
                            int[] thisArray = addServerIntf.praia_umbrellasNr();
                            if (thisArray != null) {
                                for (int i = 0; i < thisArray.length; i++) {
                                    String fileName = praia + thisArray[i] + ".txt";
                                    if (addServerIntf.praia_verificarDisponibilidade(fileName)) {
                                        theFileNr = thisArray[i];

                                        System.out.println("This Umbrella: " + praia + thisArray[i] + "will be reserved in your name");
                                        break;
                                    }
                                }
                            }

                            if (theFileNr != -1) {
                                //escreve no ficheiro praia
                                addServerIntf.praia_reservarSombrinha(addServerIntf.pathGetter(praia + theFileNr), addServerIntf.write_combiner(day, month, year, startHour, endHour, email));
                                addServerIntf.user_reservarSombrinha(email, addServerIntf.write_combiner(day, month, year, startHour, endHour, praia + theFileNr));
                            } else {
                                System.out.println("Unfortunately, there are no Umbrellas available for your specifications");
                            }


                        case "2":

                            /* Cancel Umbrella */

                            String file = addServerIntf.pathGetter(user + ".txt");
                            String[][] thisUserFile = addServerIntf.user_listarSombrinhas(file);

                            System.out.println("Which of these reservations, do you wish to cancel?");
                            input = reader.readLine().trim();

                            /* check if its a valid option */
                            if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= thisUserFile.length)) {
                                System.out.println("Invalid input");
                            }

                            String id = thisUserFile[Integer.parseInt(input) - 1][idSombra];

                            addServerIntf.user_cancelarSombrinha(Integer.parseInt(input) - 1, thisUserFile, email);

                        case "3":

                            /* List umbrella's on beach */

                            System.out.println("What is the beach you want to go to?\n A\nB\nC");
                            input = reader.readLine().trim();
                            switch (input) {
                                case "A":
                                case "B":
                                case "C":
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                            }
                            addServerIntf.changepraia(input);
                            praia = input;

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

                            addServerIntf.praia_listarSombrinhas(date, start, end);

                        case "4":
                            /* Logout */
                            addServerIntf.changeloggedIn(false);
                            stayLoggedIn = false;
                            break;

                        default:
                            System.out.println("Invalid option try again!");
                            break;

                    }
                } /* stayLoggedIn */

                /* Go back to the Start */

                //addServerIntf.main();
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
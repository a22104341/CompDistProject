import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Locale;


import java.util.Arrays;


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
                boolean loggedIn = false;





                /* Initialize all the Variables and Lists */
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
                        boolean askedEmail = true;
                        input = reader.readLine();

                        if (thisInput == '1') {

                            /* give him 3 attempts at getting the password right */
                            int counter = 0;
                            while (counter < 3) {
                                /* Login */
                                if (input != null && !user_verificarDisponibilidade(input)) {
                                    email = input;
                                    System.out.println("Please type in your password:");
                                    String input2 = reader.readLine();
                                    if (input2 != null && !user_verifyLogin(email.trim(), input2)) {
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
                                if (!askedEmail){
                                    System.out.println("Please type in your email:");
                                    input = reader.readLine();
                                    askedEmail = true;
                                }
                                if (input != null && user_verificarDisponibilidade(input)) {

                                    //Register Section
                                    email = input.trim();

                                    /* Email-Format Check */
                                    if (!(email.length() < 255)) {
                                        System.out.println("Email is too long (maximum 254 Characters)");
                                        break;
                                    }

                                    /* @ Checks */
                                    int position = -1;
                                    if (email.contains("@")) {
                                        /* Check how many @'s */
                                        int counter = 0;
                                        boolean cutItShort = false;
                                        for (int i = 0; i < email.length(); i++) {
                                            if (email.charAt(i) == '@') {
                                                counter++;
                                                position = i;
                                            }
                                        }

                                        if (counter != 1 || position == 0 || position == email.length() - 1) {
                                            /* Either missing '@', more than one '@', or '@' in the first or last position */
                                            System.out.println("Incorrect Format, you need to have exactly 1 @ in your email, and it should not be in the first or last position");
                                            cutItShort = true;
                                        }

                                        if (cutItShort) {
                                            // Handle the error or break as needed
                                            break;
                                        }

                                    } else {
                                        /* Missing an @ */
                                        System.out.println("Incorrect Format, you need to have at least 1 @ in your email");
                                        // Handle the error or break as needed
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
                                        if (!(Character.isLetter(currentChar) || Character.isDigit(currentChar))) {
                                            if (!(Character.isLetter(b4Char) || Character.isDigit(b4Char))) {

                                                System.out.println("The email can't have two Symbols following each other");
                                                cutItShort = true;
                                                break;
                                            }
                                        }
                                        b4Char = currentChar;
                                    }
                                    if (cutItShort) {
                                        break;
                                    } else {
                                        reaskEmail = false;
                                        break;
                                    }

                                } else {
                                    System.out.println("Email already in use, use a different email");
                                    askedEmail = false;
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
                                                    System.out.println(password);
                                                    user_register(email, password);
                                                    addServerIntf.user_cria(email, password);
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
                            int ola = 0;
                            while (true) {
                                System.out.println("How many people will be going to the beach with you?");
                                input = reader.readLine().trim();
                                if (Character.isDigit(input.charAt(0))) {
                                    addServerIntf.praia_quantidadePessoasSombrinha(Integer.parseInt(input));
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                            addServerIntf.praia_quantidadePessoasSombrinha(Integer.parseInt(input));
                            boolean magic = false;
                            while (!magic) {

                                System.out.println("What is the beach you want to go to?\nA\nB\nC");
                                input = reader.readLine().trim();
                                switch (input) {
                                    case "A":
                                    case "B":
                                    case "C":
                                        magic = true;
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                }
                            }
                            addServerIntf.changepraia(input);
                            praia = input;


                            System.out.println("Which day do you want to go to the beach?");
                            day = reader.readLine().trim();
                            addServerIntf.changedia(Integer.parseInt(day));
                            System.out.println("What month you want to go to the beach?");
                            month = reader.readLine().trim();
                            addServerIntf.changemes(Integer.parseInt(month));
                            System.out.println("What year you want to go to the beach?");
                            year = reader.readLine().trim();
                            addServerIntf.changeano(Integer.parseInt(year));

                            while (true) {
                                System.out.println("At what time do you wish to go? Opening times: 8-20");
                                startHour = reader.readLine().trim();
                                addServerIntf.changestarthour(Integer.parseInt(startHour));
                                int start = Integer.parseInt(startHour);
                                if (!(start >= 8 && start < 20)) {
                                    System.out.println("Invalid Option");
                                } else {
                                    break;
                                }
                            }

                            while (true) {
                                System.out.println("When do you want to leave the beach? 8-20");
                                endHour = reader.readLine().trim();
                                addServerIntf.changeendhour(Integer.parseInt(endHour));
                                int end = Integer.parseInt(endHour);
                                if (!(end > 8 && end <= 20)) {
                                    System.out.println("Invalid Option");
                                } else {
                                    break;
                                }
                            }

                            /* Now we need to check, which umbrella's are valid options for the amount of people */
                            /* We need a function, that returns an Array, with only UmbrellaNrs, that are valid for this Functions.*/
                            /* thisArray = CallsTheFunction */
                            int theFileNr = -1;
                            int[] thisArray = null;

                            thisArray = addServerIntf.praia_umbrellasNr();

                            if (thisArray != null) {
                                for (int i = 0; i < thisArray.length; i++) {
                                    String fileName = praia + thisArray[i];
                                    if (addServerIntf.praia_verificarDisponibilidade(fileName)) {
                                        theFileNr = thisArray[i];


                                        System.out.println("This Umbrella: " + praia + thisArray[i] + " will be reserved in your name");
                                        break;
                                    }
                                }
                            }

                            if (theFileNr != -1) {

                                //escreve no ficheiro praia
                                addServerIntf.praia_reservarSombrinha((praia + theFileNr), addServerIntf.write_combiner(day, month, year, startHour, endHour, email));
                                addServerIntf.user_reservarSombrinha(email, addServerIntf.write_combiner(day, month, year, startHour, endHour, praia + theFileNr));
                            } else {
                                System.out.println("Unfortunately, there are no Umbrellas available for your specifications");
                            }
                            break;


                        case "2":

                            /* Cancel Umbrella */

                            String[][] thisUserFile = addServerIntf.user_listarSombrinhas(email);
                            if (thisUserFile == null) {
                                System.out.println("You dont have any reservations.");
                                break;
                            }
                            if (thisUserFile != null) {
                                System.out.println("These are your Umbrella reservations:");
                                int count1 = 1;
                                for (String[] line : thisUserFile) {
                                    System.out.println(count1 + "- " + Arrays.toString(line));
                                    count1++;
                                }
                                while (true) {
                                    System.out.println("Which of these reservations, do you wish to cancel?");
                                    input = reader.readLine().trim();
                                    /* check if its a valid option */
                                    if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= thisUserFile.length)) {
                                        System.out.println("Invalid input");
                                    } else {
                                        break;
                                    }
                                }

                                String id = thisUserFile[Integer.parseInt(input) - 1][idSombra];

                                addServerIntf.user_cancelarSombrinha(Integer.parseInt(input) - 1, thisUserFile, email);
                            }
                            /* check if its a valid option */
                            break;

                        case "3":

                            /* List umbrella's on beach */
                            int count1 = 0;
                            while (count1 != 0) {
                                System.out.println("What is the beach you want to go to?\nA\nB\nC");
                                input = reader.readLine().trim();
                                switch (input) {
                                    case "A":
                                    case "B":
                                    case "C":
                                        count1 = 1;
                                        break;
                                    default:
                                        count1 = 0;
                                        System.out.println("Invalid Input");
                                }
                            }
                            addServerIntf.changepraia(input);
                            praia = input;


                            System.out.println("Which day do you want to go to the beach?");
                            day = reader.readLine().trim();
                            addServerIntf.changedia(Integer.parseInt(day));
                            System.out.println("What month you want to go to the beach?");
                            month = reader.readLine().trim();
                            addServerIntf.changemes(Integer.parseInt(month));
                            System.out.println("What year you want to go to the beach?");
                            year = reader.readLine().trim();
                            addServerIntf.changeano(Integer.parseInt(year));
                            int start1 = 0;
                            count1 = 0;
                            while (count1 != 0) {
                                System.out.println("At what time do you wish to go? Opening times: 8-20");
                                startHour = reader.readLine().trim();
                                addServerIntf.changestarthour(Integer.parseInt(startHour));
                                start1 = Integer.parseInt(startHour);
                                if (!(start1 >= 8 && start1 < 20)) {
                                    System.out.println("Invalid Option");
                                } else {
                                    count1 = 1;
                                    break;
                                }
                            }
                            int end1 = 0;
                            count1 = 0;
                            while (count1 != 0) {
                                System.out.println("When do you want to leave the beach? 8-20");
                                endHour = reader.readLine().trim();
                                addServerIntf.changeendhour(Integer.parseInt(endHour));
                                end1 = Integer.parseInt(endHour);
                                if (!(end1 > 8 && end1 <= 20)) {
                                    System.out.println("Invalid Option");
                                } else {
                                    count1 = 1;
                                    break;
                                }
                            }
                            String date = day + "/" + month + "/" + year;

                            String resposta = addServerIntf.praia_listarSombrinhas(date, start1, end1);

                            System.out.println("These are the available umbrellas on beach " + praia + ":" + "\n");
                            System.out.println(resposta);

                            break;

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

    public static void user_register(String email, String password) throws RemoteException {
        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */
        try {
            /* Need to turn the email lowercase */
            String filePath = "C:\\Users\\Administrador\\eclipse-workspace\\soapserver2.0\\src\\plswork\\Users\\" + email + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
            writer.write(password + "\n");
            // Close the writer to flush and release resources
            writer.close();

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        }
    }

    public static boolean user_verificarDisponibilidade(String email) throws RemoteException {
        // (email already being used?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrador\\eclipse-workspace\\soapserver2.0\\src\\plswork\\Users\\" + email + ".txt")));
            return false;
        } catch (FileNotFoundException e) {
            //System.out.println("File Not Found");
            return true;
        }
    }

    public static boolean user_verifyLogin(String email, String password) throws RemoteException {
        // (emailExiste?PasswordCorreta?)
        /* go into the user Folder and then do this */
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrador\\eclipse-workspace\\soapserver2.0\\src\\plswork\\Users\\" + email + ".txt")));
            //System.out.println("File open successful!");
            /* Check if password is correct */
            if (password.equals(reader.readLine().trim())) {
                /* print that the user is logged in */
                reader.close();
                return true;
            }
            reader.close();
            /* print that the password is wrong */
            return false;
        } catch (FileNotFoundException e) {
            //  System.out.println("File Not Found");
            return false;
        } catch (IOException e) {
            // System.out.println("File I/O error!");
            /* print (that the email is wrong) */
            return false;
        }
    }

}
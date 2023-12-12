import java.io.*;
import java.util.Locale;

public class User {
    public static String[][] user_read_splitter(String file, String path) {
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        // 0-day, 1-month, 2-year, 3-startHour, 4-endHour, 5-idSombra;

        String[][] dados;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(path + file)));
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(path + file)));
            System.out.println("File open successful!");
            //countLines count lines
            int countLines = 0;
            for (String x = reader1.readLine(); x != null; x = reader1.readLine()) {
                countLines++;

            }
            dados = new String[countLines][6];

            String line = null;
            line = reader.readLine();
            for (int lines = 0; lines < countLines; lines++) {
                String[] divisao = line.split("/");
                dados[lines] = divisao;
                line = reader.readLine();
            }
            return dados;
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
        return new String[1][1];
    }


    public static boolean user_verificarDisponibilidade(String email) {
        // (email already being used?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(email + ".txt")));
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return true;
        }
    }

    public static boolean user_verifyLogin(String email, String password) {
        // (emailExiste?PasswordCorreta?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(email.toLowerCase(Locale.ROOT) + ".txt")));
            System.out.println("File open successful!");
            /* Check if password is correct */
            if (password.equals(reader.readLine().trim())) {
                /* print that the user is logged in */
                return true;
            }
            /* print that the password is wrong */
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return false;
        } catch (IOException e) {
            System.out.println("File I/O error!");
            /* print (that the email is wrong) */
            return false;
        }
    }

    public static void user_register(String email, String password) {
        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */
        try {
            /* Need to turn the email lowercase */
            BufferedWriter writer = new BufferedWriter(new FileWriter(email.toLowerCase(Locale.ROOT) + ".txt"));
            writer.write(password + "\n");
            /* print user has been registered */
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }

    public static String[][] user_listarSombrinhas(String file) {
        // (Listar as sombrinhas q ele tem no ficheiro)
        /* go into the user Folder and then do this */
        System.out.println("These are your Umbrella reservations:");

        /* Call ReadSplitter and print em out*/
        String path = Functions.pathGetter(file);
        String[][] readsplitter = user_read_splitter(file, path);

        // 0-day, 1-month, 2-year, 3-startHour, 4-endHour, 5-idSombra;
        for (int i = 0; i < readsplitter.length; i++) {
            String beach = file.charAt(0) + "";
            System.out.println((i + 1) + " - Beach: " + beach + "DD/MM/YYYY" + readsplitter[0] + "/" + readsplitter[1] + "/" + readsplitter[2]
                    + "start hour: " + readsplitter[3] + "end hour: " + readsplitter[4]);
        }
        /* Beach: X  Date: X  StartHour: X  EndHour: X */
        return readsplitter;
    }

    public static void user_reservarSombrinha(String file, String input) {
        // (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA   input = call write_combiner()      Esse chama o mesmo mas das funcoes da praia)
        /* go into the user Folder and then do this */
        try {

            BufferedReader in = new BufferedReader(new FileReader(file + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"));

            //ciclo rescreve o que ja la esta dentro
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                writer.write(x);
            }
            //escreve no fim

            writer.write(input + "\n");

        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

    }

    public static void user_cancelarSombrinha(int line, String[][] info, String email) {
        // (GOES WITH PRAIA ONE)
        /* go into the user Folder and then do this */
        String originalFileName = email + ".txt";

        Functions.replaceFileInfo(line, originalFileName, info);

        /* Also delete this reservation, inside the umbrella file */
        Praia.praia_cancelarSombrinha(email, info[line]);
    }
}


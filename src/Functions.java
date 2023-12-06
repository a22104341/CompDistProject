import java.io.*;
import java.util.List;
import java.util.Locale;

public class Functions {
    /* Define variables that won't change */




    public static void lerUser(String nomeDoFicheiro, String user) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int lines = 0;
            String line = null;
            line = reader.readLine();
            while (line != null) {
                if (lines >= 1) {

                    String[] divisao = line.split("/");
                    // rethinking
                    Main.dia = Integer.parseInt(divisao[0].trim());
                    Main.mes = Integer.parseInt(divisao[1].trim());
                    Main.ano = Integer.parseInt(divisao[2].trim());
                    Main.idSombrinha = String.valueOf(divisao[3]);

                }
                lines++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }


    public static void lerPraias(String nomeDoFicheiro) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int lines = 0;
            String line = null;
            line = reader.readLine();
            while (line != null) {

                if (lines >= 0) {


                    String[] divisao = line.split("/");
                    // guardar para descobrir se ja existe
                    int dia1 = Integer.parseInt(divisao[0].trim());
                    int mes1 = Integer.parseInt(divisao[1].trim());
                    int ano1 = Integer.parseInt(divisao[2].trim());
                    int horadeInicio1 = Integer.parseInt(divisao[3].trim());
                    int horaFim1 = Integer.parseInt(divisao[4].trim());
                    String user1 = String.valueOf(divisao[5]);
                }
                lines++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }



    /*                                               ACTUAL CODE STARTS HERE */

    public static void start() {


        Main.used = 0;
        Main.user = "";
        Main.dia = 0;
        Main.mes = 0;
        Main.ano = 0;
        Main.horadeInicio = 0;
        Main.horaFim = 0;
        Main.idSombrinha = "";
        Main.praia = "";
        Main.maxPessoas = 0;
        Main.loggedIn = false;

    }


    public static String pathGetter(String filename) {
        /* We need to verify the input of the user, before it gets here */
        String path = "";
        if (filename != null && filename.length() > 0) {

            switch (filename.charAt(0)) {
                case 'A':
                    path = "../FolderDeTudo/BeachA/" + filename;
                    return path;

                case 'B':
                    path = "../FolderDeTudo/BeachB/" + filename;
                    return path;

                case 'C':
                    path = "../FolderDeTudo/BeachC/" + filename;
                    return path;

                default:
                    path = "../FolderDeTudo/Users/" + filename;
                    return path;
            }
        }
        return path;
    }

    public static String write_combiner(String day, String month, String year, String startHour, String endHour, String lastVariable) {
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + year + "/" + startHour + "/" + endHour + "/" + lastVariable;
    }

    public static String array_combiner(String[] array){
        StringBuilder magic = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++){
            magic.append(array[i]).append("/");
        }
        return magic + array[array.length - 1];
    }

    public static void replaceFileInfo(int line, String originalFileName, String[][] info){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("TempFile" + ".txt"));

            //ciclo que escreve oq tem do outro ficheiro, para dentro de um TempFile
            for (int i = 0; i < info.length; i++) {
                if (i != line) {
                    String thisLine = array_combiner(info[i]);
                    writer.write(thisLine + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

        /* Overwrite stuff from old file, with stuff from new file */
        String sourceFileName = "TempFile.txt";
        try (
                BufferedReader reader = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathGetter(originalFileName) + originalFileName + ".txt"))
        ) {
            String line2;
            while ((line2 = reader.readLine()) != null) {
                // Read a line from the source file and write it to the destination file
                writer.write(line2);
                writer.newLine(); // Add a newline for each line if needed
            }
        } catch (IOException e) {
            System.err.println("Error cloning content: " + e.getMessage());
        }
    }




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
        String path = pathGetter(file);
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

        replaceFileInfo(line, originalFileName, info);

        /* Also delete this reservation, inside the umbrella file */
        Praia.praia_cancelarSombrinha(email, info[line]);
    }

    public static void eachHour() {
        // (Passa por cada Praia e sombrinha, para ver a horaFim, se a hora fim for igual à hora atual, usa cancelarSombrinha(praia + user))
    }



    /*
     * start()                  (starts everything just like before)
     *
     * praia_read_splitter()        (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
     * user_read_splitter()
     * praia_write_combiner()       (gets all the inputs, writes them with the +"/"+ in the middle etc.)
     * user_write_combiner()
     *
     * praia_verificarDisponibilidade()       (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
     * praia_listarSombrinhas()             (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)
     * praia_reservarSombrinha()           (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/email)
     * praia_cancelarSombrinha()       (Vai a essa combrinha, procura o email, verifica se a data/horas são as msmas, apaga as reservas)
     * praia_quantidadePessoasSombrinha()   (qual das sombrinhas a mais apropriada?)
     *
     * user_verificarDisponibilidade()   (email already being used?)
     * user_verifyLogin()              (emailExiste?PasswordCorreta?)
     * user_register()             (criar novo ficheiro - Filename: "email", conteúdo:"Password")
     * user_listarSombrinhas()    (Listar as sombrinhas q ele tem no ficheiro)
     * user_verificarSombrinha()     (é uma das sombrinhas dele?)
     * user_reservarSombrinha()           (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA         GOES WITH PRAIA ONE)
     * user_cancelarSombrinha()   (GOES WITH PRAIA ONE)
     *
     * pathGetter(fileName)           (Switch Case, que vê o nome do ficheiro, e dá o caminho + nome do ficheiro como return SE EXISTIR)
     *
     * eachHour()          (Passa por cada Praia e sombrinha, para ver a horaFim, se a hora fim for igual à hora atual, usa cancelarSombrinha(praia + user))
     *
     * Temos q fzr dps ainda um sombrinhasValidas, etc. (mas isso é tdo só validações q adicionamos a seguir como função, é mais facil fzr essas mais tarde)
     * Mas isso é mais tipo verificar se os inputs do user são corretos etc.
     */


}

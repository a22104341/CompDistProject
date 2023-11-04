import java.io.*;

public class User {
    public static String[][] read_splitter(String file){
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        //GUARDA OS DADOS DAS PRAIAS dentro de uma matriz
        String[][] dados;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(file)));
            System.out.println("File open successful!");
            //countLines count lines
            int countLines=0;
            for (String x = reader1.readLine(); x != null; x = reader1.readLine()) {
                countLines++;

            }
            dados =new String[countLines][6];

            String line =null;
            line=reader.readLine();
            for (int lines=0;lines<countLines;lines++){
                String[] divisao = line.split("/");
                dados[lines]=divisao;
                line=reader.readLine();
            }
            return dados;
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
        return new String[1][1];
    }

    public static String write_combiner(String day, String month,String year, String startHour, String endHour, String idSombrinha){
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + year + "/" + startHour + "/" + endHour + "/" + idSombrinha;
    }

    public static boolean user_verificarDisponibilidade(String email){
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

    public static boolean verifyLogin(String email, String password){
        // (emailExiste?PasswordCorreta?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(email + ".txt")));
            System.out.println("File open successful!");
            /* Check if password is correct */
            if(password.equals(reader.readLine().trim())){
                /* print that the user is logged in */
                return true;
            }
            /* print that the password is wrong */
            return false;
        } catch (IOException e) {
            System.out.println("File I/O error!");
            /* print (that the email is wrong) */
            return false;
        }
    }

    public static void register(String email, String password){
        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(email + ".txt"));
            writer.write(password + "\n");
            /* print user has been registered */
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }

    public static void listarSombrinhas(){
        // (Listar as sombrinhas q ele tem no ficheiro)
        /* go into the user Folder and then do this */
    }

    public static boolean verificarSombrinha(){
        // (é uma das sombrinhas dele?)
        /* go into the user Folder and then do this */
        return false;
    }

    public static void reservarSombrinha(String input){
        // (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA   input = call write_combiner()      Esse chama o mesmo mas das funcoes da praia)
        /* go into the user Folder and then do this */
    }

    public static void cancelarSombrinha(String email, String date, String endHour){
        // (GOES WITH PRAIA ONE)
        /* go into the user Folder and then do this */
    }
}


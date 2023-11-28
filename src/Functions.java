import java.io.*;
import java.util.List;

public class Functions {
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

    static final int praiaASombrinhas2 = 10;
    static final int praiaASombrinhas3 = 5;
    static final int praiaASombrinhas4 = 5;
    static final int praiaBSombrinhas2 = 5;
    static final int praiaBSombrinhas3 = 5;
    static final int praiaBSombrinhas4 = 1;
    static final int praiaCSombrinhas2 = 10;

    /* Array com os numeros das sombrinhas */

    static final int[] max2A=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    static final int[] max3A=new int[]{11,12,13,14,15,16,17,18,19,20};

    static final int[] max4A=new int[]{16,17,18,19,20};

    static final int[] max2B=new int[]{1,2,3,4,5,6,7,8,9,10,11};

    static final int[] max3B=new int[]{6,7,8,9,10,11};

    static final int[] max4B=new int[]{11};

    static final int[] max2C=new int[]{1,2,3,4,5,6,7,8,9,10};



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



    public static String write_combiner(String day, String month, String year, String startHour, String endHour, String lastVariable) {
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + year + "/" + startHour + "/" + endHour + "/" + lastVariable;
    }
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
                    dia = Integer.parseInt(divisao[0].trim());
                    mes = Integer.parseInt(divisao[1].trim());
                    ano = Integer.parseInt(divisao[2].trim());
                    idSombrinha = String.valueOf(divisao[3]);

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

    public static void guardarPraias(String nomeDoFicheiro, int duracao, String user, int numeroPessoas, char praia, int dia, int mes, int ano, String horaInicio) {
        try {

            BufferedReader in = new BufferedReader(new FileReader(new File(nomeDoFicheiro)));
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoFicheiro));


            int line1 = 0;
            int line2 = 0;

            if (praia == 'A') {
                if (numeroPessoas == 2) {
                    if (used < 10) {
                        used++;
                        //ciclo rescreve o que ja la esta dentro
                        for (String x = in.readLine(); x != null; x = in.readLine()) {
                            line1++;
                            writer.write(x);

                        }
                        //escreve no fim
                        writer.write(dia + "/" + mes + "/" + ano + "/" + horaInicio + "/" + duracao + "/" + user + "/" + praia + used + "\n");
                    }
                }
            }
            if (praia == 'B') {

            }
            if (praia == 'C') {

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }

    /*                                               ACTUAL CODE STARTS HERE */

    public static void start() {
        /* Praia A */
        praia_A = new Sombrinha[3][3];
        max2_A = new Sombrinha[praiaASombrinhas2];
        max3_A = new Sombrinha[praiaASombrinhas3];
        max4_A = new Sombrinha[praiaASombrinhas4];

        char beachA = 'A';

        /* Create Sombrinhas and Save them into the Arrays */
        for (int i = 1; i <= praiaASombrinhas2; i++) {
            max2_A[i] = new Sombrinha(i, max2, beachA);
        }
        for (int i = 1; i <= praiaASombrinhas3; i++) {
            max3_A[i] = new Sombrinha(i, max3, beachA);
        }
        for (int i = 1; i <= praiaASombrinhas4; i++) {
            max4_A[i] = new Sombrinha(i, max4, beachA);
        }
        /* Save arrays of sombrinhas into the beach */
        praia_A[max2] = max2_A;
        praia_A[max3] = max3_A;
        praia_A[max4] = max4_A;


        /* Praia B */
        praia_B = new Sombrinha[3][3];
        max2_B = new Sombrinha[praiaBSombrinhas2];
        max3_B = new Sombrinha[praiaBSombrinhas3];
        max4_B = new Sombrinha[praiaBSombrinhas4];

        char beachB = 'B';

        /* Create Sombrinhas and Save them into the Arrays */
        for (int i = 1; i <= praiaBSombrinhas2; i++) {
            max2_B[i] = new Sombrinha(i, max2, beachB);
        }
        for (int i = 1; i <= praiaBSombrinhas3; i++) {
            max3_B[i] = new Sombrinha(i, max3, beachB);
        }
        for (int i = 1; i <= praiaBSombrinhas4; i++) {
            max4_B[i] = new Sombrinha(i, max4, beachB);
        }
        /* Save arrays of sombrinhas into the beach */
        praia_B[max2] = max2_B;
        praia_B[max3] = max3_B;
        praia_B[max4] = max4_B;


        /* Praia C */
        praia_C = new Sombrinha[1][1];
        max2_C = new Sombrinha[praiaCSombrinhas2];

        char beachC = 'C';

        /* Create Sombrinhas and Save them into the Arrays */
        for (int i = 1; i <= praiaCSombrinhas2; i++) {
            max2_C[i] = new Sombrinha(i, max2, beachC);
        }
        praia_C[max2] = max2_C;


        used = 0;
        user = "";
        dia = 0;
        mes = 0;
        ano = 0;
        horadeInicio = 0;
        horaFim = 0;
        idSombrinha = "";
        praia = "";
        maxPessoas = 0;
        loggedIn = false;

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

    public static void eachHour() {
        // (Passa por cada Praia e sombrinha, para ver a horaFim, se a hora fim for igual à hora atual, usa cancelarSombrinha(praia + user))
    }
    public static void reservarSombrinha(String file,String input) {
        // (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA   input = call write_combiner()      Esse chama o mesmo mas das funcoes da praia)
        /* go into the user Folder and then do this */


        try {

            BufferedReader in = new BufferedReader(new FileReader(file+"txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file+"txt"));

            //ciclo rescreve o que ja la esta dentro
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                writer.write(x);
            }
            //escreve no fim

            writer.write(input+ "\n");

        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

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

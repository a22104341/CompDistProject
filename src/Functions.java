import java.io.*;

public class Functions {
    /* Define variables that won't change */
    static final int max2 = 0;
    static final int max3 = 1;
    static final int max4 = 2;
    static final int praiaASombrinhas2 = 10;

    static int used2_A=0;
    static final int praiaASombrinhas3 = 5;
    static final int praiaASombrinhas4 = 5;
    static final int praiaBSombrinhas2 = 5;
    static final int praiaBSombrinhas3 = 5;
    static final int praiaBSombrinhas4 = 1;
    static final int praiaCSombrinhas2 = 10;

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
    static int dia=0;
    static int mes=0;
    static int ano=0;
    static String horadeInicio="";
    static String idSombrinha="";

    static int duracao;

    public static void start() {
        /* Praia A */
        praia_A = new Sombrinha[3][3];
        max2_A = new Sombrinha[praiaASombrinhas2];
        max3_A = new Sombrinha[praiaASombrinhas3];
        max4_A = new Sombrinha[praiaASombrinhas4];

        char beachA = 'A';

        /* Create Sombrinhas and Save them into the Arrays */
        for (int i = 1; i <= praiaASombrinhas2; i++){
            max2_A[i] = new Sombrinha(i, max2, beachA);
        }
        for (int i = 1; i <= praiaASombrinhas3; i++){
            max3_A[i] = new Sombrinha(i, max3, beachA);
        }
        for (int i = 1; i <= praiaASombrinhas4; i++){
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
        for (int i = 1; i <= praiaBSombrinhas2; i++){
            max2_B[i] = new Sombrinha(i, max2, beachB);
        }
        for (int i = 1; i <= praiaBSombrinhas3; i++){
            max3_B[i] = new Sombrinha(i, max3, beachB);
        }
        for (int i = 1; i <= praiaBSombrinhas4; i++){
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
        for (int i = 1; i <= praiaCSombrinhas2; i++){
            max2_C[i] = new Sombrinha(i, max2, beachC);
        }
        praia_C[max2] = max2_C;
    }

    public static void reservar(String user,int duracao,int numeroPessoas,char praia){
        String fileName = user+".txt";
        guardarPraias(fileName,duracao,user,numeroPessoas,praia,dia,mes,ano,horadeInicio);
       // public static void guardarPraias(String nomeDoFicheiro,int duracao,String user,int numeroPessoas,char praia)
    }
    public static void lerUser(String nomeDoFicheiro,String user) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int lines = 0;
            String line =null;
            line=reader.readLine();
            while(line!=null){
          if (lines>=1){

                    String[] divisao = line.split("/");
              // rethinking
                    dia = Integer.parseInt(divisao[0].trim());
                    mes = Integer.parseInt(divisao[1].trim());
                    ano = Integer.parseInt(divisao[2].trim());
                    idSombrinha=String.valueOf(divisao[3]);

          }
                lines++;
          line=reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    public void lerPraias(String nomeDoFicheiro) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int lines = 0;
            String line =null;
            line=reader.readLine();
            while(line!=null){

                if (lines>=0){


                    String[] divisao = line.split("/");
                    // so a guardar need to guardar em variaveis globais
                    dia = Integer.parseInt(divisao[0].trim());
                    mes = Integer.parseInt(divisao[1].trim());
                    ano = Integer.parseInt(divisao[2].trim());
                    horadeInicio=String.valueOf(divisao[3]);
                    duracao = Integer.parseInt(divisao[4].trim());
                    idSombrinha=String.valueOf(divisao[5]);


                }
                lines++;
                line=reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    public static void guardarPraias(String nomeDoFicheiro,int duracao,String user,int numeroPessoas,char praia,int dia,int mes,int ano,String horaInicio) {
        try {

            BufferedReader in = new BufferedReader(new FileReader(new File(nomeDoFicheiro)));
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoFicheiro));


            int line1 = 0;
            int line2 = 0;
           /* static final int max2 = 0;
            static final int max3 = 1;
            static final int max4 = 2;
            static final int praiaASombrinhas2 = 10;
            static final int praiaASombrinhas3 = 5;
            static final int praiaASombrinhas4 = 5;
            static final int praiaBSombrinhas2 = 5;
            static final int praiaBSombrinhas3 = 5;
            static final int praiaBSombrinhas4 = 1;
            static final int praiaCSombrinhas2 = 10;
*/
            /* Sombrinha Lists */
          /*  static Sombrinha[][] praia_A;
            static Sombrinha[] max2_A;
            static Sombrinha[] max3_A;
            static Sombrinha[] max4_A;
            static Sombrinha[][] praia_B;
            static Sombrinha[] max2_B;
            static Sombrinha[] max3_B;
            static Sombrinha[] max4_B;
            static Sombrinha[][] praia_C;
            static Sombrinha[] max2_C;
            */
            if (praia=='A'){
                if(numeroPessoas==2){
                if (used2_A<10) {
                    used2_A++;
                    //ciclo rescreve o que ja la esta dentro
                    for (String x = in.readLine(); x != null; x = in.readLine()) {
                        line1++;
                        writer.write(x);

                        }
                    //escreve no fim
                    writer.write(dia+"/"+mes+"/"+ano+"/"+horaInicio+"/"+duracao+"/"+user+"/"+praia+used2_A+"\n");
                }
                }
            }
            if (praia=='B'){

            }
            if (praia=='C'){

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
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
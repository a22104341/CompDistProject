import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /* Define variables that won't change */
    static final int max2 = 0;
    static final int max3 = 1;
    static final int max4 = 2;
    static final int praiaASombrinhas2 = 10;
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


    public static void main(String[] args) {
        /* Initiialize all the Variables and Lists */
        start();


        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int line = 0;
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                line++;
                System.out.println(x);
                //colocarate ao fim
                if (line <= 5) {
                    String[] divisao = x.split(",");
                    //o que quiseres
                    System.out.println(divisao[1]);
                }

            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

        //SAVING
        try {
            File file = new File("praia.txt");
            BufferedReader in = new BufferedReader(new FileReader(new File("praia.txt")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));


            int line1 = 0;
            int line2 = 0;
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                line1++;

                writer.write(x);
                writer.newLine();
                //colocarate ao fim

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }

    public void start() {
        /* Praia A */
        praia_A = new Sombrinha[3][3];
        max2_A = new Sombrinha[praiaASombrinhas2];
        max3_A = new Sombrinha[praiaASombrinhas3];
        max4_A = new Sombrinha[praiaASombrinhas4];

        char beachA = 'A';

        /* Create Sombrinhas and Save them into the Arrays */
        for (int i = 0; i < praiaASombrinhas2; i++){
            max2_A[i] = new Sombrinha(i, max2, beachA);
        }
        for (int i = 0; i < praiaASombrinhas3; i++){
            max3_A[i] = new Sombrinha(i, max3, beachA);
        }
        for (int i = 0; i < praiaASombrinhas4; i++){
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
        for (int i = 0; i < praiaBSombrinhas2; i++){
            max2_B[i] = new Sombrinha(i, max2, beachB);
        }
        for (int i = 0; i < praiaBSombrinhas3; i++){
            max3_B[i] = new Sombrinha(i, max3, beachB);
        }
        for (int i = 0; i < praiaBSombrinhas4; i++){
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
        for (int i = 0; i < praiaCSombrinhas2; i++){
            max2_C[i] = new Sombrinha(i, max2, beachC);
        }
        praia_C[max2] = max2_C;
    }

    public void lerUser(String nomeDoFicheiro) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int line = 0;
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                line++;
                System.out.println(x);
                //colocarate ao fim
                if (line <= 5) {
                    String[] divisao = x.split(",");
                    //VER O TXT EXEMPLO DO A QUE O DIOGO DEU

                    System.out.println(divisao[1]);
                }

            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    public void lerPraias(String nomeDoFicheiro) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("praia.txt")));
            System.out.println("File open successful!");

            int line = 0;
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                line++;
                System.out.println(x);
                //colocarate ao fim
                if (line <= 5) {
                    String[] divisao = x.split(",");
                    //VER O TXT EXEMPLO DO A QUE O DIOGO DEU

                    System.out.println(divisao[1]);
                }

            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    public void guardarPraias(String nomeDoFicheiro) {
        try {
            File file = new File("praia.txt");
            BufferedReader in = new BufferedReader(new FileReader(new File("praia.txt")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));


            int line1 = 0;
            int line2 = 0;
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                line1++;

                writer.write(x);
                writer.newLine();
                //colocarate ao fim

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }
}
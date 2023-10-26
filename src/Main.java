import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

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
    static Sombrinha[][] praia_A = new Sombrinha[3][3];
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

    public void start( ) {
        praia_A = new Sombrinha[3][3];
        max2_A = new Sombrinha[praiaASombrinhas2];
        max3_A = new Sombrinha[praiaASombrinhas3];
        max4_A = new Sombrinha[praiaASombrinhas4];
        praia_B = new Sombrinha[3][3];
        max2_B = new Sombrinha[praiaBSombrinhas2];
        max3_B = new Sombrinha[praiaBSombrinhas3];
        max4_B = new Sombrinha[praiaBSombrinhas4];
        praia_C = new Sombrinha[1][1];
        max2_C = new Sombrinha[praiaCSombrinhas2];

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
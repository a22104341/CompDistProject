import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /* Initiialize all the Variables and Lists */
        Functions.start();

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
}
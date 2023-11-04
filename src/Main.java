import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        /* Initiialize all the Variables and Lists */
        Functions.start();

        /*input
        Functions.dia = day;
        Functions.mes = month;
        Functions.ano = year;
        Functions.horadeInicio=startHour;
        Functions.horaFim = endHour;
        Functions.user = email;
        */
        //CREATE BUFFREADER
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String input ;
        String password ;

        if (!Functions.loggedIn) {

            // Reading data using readLine
            System.out.println("Please type in your email:");
            input=reader.readLine();
            if(User.user_verificarDisponibilidade(input)){
                //pede registo
                //WE NEED PASSWORD INPUT
                System.out.println("Please type in your email and password");
                input=reader.readLine();
                password=reader.readLine();
                User.register(input,password);
            }
            else {
                //pede LOGIN
            }





        }



    }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Praia {
    public static String[][] read_splitter(String file) {
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        //GUARDA OS DADOS DAS PRAIAS dentro de uma matriz
        String[][] dados;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(file)));
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

    public static String write_combiner(int day, int month, int year, int startHour, int endHour, String email) {
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + year + "/" + startHour + "/" + endHour + "/" + email;
    }

    public static boolean verificarDisponibilidade(String file) {
        // (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
        Functions.lerPraias(file);
        String[][] matriz = read_splitter(file);
        // O QUE TEM O 1 E A MATRIZ
        boolean returnValue = true;
        for (int index = 0; index < matriz.length; index++) {
            if (Functions.ano == Integer.parseInt(matriz[index][Functions.year]) && Integer.parseInt(matriz[index][Functions.month]) == Functions.mes && Functions.dia == Integer.parseInt(matriz[index][Functions.day])) {
                if (Functions.horadeInicio >= Integer.parseInt(matriz[index][Functions.startHour]) && Functions.horadeInicio < Integer.parseInt(matriz[index][Functions.endHour])) {
                    returnValue = false;
                } else if (Functions.horaFim < Integer.parseInt(matriz[index][Functions.endHour]) && Integer.parseInt(matriz[index][Functions.startHour]) < Functions.horaFim) {
                    returnValue = false;
                } else {
                    //dps escreve no ficheiro
                    //PRINT("NO FICHEIRO A2 A VAGA ");
                    returnValue =  true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static void listarSombrinhas(String date, String startHour, String endHour) {
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)
    }

    public static void reservarSombrinha(String input) {
        // (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/email) input = call write_combiner()

        String[] divisao = input.split("/");
        // so a guardar need to guardar em variaveis globais

        verificarDisponibilidade(Functions.pathGetter(Functions.praia));
    }

    public static void cancelarSombrinha(String email, String date, String endHour) {
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)

    }

    public static void quantidadePessoasSombrinha(int maxPeople) {
        // (qual das sombrinhas a mais apropriada?)
        Functions.maxPessoas = maxPeople;
    }
}
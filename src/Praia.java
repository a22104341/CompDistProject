import java.io.*;

public class Praia {
    public static String[][] praia_read_splitter(String file, String path) {
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        //GUARDA OS DADOS DAS PRAIAS dentro de uma matriz
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


    public static boolean praia_verificarDisponibilidade(String file) {
        // (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
        Functions.lerPraias(file);
        String path = Functions.pathGetter(file);
        String[][] matriz = praia_read_splitter(file, path);
        // O QUE TEM O 1 E A MATRIZ
        boolean returnValue = true;
        for (int index = 0; index < matriz.length; index++) {
            if (Main.ano == Integer.parseInt(matriz[index][Main.year]) && Integer.parseInt(matriz[index][Main.month]) == Main.mes && Main.dia == Integer.parseInt(matriz[index][Main.day])) {
                if (Main.horadeInicio >= Integer.parseInt(matriz[index][Main.startHour]) && Main.horadeInicio < Integer.parseInt(matriz[index][Main.endHour])) {
                    returnValue = false;
                } else if (Main.horaFim < Integer.parseInt(matriz[index][Main.endHour]) && Integer.parseInt(matriz[index][Main.startHour]) < Main.horaFim) {
                    returnValue = false;
                } else {
                    //dps escreve no ficheiro
                    //PRINT("NO FICHEIRO A2 A VAGA ");
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static void praia_listarSombrinhas(String date, int startHour, int endHour) {
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)

        /* Go through each file with the file_reader , then check if the sombrinha is occupied during those times */
        String beach = Main.praia;

        System.out.println("These are the available umbrellas on beach " + beach + ":");
        int amntUmbrellas = 0;
        switch (beach){
            case "A":
                amntUmbrellas = 20;
                break;
            case "B":
                amntUmbrellas = 11;
                break;
            case "C":
                amntUmbrellas = 10;
                break;
        }

        String[] requestedDate = date.split("/");

        for (int i = 1; i <= amntUmbrellas; i++){
            /* read with file reader*/
            String[][] reader = praia_read_splitter(beach + i + ".txt", Functions.pathGetter(beach));

            /* if any of the lines have a problem with this date and start/endhour go to the next line, till the matrix is over */
            boolean isFine = true;
            for (int j = 0; j < reader.length; j++){
                String[] currentRead = reader[j];
                String day = currentRead[Main.day];
                String month = currentRead[Main.month];
                String year = currentRead[Main.year];

                int start = Integer.parseInt(currentRead[Main.startHour]);
                int end = Integer.parseInt(currentRead[Main.endHour]);

                if (requestedDate[Main.day].equals(day) && requestedDate[Main.month].equals(month) && requestedDate[Main.year].equals(year)){
                    if ((startHour >= start && startHour < end) || (end <= endHour && endHour > start)){

                        /* If any of the lines in the file, have problems with the requested date and time, this umbrella
                        can't be used for the user, so we go to the next file */
                        isFine = false;
                        break;

                    }
                }
            }

            /* if there was no problems with the date and time of the requested booking, the umbrella gets printed */
            if (isFine){
                System.out.println(beach + i);
            }
        }
    }

    public static void praia_reservarSombrinha(String file, String input) {
        // (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/email) input = call write_combiner()

        try {

            BufferedReader in = new BufferedReader(new FileReader(file + "txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file + "txt"));

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

    public static void praia_cancelarSombrinha(String email, String[] info) {
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)
        String file = Main.praia + info[Main.idSombra] + ".txt";
        String path = Functions.pathGetter(file);
        String[][] thisUmbrella = praia_read_splitter(file, path);

        int removeThisLine = -1;
        for (int i = 0; i < thisUmbrella.length; i++){
            String[] currentLine = thisUmbrella[i];
            if (currentLine[Main.email].equals(email)){
                if (currentLine[Main.day].equals(info[Main.day]) && currentLine[Main.month].equals(info[Main.month]) &&
                        currentLine[Main.year].equals(info[Main.year]) && currentLine[Main.endHour].equals(info[Main.endHour])){
                    removeThisLine = i;
                    break;
                }
            }
        }
        if (removeThisLine == -1){
            System.out.println("Something went wrong!");
        }

        /* Remove the line that we don't need */
        String ogFileName = Main.praia + ".txt";
        Functions.replaceFileInfo(removeThisLine, ogFileName, thisUmbrella);
    }

    public static void praia_quantidadePessoasSombrinha(int maxPeople) {
        // (qual das sombrinhas a mais apropriada?)
        Main.maxPessoas = maxPeople;
    }

    public static int[] praia_umbrellasNr() {
        if (Main.praia.equals("A")) {
            if (Main.maxPessoas <= 2) {
                return Main.max2A;
            }
            if (Main.maxPessoas <= 3) {
                return Main.max3A;
            }
            if (Main.maxPessoas <= 4) {
                return Main.max4A;
            }

        } else if (Main.praia.equals("B")) {
            if (Main.maxPessoas <= 2) {
                return Main.max2B;
            }
            if (Main.maxPessoas <= 3) {
                return Main.max3B;
            }
            if (Main.maxPessoas <= 4) {
                return Main.max4B;
            }
        } else {
            if (Main.maxPessoas <= 2) {
                return Main.max2C;


            }
        }
        return null;
    }
}
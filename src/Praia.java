import java.io.*;

public class Praia {
    public static String[][] read_splitter(String file, String path) {
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


    public static boolean verificarDisponibilidade(String file) {
        // (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
        Functions.lerPraias(file);
        String path = Functions.pathGetter(file);
        String[][] matriz = read_splitter(file, path);
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
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static void listarSombrinhas(String date, int startHour, int endHour) {
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)

        /* Go through each file with the file_reader , then check if the sombrinha is occupied during those times */
        String beach = Functions.praia;

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
            String[][] reader = read_splitter(beach + i + ".txt", Functions.pathGetter(beach));

            /* if any of the lines have a problem with this date and start/endhour go to the next line, till the matrix is over */
            boolean isFine = true;
            for (int j = 0; j < reader.length; j++){
                String[] currentRead = reader[j];
                String day = currentRead[Functions.day];
                String month = currentRead[Functions.month];
                String year = currentRead[Functions.year];

                int start = Integer.parseInt(currentRead[Functions.startHour]);
                int end = Integer.parseInt(currentRead[Functions.endHour]);

                if (requestedDate[Functions.day].equals(day) && requestedDate[Functions.month].equals(month) && requestedDate[Functions.year].equals(year)){
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

    public static void reservarSombrinha(String file, String input) {
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

    public static void cancelarSombrinha(String email, String[] info) {
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)
        String file = Functions.praia + info[Functions.idSombra] + ".txt";
        String path = Functions.pathGetter(file);
        String[][] thisUmbrella = read_splitter(file, path);

        int removeThisLine = -1;
        for (int i = 0; i < thisUmbrella.length; i++){
            String[] currentLine = thisUmbrella[i];
            if (currentLine[Functions.email].equals(email)){
                if (currentLine[Functions.day].equals(info[Functions.day]) && currentLine[Functions.month].equals(info[Functions.month]) &&
                        currentLine[Functions.year].equals(info[Functions.year]) && currentLine[Functions.endHour].equals(info[Functions.endHour])){
                    removeThisLine = i;
                    break;
                }
            }
        }
        if (removeThisLine == -1){
            System.out.println("Something went wrong!");
        }

        /* Remove the line that we don't need */
        String ogFileName = Functions.praia + ".txt";
        Functions.replaceFileInfo(removeThisLine, ogFileName, thisUmbrella);
    }

    public static void quantidadePessoasSombrinha(int maxPeople) {
        // (qual das sombrinhas a mais apropriada?)
        Functions.maxPessoas = maxPeople;
    }

    public static int[] umbrellasNr() {
        if (Functions.praia.equals("A")) {
            if (Functions.maxPessoas <= 2) {
                return Functions.max2A;
            }
            if (Functions.maxPessoas <= 3) {
                return Functions.max3A;
            }
            if (Functions.maxPessoas <= 4) {
                return Functions.max4A;
            }

        } else if (Functions.praia.equals("B")) {
            if (Functions.maxPessoas <= 2) {
                return Functions.max2B;
            }
            if (Functions.maxPessoas <= 3) {
                return Functions.max3B;
            }
            if (Functions.maxPessoas <= 4) {
                return Functions.max4B;
            }
        } else {
            if (Functions.maxPessoas <= 2) {
                return Functions.max2C;


            }
        }
        return null;
    }
}
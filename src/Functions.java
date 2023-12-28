import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.Locale;

public class Functions extends UnicastRemoteObject implements FunctionsInterface {
    // Existing code...
    /* Array com os numeros das sombrinhas */
    int day = 0;
    int month = 1;
    int year = 2;
    int startHour = 3;
    int endHour = 4;
    int idSombra = 5;
    int email = 5;
    int[] max2A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    int[] max3A = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    int[] max4A = new int[]{16, 17, 18, 19, 20};

    int[] max2B = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    int[] max3B = new int[]{6, 7, 8, 9, 10, 11};

    int[] max4B = new int[]{11};

    int[] max2C = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String user = "";
    int dia = 0;
    int mes = 0;
    int ano = 0;
    int horadeInicio = 0;
    int horaFim = 0;
    String idSombrinha = "";
    String praia = "";
    int maxPessoas = 0;
    boolean loggedIn = false;
    public Functions() throws RemoteException {
        // Constructor

        this.day = 0;
        this.month = 1;
        this.year = 2;
        this.startHour = 3;
        this.endHour = 4;
        this.idSombra = 5;
        this.email = 5;
        this.max2A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        this.max3A = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        this.max4A = new int[]{16, 17, 18, 19, 20};

        this.max2B = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        this.max3B = new int[]{6, 7, 8, 9, 10, 11};

        this.max4B = new int[]{11};
        this.max2C = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        this.user="";
        this.dia=0;
        this.mes = 0;
        this.ano = 0;
        this.horadeInicio = 0;
        this.horaFim = 0;
        this.idSombrinha = "";
        this.praia = "";
        this.maxPessoas = 0;
        this.loggedIn = false;
    }
    @Override
    public String getpraia() throws RemoteException {
        return this.praia;
    }
    @Override
    public void changepraia(String value) throws RemoteException {
        this.praia = value;
        System.out.println(this.praia = value);
    }
    @Override
    public int getday() throws RemoteException {
        return this.day;
    }
    @Override
    public int getmonth() throws RemoteException {
        return this.month;
    }
    @Override
    public int getyear() throws RemoteException {
        return this.year;
    }
    @Override
    public void changedia(int value) throws RemoteException {
        this.dia = value;
    }
    @Override
    public void changemes(int value) throws RemoteException {
        this.mes = value;
    }
    @Override
    public void changeano(int value) throws RemoteException {
        this.ano = value;
    }
    @Override
    public void changestarthour(int value) throws RemoteException {
        this.startHour = value;
    }
    @Override
    public void changeendhour(int value) throws RemoteException {
        this.endHour = value;
    }

    @Override
    public int getstartHour() throws RemoteException {
        return this.startHour;
    }
    @Override
    public int getendHour() throws RemoteException {
        return this.endHour;
    }
    @Override
    public int getidSombra() throws RemoteException {
        return this.idSombra;
    }
    @Override
    public int getemail1() throws RemoteException {
        return this.email;
    }
    @Override
    public int[] getmax2A() throws RemoteException {
        return this.max2A;
    }
    @Override
    public int[] getmax3A() throws RemoteException {
        return this.max3A;
    }
    @Override
    public int[] getmax4A() throws RemoteException {
        return this.max4A;
    }

    @Override
    public int[] getmax2B() throws RemoteException {
        return this.max2B;
    }
    @Override
    public int[] getmax3B() throws RemoteException {
        return this.max3B;
    }
    @Override
    public int[] getmax4B() throws RemoteException {
        return this.max4B;
    }

    @Override
    public int[] getmax2C() throws RemoteException {
        return this.max2C;
    }
    @Override
    public String getuser() throws RemoteException {
        return this.user;
    }
    @Override
    public int getdia() throws RemoteException {
        return this.dia;
    }
    @Override
    public int getmes() throws RemoteException {
        return this.mes;
    }
    @Override
    public int getano() throws RemoteException {
        return this.ano;
    }
    @Override
    public int gethoradeInicio() throws RemoteException {
        return this.horadeInicio;
    }
    @Override
    public int gethoraFim() throws RemoteException {
        return this.horaFim;
    }
    @Override
    public String getidSombrinha() throws RemoteException {
        return this.idSombrinha;
    }
    @Override
    public int getmaxPessoas() throws RemoteException {
        return this.maxPessoas;
    }
    @Override
    public boolean getloggedIn() throws RemoteException {
        return this.loggedIn=false;
    }
    @Override
    public void changeloggedIn(boolean value) throws RemoteException {
        this.loggedIn=value;
    }

    @Override
    public void lerUser(String nomeDoFicheiro, String user) throws RemoteException {
        // Existing code...
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nomeDoFicheiro)));
            System.out.println("File open successful!");

            int lines = 0;
            String line = null;
            line = reader.readLine();
            while (line != null) {
                if (lines >= 1) {

                    String[] divisao = line.split("/");
                    // rethinking
                    this.dia = Integer.parseInt(divisao[0].trim());
                    this.mes = Integer.parseInt(divisao[1].trim());
                    this.ano = Integer.parseInt(divisao[2].trim());
                    this.idSombrinha = String.valueOf(divisao[3]);

                }
                lines++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    @Override
    public void lerPraias(String nomeDoFicheiro) throws RemoteException {
        // Existing code...
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nomeDoFicheiro+".txt")));
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
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
    }

    @Override
    public void start() throws RemoteException {
        // Existing code...


        this.user = "";
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
        this.horadeInicio = 0;
        this.horaFim = 0;
        this.idSombrinha = "";
        this.praia = "";
        this.maxPessoas = 0;
        this.loggedIn = false;
    }

    @Override
    public String pathGetter(String filename) throws RemoteException {
        // Existing code...
        /* We need to verify the input of the user, before it gets here */
        String path = "";
        if (filename != null && filename.length() > 0) {

            switch (filename.charAt(0)) {
                case 'A':
                    path = "/home/miguel/Desktop/plswork/FolderDeTudo/BeachA/" + filename;
                    return path;

                case 'B':
                    path = "/home/miguel/Desktop/plswork/FolderDeTudo/BeachB/" + filename;
                    return path;

                case 'C':
                    path = "/home/miguel/Desktop/plswork/FolderDeTudo/BeachC/" + filename;
                    return path;

                default:
                    path = "/home/miguel/Desktop/plswork/FolderDeTudo/Users/" + filename;
                    return path;
            }
        }
        return path;
    }

    // Implement other methods from FunctionsInterface
    public String write_combiner(String day, String month, String year, String startHour, String endHour, String lastVariable) throws RemoteException{
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + year + "/" + startHour + "/" + endHour + "/" + lastVariable;
    }
    public String array_combiner(String[] array)throws RemoteException{
        StringBuilder magic = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++){
            magic.append(array[i]).append("/");
        }
        return magic + array[array.length - 1];
    }
    public void replaceFileInfo(int line, String originalFileName, String[][] info)throws RemoteException{
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("TempFile" + ".txt"));

            //ciclo que escreve oq tem do outro ficheiro, para dentro de um TempFile
            for (int i = 0; i < info.length; i++) {
                if (i != line) {
                    String thisLine = array_combiner(info[i]);
                    writer.write(thisLine + "\n");
                }
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

        /* Overwrite stuff from old file, with stuff from new file */
        String sourceFileName = "TempFile.txt";
        try (
                BufferedReader reader = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathGetter(originalFileName) + originalFileName + ".txt"))
        ) {
            String line2;
            while ((line2 = reader.readLine()) != null) {
                // Read a line from the source file and write it to the destination file
                writer.write(line2);
                writer.newLine(); // Add a newline for each line if needed
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.err.println("Error cloning content: " + e.getMessage());
        }
    }
    public String[][] user_read_splitter(String file, String path) throws RemoteException{
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        // 0-day, 1-month, 2-year, 3-startHour, 4-endHour, 5-idSombra;

        String[][] dados;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(path +".txt")));
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(path +".txt")));
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
            reader1.close();
            reader.close();
            return dados;
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
        return new String[1][1];
    }
    public boolean user_verificarDisponibilidade(String email) throws RemoteException{
        // (email already being used?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/miguel/Desktop/plswork/FolderDeTudo/Users/"+email + ".txt")));
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return true;
        }
    }

    public boolean user_verifyLogin(String email, String password) throws RemoteException{
        // (emailExiste?PasswordCorreta?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/miguel/Desktop/plswork/FolderDeTudo/Users/"+email + ".txt")));
            System.out.println("File open successful!");
            /* Check if password is correct */
            if (password.equals(reader.readLine().trim())) {
                /* print that the user is logged in */
                reader.close();
                return true;
            }
            reader.close();
            /* print that the password is wrong */
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return false;
        } catch (IOException e) {
            System.out.println("File I/O error!");
            /* print (that the email is wrong) */
            return false;
        }
    }
    public void user_register(String email, String password) throws RemoteException{
        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */
        try {
            /* Need to turn the email lowercase */
            String filePath = "/home/miguel/Desktop/plswork/FolderDeTudo/Users/" + email.toLowerCase(Locale.ROOT) + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(password + "\n");
            // Close the writer to flush and release resources
            writer.close();

            System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            System.out.println("something messed up");
            System.exit(1);
        }
    }
    public String[][] user_listarSombrinhas(String file) throws RemoteException {
        // (Listar as sombrinhas q ele tem no ficheiro)
        /* go into the user Folder and then do this */
        System.out.println("These are your Umbrella reservations:");

        /* Call ReadSplitter and print em out*/
        String path = pathGetter(file);
        String[][] readsplitter = user_read_splitter(file, path);

        // 0-day, 1-month, 2-year, 3-startHour, 4-endHour, 5-idSombra;
        for (int i = 0; i < readsplitter.length; i++) {
            String beach = file.charAt(0) + "";
            System.out.println((i + 1) + " - Beach: " + beach + "DD/MM/YYYY" + readsplitter[0] + "/" + readsplitter[1] + "/" + readsplitter[2]
                    + "start hour: " + readsplitter[3] + "end hour: " + readsplitter[4]);
        }
        /* Beach: X  Date: X  StartHour: X  EndHour: X */
        return readsplitter;
    }
    public void user_reservarSombrinha(String file, String input) throws RemoteException{
        // (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA   input = call write_combiner()      Esse chama o mesmo mas das funcoes da praia)
        /* go into the user Folder and then do this */
        try {
            int count=0;
            BufferedReader in = new BufferedReader(new FileReader(pathGetter(file) + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathGetter(file) + ".txt"));
            System.out.println(pathGetter(file) + ".txt");

            //ciclo rescreve o que ja la esta dentro
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                count++;
            }
            //escreve no fim
            if (count!=0) {
                writer.write(input + "\n");

            }
            writer.close();
            in.close();


        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

    }

    public void user_cancelarSombrinha(int line, String[][] info, String email) throws RemoteException{
        // (GOES WITH PRAIA ONE)
        /* go into the user Folder and then do this */
        String originalFileName = email + ".txt";

        replaceFileInfo(line, originalFileName, info);

        /* Also delete this reservation, inside the umbrella file */
        praia_cancelarSombrinha(email, info[line]);
    }
    public String[][] praia_read_splitter(String file, String path) throws RemoteException{
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        //GUARDA OS DADOS DAS PRAIAS dentro de uma matriz
        String[][] dados=null;
        System.out.println(path);
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(path+".txt")));
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(path+".txt")));
            System.out.println("File open successful!");
            //countLines count lines
            int countLines = 0;
            for (String x = reader1.readLine(); x != null; x = reader1.readLine()) {
                countLines++;

            }
            if (countLines!=0) {
                dados = new String[countLines][6];

                String line = null;
                line = reader.readLine();
                for (int lines = 0; lines < countLines; lines++) {
                    String[] divisao = line.split("/");
                    dados[lines] = divisao;
                    line = reader.readLine();

                }
                reader.close();
                reader1.close();
                return dados;
            }
        } catch (IOException e) {
            System.out.println("File I/O error!");
        }
        return dados;

    }


    public boolean praia_verificarDisponibilidade(String file) throws RemoteException {
        // (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)

        String path = pathGetter(file);
        lerPraias(path);
        String[][] matriz = praia_read_splitter(file, path);
        // O QUE TEM O 1 E A MATRIZ
        boolean returnValue = true;
        if (matriz!=null){
            for (int index = 0; index < matriz.length; index++) {
                if (this.ano == Integer.parseInt(matriz[index][this.year]) && Integer.parseInt(matriz[index][this.month]) == this.mes && this.dia == Integer.parseInt(matriz[index][this.day])) {
                    if (this.horadeInicio >= Integer.parseInt(matriz[index][this.startHour]) && this.horadeInicio < Integer.parseInt(matriz[index][this.endHour])) {
                        returnValue = false;
                    } else if (this.horaFim < Integer.parseInt(matriz[index][this.endHour]) && Integer.parseInt(matriz[index][this.startHour]) < this.horaFim) {
                        returnValue = false;
                    } else {
                        //dps escreve no ficheiro
                        //PRINT("NO FICHEIRO A2 A VAGA ");
                        System.out.println("nao entrou");
                        returnValue = true;
                        break;
                    }
                }
            }
        }
        System.out.println("NADA");
        return returnValue;
    }
    public void praia_listarSombrinhas(String date, int startHour, int endHour) throws RemoteException{
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)

        /* Go through each file with the file_reader , then check if the sombrinha is occupied during those times */
        String beach = this.praia;

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
            String[][] reader = praia_read_splitter(beach + i + ".txt", pathGetter(beach));

            /* if any of the lines have a problem with this date and start/endhour go to the next line, till the matrix is over */
            boolean isFine = true;
            for (int j = 0; j < reader.length; j++){
                String[] currentRead = reader[j];
                String day = currentRead[this.day];
                String month = currentRead[this.month];
                String year = currentRead[this.year];

                int start = Integer.parseInt(currentRead[this.startHour]);
                int end = Integer.parseInt(currentRead[this.endHour]);

                if (requestedDate[this.day].equals(day) && requestedDate[this.month].equals(month) && requestedDate[this.year].equals(year)){
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

    public void praia_reservarSombrinha(String file, String input) throws RemoteException {
        // (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/email) input = call write_combiner()

        try {

            String path = pathGetter(file);
            System.out.println(path);
            BufferedReader in = new BufferedReader(new FileReader(path+".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(path+".txt"));

            //ciclo rescreve o que ja la esta dentro
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                writer.write(x);

            }
            //escreve no fim

            writer.write(input + "\n");
            writer.close();
            in.close();

        } catch (IOException e) {
            System.out.println("File I/O error!");
        }

    }
    public void praia_cancelarSombrinha(String email, String[] info) throws RemoteException {
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)
        String file = this.praia + info[this.idSombra] + ".txt";
        String path = pathGetter(file);
        String[][] thisUmbrella = praia_read_splitter(file, path);

        int removeThisLine = -1;
        for (int i = 0; i < thisUmbrella.length; i++){
            String[] currentLine = thisUmbrella[i];
            if (currentLine[this.email].equals(email)){
                if (currentLine[this.day].equals(info[this.day]) && currentLine[this.month].equals(info[this.month]) &&
                        currentLine[this.year].equals(info[this.year]) && currentLine[this.endHour].equals(info[this.endHour])){
                    removeThisLine = i;
                    break;
                }
            }
        }
        if (removeThisLine == -1){
            System.out.println("Something went wrong!");
        }

        /* Remove the line that we don't need */
        String ogFileName = this.praia + ".txt";
        replaceFileInfo(removeThisLine, ogFileName, thisUmbrella);
    }

    public void praia_quantidadePessoasSombrinha(int maxPeople) throws RemoteException{
        // (qual das sombrinhas a mais apropriada?)
        System.out.println(this.maxPessoas = maxPeople);
        this.maxPessoas = maxPeople;
    }

    public int[] praia_umbrellasNr() throws RemoteException{
        if (this.praia.equals("A")) {
            if (this.maxPessoas <= 2) {
                return this.max2A;
            }
            if (this.maxPessoas <= 3) {
                return this.max3A;
            }
            if (this.maxPessoas <= 4) {
                return this.max4A;
            }

        } else if (this.praia.equals("B")) {
            if (this.maxPessoas <= 2) {
                return this.max2B;
            }
            if (this.maxPessoas <= 3) {
                return this.max3B;
            }
            if (this.maxPessoas <= 4) {
                return this.max4B;
            }
        } else {
            if (this.maxPessoas <= 2) {
                return this.max2C;


            }
        }
        return null;
    }
    public void eachHour() throws RemoteException{
        // (Passa por cada Praia e sombrinha, para ver a horaFim, se a hora fim for igual à hora atual, usa cancelarSombrinha(praia + user))
    }
    /*
     * start()                  (starts everything just like before)
     *
     * praia_read_splitter()        (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
     * user_read_splitter()
     * praia_write_combiner()       (gets all the inputs, writes them with the +"/"+ in the middle etc.)
     * user_write_combiner()
     *
     * praia_Disponibilidade()       (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
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
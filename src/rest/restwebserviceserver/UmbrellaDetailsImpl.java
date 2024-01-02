
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;




import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.Locale;
import java.util.Arrays;


@Consumes("application/json")
@Produces("application/json")
public class UmbrellaDetailsImpl implements UmbrellaDetails   {

    @POST
    @Path("/input")
    public String input(String input) {
        char thisInput='0';
        if (input != null) {
            thisInput = input.trim().charAt(0);

            /* Check if input is correct */
            if (!(thisInput == '1' || thisInput == '2')) {
                return "Invalid input";
            }
            return "Valid Input";

        } else {
            return "Invalid input";
        }
    }

    @POST
    @Path("/disponivel")
    public String user_verificarDisponibilidade(String email)  {
        // (email already being used?)
        /* go into the user Folder and then do this */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrador\\eclipse-workspace\\rest_webservice1.0\\src\\plsworkrest\\Users\\" + email + ".txt")));
            return "false";
        } catch (FileNotFoundException e) {
            //System.out.println("File Not Found");
            return "true";
        }
    }
    @POST
    @Path("/verificaLogin")
    public String user_verifyLogin(String emailepassword)  {
        // (emailExiste?PasswordCorreta?)
        /* go into the user Folder and then do this */
        try {
            String[] resultList = emailepassword.split(",");
            String email = resultList[0];
            String password = resultList[1];


            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrador\\eclipse-workspace\\rest_webservice1.0\\src\\plsworkrest\\Users\\" + email + ".txt")));
            //System.out.println("File open successful!");
            /* Check if password is correct */
            if (password.equals(reader.readLine().trim())) {
                /* print that the user is logged in */
                reader.close();
                return "true";
            }
            reader.close();
            /* print that the password is wrong */
            return "false";
        } catch (FileNotFoundException e) {
            //  System.out.println("File Not Found");
            return "false";
        } catch (IOException e) {
            // System.out.println("File I/O error!");
            /* print (that the email is wrong) */
            return "false";
        }
    }
    @POST
    @Path("/criaFileUser")
    public String user_register(String emailepassword) {
        BufferedWriter writer = null;
        try {
            String[] resultList = emailepassword.split(",");
            String email = resultList[0];
            String password = resultList[1];

            /* Need to turn the email lowercase */
            String filePath = "C:\\Users\\Administrador\\eclipse-workspace\\rest_webservice1.0\\src\\plsworkrest\\Users\\" + email + ".txt";

            writer = new BufferedWriter(new FileWriter(new File(filePath)));
            writer.write(password + "\n");

            return "";

        } catch (IOException e) {
            e.printStackTrace(); // Log the exception
            return "Failed";
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // Log the exception
            }
        }
    }
    @POST
    @Path("/criaFileUser1")
    public String user_cria(String emailepassword) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf;
            try {
                addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
                String[] resultList = emailepassword.split(",");
                String email = resultList[0];
                String password = resultList[1];
                addServerIntf.user_cria(email, password);
                return "OKI";
            } catch (NotBoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        }
        return "Failed";
    }


    @GET
    @Path("/getPraia")
    public String getPraia() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            return addServerIntf.getpraia();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @GET
    @Path("/getDay")
    public String getDay() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getday();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getMonth")
    public String getMonth() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getmonth();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getYear")
    public String getYear() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getyear();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getStartHour")
    public String getStartHour() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getstartHour();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getEndHour")
    public String getEndHour() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getendHour();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getIdSombra")
    public String getIdSombra() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getidSombra();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getEmail1")
    public String getEmail1() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getemail1();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getUser")
    public String getUser() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getuser();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getDia")
    public String getDia() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getdia();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getMes")
    public String getMes() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getmes();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getAno")
    public String getAno() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getano();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @GET
    @Path("/getHoradeInicio")
    public String getHoradeInicio() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.gethoradeInicio();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getHoraFim")
    public String getHoraFim() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.gethoraFim();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/getIdSombrinha")
    public String getIdSombrinha() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getidSombrinha();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @GET
    @Path("/getMaxPessoas")
    public String getMaxPessoas() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.getmaxPessoas();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @GET
    @Path("/start")
    public String start() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            return addServerIntf.start();
            /* Need to turn the email lowercase */


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @POST
    @Path("/praia_quantidadePessoasSombrinha")
    public String praia_quantidadePessoasSombrinha(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String[] resultList = input.split(",");
            int maxPeople = Integer.parseInt(resultList[0]);

            addServerIntf.praia_quantidadePessoasSombrinha(maxPeople);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changepraia")
    public String changepraia(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            addServerIntf.changepraia(input);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changedia")
    public String changedia(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            int dia = Integer.parseInt(input);

            addServerIntf.changedia(dia);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changemes")
    public String changemes(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);

            int mes = Integer.parseInt(input);

            addServerIntf.changemes(mes);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changeano")
    public String changeano(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            int ano = Integer.parseInt(input);

            addServerIntf.changeano(ano);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changestarthour")
    public String changestarthour(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            int starthour = Integer.parseInt(input);

            addServerIntf.changestarthour(starthour);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/changeendhour")
    public String changeendhour(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            int endhour = Integer.parseInt(input);

            addServerIntf.changeendhour(endhour);
            /* Need to turn the email lowercase */
            return "";

            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @POST
    @Path("/praia_verificarDisponibilidade")
    public String praia_verificarDisponibilidade(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);


            if(addServerIntf.praia_verificarDisponibilidade(input)==true) {
                return "true";
            }else {
                return "false";
            }


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }


    @POST
    @Path("/praia_umbrellasNr")
    public String praia_umbrellasNr() {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = null;
            addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String retorno="";
            int[] thisArray =addServerIntf.praia_umbrellasNr();
            for (int i =0 ;i<thisArray.length;i++) {
                retorno=retorno+Integer.toString(thisArray[i]).trim()+",";


            }
            return retorno;


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @POST
    @Path("/write_combiner")
    public String write_combiner(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String[] thisArray =input.split(",");


            return addServerIntf.write_combiner(thisArray[0],thisArray[1],thisArray[2],thisArray[3],thisArray[4],thisArray[5]);


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/praia_reservarSombrinha")
    public String praia_reservarSombrinha(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String[] thisArray =input.split(",");

            addServerIntf.praia_reservarSombrinha(thisArray[0],thisArray[1]);
            return "";


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }

    @POST
    @Path("/user_reservarSombrinha")
    public String user_reservarSombrinha(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String[] thisArray =input.split(",");

            addServerIntf.user_reservarSombrinha(thisArray[0],thisArray[1]);
            return "";


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    String[][] thisUserFile=null;
    @POST
    @Path("/user_listarSombrinhas")
    public String user_listarSombrinhas(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String retorno = "";
            thisUserFile= addServerIntf.user_listarSombrinhas(input);
            retorno="These are your Umbrella reservations:\n";
            int count1 = 1;
            for (String[] line : thisUserFile) {

                retorno=retorno+count1 + "- " + Arrays.toString(line)+"\n";
                count1++;
            }
            retorno=count1+retorno;
            return retorno;


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/user_cancelarSombrinha")
    public String user_cancelarSombrinha(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            //user_cancelarSombrinha(String linha,String newString,String email)



            String [] retorno = input.split(",");
            int line1 = Integer.parseInt(retorno[0]);
            addServerIntf.user_cancelarSombrinha(line1,thisUserFile,retorno[1]);


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }
    @POST
    @Path("/praia_listarSombrinhas")
    public String praia_listarSombrinhas(String input) {


        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
        /* go into the user Folder and then do this */

        try {
            String addServerURL = "rmi://192.168.56.101/FunctionsServer";
            FunctionsInterface addServerIntf = (FunctionsInterface) Naming.lookup(addServerURL);
            String retorno[] = input.split(",");

            return addServerIntf.praia_listarSombrinhas(retorno[0],Integer.parseInt(retorno[1]), Integer.parseInt(retorno[2]));


            // System.out.println("Write successful!");

            /* print user has been registered */
        } catch (IOException e) {
            //   System.out.println("something messed up");
            System.exit(1);
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Failed";
    }




    //int i =Integer.parseInt(numero1)+Integer.parseInt(numero2);
}
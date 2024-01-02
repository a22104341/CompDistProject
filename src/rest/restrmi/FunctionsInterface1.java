package rest.restrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FunctionsInterface1 extends Remote {

    String getpraia() throws RemoteException;
    String changepraia(String value) throws RemoteException;
    String getday() throws RemoteException;

    String getmonth() throws RemoteException;

    String getyear() throws RemoteException;

    String getstartHour() throws RemoteException;

    String getendHour() throws RemoteException;

    String getidSombra() throws RemoteException;

    String getemail1() throws RemoteException;

    String getuser() throws RemoteException;

    String getdia() throws RemoteException;

    String getmes() throws RemoteException;
    String getano() throws RemoteException;
    String gethoradeInicio() throws RemoteException;
    String gethoraFim() throws RemoteException;
    String getidSombrinha() throws RemoteException;
    String getmaxPessoas() throws RemoteException;


    void changedia(int value) throws RemoteException;
    void changemes(int value) throws RemoteException;
    void changeano(int value) throws RemoteException ;
    void changestarthour(int value) throws RemoteException;
    void changeendhour(int value) throws RemoteException ;
    void lerUser(String nomeDoFicheiro, String user) throws RemoteException;

    void lerPraias(String nomeDoFicheiro) throws RemoteException;

    String start() throws RemoteException;

    String pathGetter(String filename) throws RemoteException;

    // Add other methods from your Functions class as needed
    String write_combiner(String day, String month, String year, String startHour, String endHour, String lastVariable) throws RemoteException;

    String array_combiner(String[] array) throws RemoteException;
    void replaceFileInfo(int line, String originalFileName, String[][] info) throws RemoteException;
    String[][] user_read_splitter(String file, String path) throws RemoteException;

    //  boolean user_verificarDisponibilidade(String email) throws RemoteException;
    //boolean user_verifyLogin(String email, String password) throws RemoteException;
    // void user_register(String email, String password) throws RemoteException;
    String[][] user_listarSombrinhas(String file) throws RemoteException;
    void user_reservarSombrinha(String file, String input) throws RemoteException;
    void user_cancelarSombrinha(int line, String[][] info, String email) throws RemoteException;
    String[][] praia_read_splitter(String file, String path) throws RemoteException;
    boolean praia_verificarDisponibilidade(String file) throws RemoteException;
    String praia_listarSombrinhas(String date, int startHour, int endHour) throws RemoteException;
    void user_cria(String email,String password) throws RemoteException;
    void praia_reservarSombrinha(String file, String input) throws RemoteException;
    void praia_cancelarSombrinha(String email, String[] info) throws RemoteException;
    void praia_quantidadePessoasSombrinha(int maxPeople) throws RemoteException;
    String praia_umbrellasNr() throws RemoteException;




}

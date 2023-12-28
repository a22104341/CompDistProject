import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FunctionsInterface extends Remote {

    String getpraia() throws RemoteException;
    void changepraia(String value) throws RemoteException;
    int getday() throws RemoteException;

    int getmonth() throws RemoteException;

    int getyear() throws RemoteException;

    int getstartHour() throws RemoteException;

    int getendHour() throws RemoteException;

    int getidSombra() throws RemoteException;

    int getemail1() throws RemoteException;
    int[] getmax2A() throws RemoteException;

    int[] getmax3A() throws RemoteException;

    int[] getmax4A() throws RemoteException;

    int[] getmax2B() throws RemoteException;

    int[] getmax3B() throws RemoteException;

    int[] getmax4B() throws RemoteException;


    int[] getmax2C() throws RemoteException;

    String getuser() throws RemoteException;

    int getdia() throws RemoteException;

    int getmes() throws RemoteException;
    int getano() throws RemoteException;
    int gethoradeInicio() throws RemoteException;
    int gethoraFim() throws RemoteException;
    String getidSombrinha() throws RemoteException;
    int getmaxPessoas() throws RemoteException;
    boolean getloggedIn() throws RemoteException;
    void changeloggedIn(boolean value) throws RemoteException;

    void changedia(int value) throws RemoteException;
    void changemes(int value) throws RemoteException;
    void changeano(int value) throws RemoteException ;
    void changestarthour(int value) throws RemoteException;
    void changeendhour(int value) throws RemoteException ;
    void lerUser(String nomeDoFicheiro, String user) throws RemoteException;

    void lerPraias(String nomeDoFicheiro) throws RemoteException;

    void start() throws RemoteException;

    String pathGetter(String filename) throws RemoteException;

    // Add other methods from your Functions class as needed
    String write_combiner(String day, String month, String year, String startHour, String endHour, String lastVariable) throws RemoteException;

    String array_combiner(String[] array) throws RemoteException;
    void replaceFileInfo(int line, String originalFileName, String[][] info) throws RemoteException;
    String[][] user_read_splitter(String file, String path) throws RemoteException;

    boolean user_verificarDisponibilidade(String email) throws RemoteException;
    boolean user_verifyLogin(String email, String password) throws RemoteException;
    void user_register(String email, String password) throws RemoteException;
    String[][] user_listarSombrinhas(String file) throws RemoteException;
    void user_reservarSombrinha(String file, String input) throws RemoteException;
    void user_cancelarSombrinha(int line, String[][] info, String email) throws RemoteException;
    String[][] praia_read_splitter(String file, String path) throws RemoteException;
    boolean praia_verificarDisponibilidade(String file) throws RemoteException;
    void praia_listarSombrinhas(String date, int startHour, int endHour) throws RemoteException;
    void praia_reservarSombrinha(String file, String input) throws RemoteException;
    void praia_cancelarSombrinha(String email, String[] info) throws RemoteException;
    void praia_quantidadePessoasSombrinha(int maxPeople) throws RemoteException;
    int[] praia_umbrellasNr() throws RemoteException;
    void eachHour() throws RemoteException;




}

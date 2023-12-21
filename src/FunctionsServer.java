import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FunctionsServer {
    public static void main(String[] args) {
        try {
            Functions functions = new Functions();

            // Create a registry and bind the remote object's stub in the registry
            LocateRegistry.createRegistry(1099); // Default RMI registry port
            Naming.rebind("Functions", functions);

            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

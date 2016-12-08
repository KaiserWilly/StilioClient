import network.Array;
import network.InifQueryClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by JD Isenhart on 12/6/2016.
 * Testing RMI creation in Java 8
 */
public class Main {
    public static void main(String[] args) {
        String queryIP = args[0];
        int queryPort = Integer.parseInt(args[1]);
        try {
            Registry registry = LocateRegistry.getRegistry(queryIP, queryPort); //IP Address of RMI Server, port of RMIRegistry
            InifQueryClient stub = (InifQueryClient) registry.lookup("QueryClient");
            Array server = stub.assignToArray();
        } catch (Exception e) {
            System.err.println("Unable to find Query Server!");
        }


    }
}

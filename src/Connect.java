//import network.Array;
//import network.Client;
//import network.InifQueryClient;
//import network.shards.InifCore;
//
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
///**
// * Created by james on 12/8/2016.
// */
//public class Connect {
//
//
//    public Client connectToQuery(String queryIP, int queryPort, String playerName, String playerIP, int playerPort, String version) {
//        Client player = new Client(playerName, playerIP, playerPort);
//        try {
//            Registry registry = LocateRegistry.getRegistry(queryIP, queryPort); //IP Address of RMI Server, port of RMIRegistry
//            InifQueryClient stub = (InifQueryClient) registry.lookup("QueryClient");
//            Array server = stub.assignToArray(player);
//            player.setServer(server);
//            registerWithCore(player);
//            System.out.println("Connected to Server! IP:" + server.getQueryIP());
//            return player;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Unable to connect to server!");
//            return null;
//        }
//    }
//
//    public void registerWithCore(Client c) {
//        try {
//            Registry registry = LocateRegistry.getRegistry(c.getCoreIP(), c.getCorePort()); //IP Address of RMI Server, port of RMIRegistry
//            InifCore stub = (InifCore) registry.lookup("Core");
//            stub.registerClient(c);
//        } catch (Exception e) {
//            e.printStackTrace();
//         System.out.println("Unable to register client with Core!");
//        }
//    }
//}



import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public Server() {
    }

    public static void main(String[] args) {
        try {
            Encyclopedia obj = new EncyclopediaImpl();
            LocateRegistry.createRegistry(1024);
            Naming.rebind("//localhost/Encyclopedia", obj);
            System.out.println("Server started");
        } catch (Exception var2) {
            System.out.println("Server exception: " + String.valueOf(var2));
        }

    }
}
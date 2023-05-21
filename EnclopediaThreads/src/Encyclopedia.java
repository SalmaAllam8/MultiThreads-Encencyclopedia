import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;


    public interface Encyclopedia extends Remote {
        int count(String var1) throws RemoteException;

        List<String> repeatedWords(String var1) throws RemoteException;

        String longest(String var1) throws RemoteException;

        String shortest(String var1) throws RemoteException;

        HashMap<String, Integer> repeat(String var1) throws RemoteException;
    }



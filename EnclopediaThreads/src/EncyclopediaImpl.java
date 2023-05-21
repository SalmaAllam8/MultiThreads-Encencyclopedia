
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EncyclopediaImpl extends UnicastRemoteObject implements Encyclopedia {
    protected EncyclopediaImpl() throws RemoteException {
    }

    public int count(String data) throws RemoteException {
        return data.length();
    }

    public List<String> repeatedWords(String data) throws RemoteException {
        String[] words = data.split("\\s+");
        List<String> repeated = new ArrayList();
        Arrays.sort(words);

        for(int i = 1; i < words.length; ++i) {
            if (words[i].equals(words[i - 1]) && !repeated.contains(words[i])) {
                repeated.add(words[i]);
            }
        }

        return repeated;
    }

    public String longest(String data) throws RemoteException {
        String[] words = data.split("\\s+");
        String longest = "";
        String[] var4 = words;
        int var5 = words.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String word = var4[var6];
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    public String shortest(String data) throws RemoteException {
        String[] words = data.split("\\s+");
        String shortest = words[0];
        String[] var4 = words;
        int var5 = words.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String word = var4[var6];
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }

        return shortest;
    }

    public HashMap<String, Integer> repeat(String data) throws RemoteException {
        String[] words = data.split("\\s+");
        HashMap<String, Integer> repeats = new HashMap();
        String[] var4 = words;
        int var5 = words.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String word = var4[var6];
            if (repeats.containsKey(word)) {
                repeats.put(word, (Integer)repeats.get(word) + 1);
            } else {
                repeats.put(word, 1);
            }
        }

        return repeats;
    }
}

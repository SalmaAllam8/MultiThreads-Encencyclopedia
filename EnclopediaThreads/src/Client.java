import java.rmi.Naming;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Client implements Runnable {
    private String data;
    private Encyclopedia encyclopedia;

    public Client(String data, Encyclopedia encyclopedia) {
        this.data = data;
        this.encyclopedia = encyclopedia;
    }

    public void run() {
        try {
            long start = System.currentTimeMillis();
            int count = encyclopedia.count(data);
            List<String> repeated = encyclopedia.repeatedWords(data);
            String longest = encyclopedia.longest(data);
            String shortest = encyclopedia.shortest(data);
            HashMap<String, Integer> repeats = encyclopedia.repeat(data);
            long end = System.currentTimeMillis();
            System.out.println("Number of letters: " + count);
            System.out.println("Repeated words: " + repeated);
            System.out.println("Longest word: " + longest);
            System.out.println("Shortest word: " + shortest);
            System.out.println("Repeats: " + repeats);
            System.out.println("Time taken (ms): " + (end - start));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Encyclopedia encyclopedia = (Encyclopedia) Naming.lookup("rmi://localhost/encyclopedia");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the data:");
            String data = scanner.nextLine();

            Client countClient = new Client(data, encyclopedia);
            Client repeatedClient = new Client(data, encyclopedia);
            Client longestClient = new Client(data, encyclopedia);
            Client shortestClient = new Client(data, encyclopedia);
            Client repeatsClient = new Client(data, encyclopedia);

            Thread countThread = new Thread(countClient);
            Thread repeatedThread = new Thread(repeatedClient);
            Thread longestThread = new Thread(longestClient);
            Thread shortestThread = new Thread(shortestClient);
            Thread repeatsThread = new Thread(repeatsClient);

            countThread.start();
            repeatedThread.start();
            longestThread.start();
            shortestThread.start();
            repeatsThread.start();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
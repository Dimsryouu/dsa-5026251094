package lw03.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }

    static void problem1() {
        Scanner input1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();
        while (input1.hasNextLine()) {
            String[] p = input1.nextLine().split(" ", 2);
            if (p[0].equals("ADD")) {
                playlist.add(p[1]);
            } else if (p[0].equals("INSERT")) {
                String[] q = p[1].split(" ", 2);
                playlist.add(Integer.parseInt(q[0]), q[1]);
            } else if (p[0].equals("REMOVE")) {
                playlist.remove(p[1]);
            }
        }
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        input1.close();
    }

    static void problem2() {
        Scanner input2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;
        while (input2.hasNextLine()) {
            if (!participants.add(input2.nextLine())) {
                duplicates++;
            }
        }
        System.out.println("\n===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int no = 1;
        for (String name : participants) {
            System.out.println(no + ". " + name);
            no++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
        
        input2.close();
    }

    static void problem3() {
        Scanner input3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failed = 0;
        while (input3.hasNext()) {
            String type = input3.next();
            String product = input3.next();
            int quantiti = input3.nextInt();
            if (type.equals("ADD")) {
                stock.put(product, stock.getOrDefault(product, 0) + quantiti);
            } else if (stock.containsKey(product) && stock.get(product) >= quantiti) {
                stock.put(product, stock.get(product) - quantiti);
            } else {
                failed++;
            }
        }
        System.out.println("\n===== Problem 3 =====");
        for (String product : stock.keySet()) {
            System.out.println(product + ": " + stock.get(product));
        }
        System.out.println("Failed sales: " + failed);
        
        input3.close();
    }
}
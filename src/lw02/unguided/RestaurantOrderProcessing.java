package lw02.unguided;
import java.util.*;

public class RestaurantOrderProcessing {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failOrder = new Stack<>();

        Scanner scanner = new Scanner(RestaurantOrderProcessing.class.getResourceAsStream("orders.txt"));

        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        while(scanner.hasNext()){
            String[] storeData = new String[4];
            storeData[0] = scanner.next();
            storeData[1] = scanner.next();
            storeData[2] = scanner.next();
            storeData[3] = scanner.next();
            orders.add(storeData);
        }

        scanner.close();

        for (String[] order : orders) {
            queue.add(order);
        }

        while (!queue.isEmpty()) {
            String[] order = queue.poll();

            String namaFood = order[1];
            String namaDrink = order[2];

            String[] daftarFood = null;
            String[] daftarDrink = null;
            boolean available = true;
            
            if (!namaFood.equals("-")) {
                for(String[] food : foods) {
                    if(food[0].equals(namaFood)) {
                        daftarFood = food;
                        break;
                    }
                }
                if (Integer.parseInt(daftarFood[1]) <= 0) {
                    available = false;
                }
            }

            if(!namaDrink.equals("-")){
                for(String[] drink : drinks){
                    if(drink[0].equals(namaDrink)){
                        daftarDrink = drink;
                        break;
                    }
                }
                if (Integer.parseInt(daftarDrink[1]) <= 0) {
                    available = false;
                }
            }

            if(available){
                if(daftarFood != null){
                    int record = Integer.parseInt(daftarFood[1]);
                    daftarFood[1] = String.valueOf(record - 1);
                }
                if(daftarDrink != null){
                    int record = Integer.parseInt(daftarDrink[1]);
                    daftarDrink[1] = String.valueOf(record -1);
                }
                success.add(order);
            } else {
                failOrder.add(order);
            }
        }

        System.out.println("\n=== Successfully Processed Orders === ");
        for(String[] succes : success){
            System.out.println(succes[0] + " " + succes[1] + " "+ succes[2] + " " + succes[3]);
        }

        System.out.println("\n=== Remaining Food Stock ===");
        for(String[] makanan : foods){
            System.out.println(makanan[0] + " : " + makanan[1]);
        }

        System.out.println("\n=== Remaining Drink Stock ===");
        for(String[] minuman : drinks){
            System.out.println(minuman[0] + " : " + minuman[1]);
        }

        System.out.println("\n=== Failed Orders === ");
        while (!failOrder.isEmpty()) {
            String[] orderGagal = failOrder.pop();
            System.out.println(orderGagal[0] + " " + orderGagal[1] + " " + orderGagal[2] + " " + orderGagal[3]);
        }
    }   
}

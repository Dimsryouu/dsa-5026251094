package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int n = scanner.nextInt();

        WashService[] wash = new WashService[n];
        int[] unitsArray = new int[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            unitsArray[i] = units;

        if (type.equals("MOTORCYCLE")) {
            wash[i] = new MotorcycleWash(id, days);
        } else if (type.equals("CAR")) {
            wash[i] = new CarWash(id, days);
        }
    }
            

        for (int i = 0; i < n; i++) {
           System.out.println(wash[i].summary(unitsArray[i]));
        }
        scanner.close();

        
    }
}
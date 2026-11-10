package lw04.unguided;
import java.util.*;

public class Main {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int[] after2Passes = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            
            if (i == 1) {
                for (int k = 0; k < n; k++) {
                    after2Passes[k] = arr[k];
                }
            }
        }

        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < n; i++) {
            System.out.print(after2Passes[i]);
            if (i < n - 1){
                System.out.print(" ");
            } 
        }
        System.out.println();
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1){
                System.out.print(" ");
            } 
        }
        System.out.println();
        System.out.println();
    }

    public static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;
        boolean found = false;
        int foundIndex = -1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                found = true;
                foundIndex = mid;
                break; 
            } else if (target > arr[mid]) {
                high = mid - 1;
            } else if (target < arr[mid]){
                low = mid + 1;
            }
        }

        if (found) {
            System.out.println(target + ": FOUND at index " + foundIndex + " (steps: " + steps + ")");
        } else {
            System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targetSearching = new int[m];
        for(int i = 0; i < m; i++){
            targetSearching[i] = sc.nextInt();
        }

        bubbleSort(array);

        System.out.println("==== Search Result ====");
        for(int i = 0; i < targetSearching.length; i++){
            binarySearch(array, targetSearching[i]);
        }

        sc.close();
    }

}
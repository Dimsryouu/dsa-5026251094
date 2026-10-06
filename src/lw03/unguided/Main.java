package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Set<String> register = new HashSet<>();
        Set<String> checkedIn = new HashSet<>();
        List<String> result = new ArrayList<>();
        int reject = 0;

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        while(sc1.hasNext()){
            register.add(sc1.next());
        }

        sc1.close();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        while(sc2.hasNext()){
            String id_mahasiswa = sc2.next();
            if(!register.contains(id_mahasiswa)){
                result.add(id_mahasiswa + ": Rejected (not registered)");
                reject++;
            } else if (checkedIn.contains(id_mahasiswa)){
                result.add(id_mahasiswa + ": Rejected (already checked in)");
                reject++;
            } else {
                checkedIn.add(id_mahasiswa);
                result.add(id_mahasiswa + ": Checked in");
            }
        }

        sc2.close();

        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println();   
        System.out.println("=== Final Event Summary ===");
        System.out.println("Registered Student: " + register.size());
        System.out.println("Successful checks-in: " + checkedIn.size());
        System.out.println("Absent students: " + (register.size() - checkedIn.size()));
        System.out.println("Rejected Attempt: " + reject);
    }
}
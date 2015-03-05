/*Testklasse for sub-klassene av 'Kort'. */

import java.util.ArrayList;

public class TestKort {
	
    public static void main(String[] args) {
        
        ArrayList<Kort> reg = new ArrayList<Kort>();
        
        Kort k1 = new Ansatt("Ole Olsen", 1234, 149.5, 6);
        Kort k2 = new Gjest("Marit Olsen");
        Kort k3 = new Gjest("Bjørg Olaug");
        Kort k4 = new Gjest("Johan Udrum");
        Kort k5 = new Gjest("Lise Dalbru");
        Kort k6 = new Gjest("Lise Dalbru");
        
        reg.add(k1);
        reg.add(k2);
        reg.add(k3);
        reg.add(k4);
        reg.add(k5);
        reg.add(k6);
        
        reg.sort(null);
        System.out.println("Listen med kort er nå sortert alfabetisk\n");
        
        for(int i=0; i<reg.size(); i++) {
            Kort kort = (Kort)reg.get(i);
            System.out.println(kort);
            System.out.println("\nTest av kort med kode 1234 er" + (kort.sjekkPin(1234) ?  " gyldig" :  " ugyldig" ) );
            System.out.println("\nTest av kort med kode 9999 er" + (kort.sjekkPin(9999) ?  " gyldig\n" :  " ugyldig\n" ) );
        }
        System.out.println("Tester Ansatt.clone: k1.clone() == k1 : " + (k1.clone() == k1));
        System.out.println("\n\tk1:\n" + k1 + "\n\n\tk1.clone():\n" + k1.clone());
        
        System.out.println("\nTester Gjest.clone: k2.clone() == k2 : " + (k2.clone() == k2));
        System.out.println("\n\tk2:\n" + k2 + "\n\n\tk2.clone():\n" + k2.clone());
        
    }
}
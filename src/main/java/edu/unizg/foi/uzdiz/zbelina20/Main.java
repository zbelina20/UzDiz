package edu.unizg.foi.uzdiz.zbelina20;

import edu.unizg.foi.uzdiz.zbelina20.Models.Vozilo;
import edu.unizg.foi.uzdiz.zbelina20.Utils.LoaderVozila;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Provjera broja argumenata
        if (args.length < 2) {
            System.out.println("Nedovoljno argumenata. Koristite: java -jar naziv.jar --zps datoteka_vozila.csv");
            return;
        }

        List<Vozilo> vozila = null;

        // Učitaj podatke iz datoteke
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--zps")) {
                vozila = LoaderVozila.ucitajVozila(args[++i]);
            }
        }

        // Ispiši učitane podatke
        System.out.println("Ucitana vozila:");
        if (vozila != null) {
            for (Vozilo vozilo : vozila) {
                System.out.println(vozilo);
            }
        } else {
            System.out.println("Nema ucanih vozila.");
        }
    }
}
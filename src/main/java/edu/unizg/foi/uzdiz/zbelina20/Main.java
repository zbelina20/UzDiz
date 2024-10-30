package edu.unizg.foi.uzdiz.zbelina20;

import edu.unizg.foi.uzdiz.zbelina20.Models.Vozilo;
import edu.unizg.foi.uzdiz.zbelina20.Utils.LoaderVozila;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Nedovoljno argumenata.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String komanda = scanner.nextLine().trim();

            if (komanda.equalsIgnoreCase("Q")) {
                System.out.println("Prekid rada programa.");
                break;
            }

            obradiKomandu(komanda);
        }

        scanner.close();
    }

    private static void obradiKomandu(String komanda) {
        System.out.println("Komanda obrađena.");
    }
}
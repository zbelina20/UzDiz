package edu.unizg.foi.uzdiz.zbelina20;

import edu.unizg.foi.uzdiz.zbelina20.Models.Vozilo;
import edu.unizg.foi.uzdiz.zbelina20.Utils.LoaderKompozicija;
import edu.unizg.foi.uzdiz.zbelina20.Utils.LoaderStanica;
import edu.unizg.foi.uzdiz.zbelina20.Utils.LoaderVozila;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Nedovoljno argumenata.");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--zs":
                    if (i + 1 < args.length) {
                        String datotekaStanica = args[i + 1];
                        System.out.println("\nUčitavanje stanica iz datoteke: " + datotekaStanica + "\n");
                        LoaderStanica.ucitajStanice(datotekaStanica);
                        i++;
                    }
                    break;
                case "--zps":
                    if (i + 1 < args.length) {
                        String datotekaVozila = args[i + 1];
                        System.out.println("\nUčitavanje vozila iz datoteke: " + datotekaVozila + "\n");
                        LoaderVozila.ucitajVozila(datotekaVozila);
                        i++;
                    }
                    break;
                case "--zk":
                    if (i + 1 < args.length) {
                        String datotekaKompozicija = args[i + 1];
                        System.out.println("\nUčitavanje kompozicija iz datoteke: " + datotekaKompozicija + "\n");
                        LoaderKompozicija.ucitajKompozicije(datotekaKompozicija);
                        i++;
                    }
                    break;
                default:
                    System.out.println("Nepoznata opcija: " + args[i]);
                    break;
            }
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

    private static void obradiKomandu (String komanda){
        System.out.println("Komanda " + komanda + " obrađena.");
    }
}
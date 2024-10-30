package edu.unizg.foi.uzdiz.zbelina20.Utils;

import edu.unizg.foi.uzdiz.zbelina20.Models.Kompozicija;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoaderKompozicija {
    public static List<Kompozicija> ucitajKompozicije(String nazivDatoteke) {
        List<Kompozicija> kompozicije = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivDatoteke), StandardCharsets.UTF_8))) {
            String linija;
            int brojLinije = 0;

            br.readLine();

            while ((linija = br.readLine()) != null) {
                brojLinije++;
                if (linija.trim().isEmpty()) continue;

                String[] dijelovi = linija.split(";");
                if (dijelovi.length != 14) {
                    System.out.printf("Greška u datoteci %s, red %d: Neispravan broj stupaca\n", nazivDatoteke, brojLinije);
                    continue;
                }

                try {
                    String oznaka = dijelovi[0].trim();
                    String oznakaPrijevoznogSredstva = dijelovi[1].trim();
                    String uloga = dijelovi[2].trim();

                    kompozicije.add(new Kompozicija(oznaka, oznakaPrijevoznogSredstva, uloga));
                } catch (NumberFormatException e) {
                    System.out.printf("Greška u datoteci %s, red %d: Neispravan format za broj\n", nazivDatoteke, brojLinije);
                }
            }
        } catch (IOException e) {
            System.out.println("Greška pri čitanju datoteke: " + e.getMessage());
        }

        return kompozicije;
    }
}

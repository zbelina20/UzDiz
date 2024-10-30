package edu.unizg.foi.uzdiz.zbelina20.Utils;

import edu.unizg.foi.uzdiz.zbelina20.Models.Kompozicija;
import edu.unizg.foi.uzdiz.zbelina20.Models.Stanica;

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
        int ukupnePogreske = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivDatoteke), StandardCharsets.UTF_8))) {
            String linija;
            int brojLinije = 1;

            br.readLine();

            while ((linija = br.readLine()) != null) {
                brojLinije++;
                if (linija.trim().isEmpty()) continue;

                String[] dijelovi = linija.split(";");
                if (dijelovi.length != 3) {
                    ukupnePogreske++;
                    System.out.printf("Greška %d u datoteci %s, red %d: Neispravan broj stupaca (%d umjesto 14). Sadržaj: %s\n",
                            ukupnePogreske, nazivDatoteke, brojLinije, dijelovi.length, linija);
                    continue;
                }

                try {
                    String oznaka = dijelovi[0].trim();
                    String oznakaPrijevoznogSredstva = dijelovi[1].trim();
                    String uloga = dijelovi[2].trim();

                    kompozicije.add(new Kompozicija(oznaka, oznakaPrijevoznogSredstva, uloga));
                } catch (NumberFormatException e) {
                    ukupnePogreske++;
                    System.out.printf("Greška %d u datoteci %s, red %d: Neispravan format za broj. Sadržaj: %s\n",
                            ukupnePogreske, nazivDatoteke, brojLinije, linija);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ukupnePogreske++;
                    System.out.printf("Greška %d u datoteci %s, red %d: Neispravan indeks. Sadržaj: %s\n",
                            ukupnePogreske, nazivDatoteke, brojLinije, linija);
                }
            }
        } catch (IOException e) {
            System.out.println("Greška pri čitanju datoteke: " + e.getMessage());
        }

        System.out.println("Kompozicije uspješno učitane!");
        if (ukupnePogreske > 0) {
            System.out.printf("Ukupno pogrešaka: %d\n", ukupnePogreske);
        }
        return kompozicije;
    }
}

package edu.unizg.foi.uzdiz.zbelina20.Utils;

import edu.unizg.foi.uzdiz.zbelina20.Models.Pruga;
import edu.unizg.foi.uzdiz.zbelina20.Models.Stanica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoaderStanicaPruga {
    public static List<Stanica> ucitajDatotekuStanica(String nazivDatoteke) {
        List<Stanica> stanice = new ArrayList<>();
        List<Pruga> pruge = new ArrayList<>();
        int ukupnePogreske = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivDatoteke), StandardCharsets.UTF_8))) {
            String linija;
            int brojLinije = 1;

            br.readLine();

            while ((linija = br.readLine()) != null) {
                brojLinije++;
                if (linija.trim().isEmpty()) continue;

                String[] dijelovi = linija.split(";");
                if (dijelovi.length != 14) {
                    ukupnePogreske++;
                    System.out.printf("Greška %d u datoteci %s, red %d: Neispravan broj stupaca (%d umjesto 14). Sadržaj: %s\n",
                            ukupnePogreske, nazivDatoteke, brojLinije, dijelovi.length, linija);
                    continue;
                }

                try {
                    String stanica = dijelovi[0].trim();
                    String oznakaPruge = dijelovi[1].trim();
                    String vrstaStanice = dijelovi[2].trim();
                    String statusStanice = dijelovi[3].trim();
                    String ulazIzlazPutnika = dijelovi[4].trim();
                    String utovarIstovarRobe = dijelovi[5].trim();
                    String kategorijaPruge = dijelovi[6].trim();
                    int brojPerona = Integer.parseInt(dijelovi[7].trim());
                    String vrstaPruge = dijelovi[8].trim();
                    int brojKolosjeka = Integer.parseInt(dijelovi[9].trim());
                    double DOPoOsovini = Double.parseDouble(dijelovi[10].trim().replace(",", "."));
                    double DOPoDuznomM = Double.parseDouble(dijelovi[11].trim().replace(",", "."));
                    String statusPruge = dijelovi[12].trim();
                    int duzina = Integer.parseInt(dijelovi[13].trim());

                    stanice.add(new Stanica(stanica, vrstaStanice, ulazIzlazPutnika, utovarIstovarRobe, brojPerona, statusStanice));
                    pruge.add(new Pruga(oznakaPruge, kategorijaPruge, vrstaPruge, brojKolosjeka, duzina, DOPoOsovini, DOPoDuznomM, statusPruge));
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

        System.out.println("Stanice uspješno učitane!");
        if (ukupnePogreske > 0) {
            System.out.printf("Ukupno pogrešaka: %d\n", ukupnePogreske);
        }

        return stanice;
    }
}

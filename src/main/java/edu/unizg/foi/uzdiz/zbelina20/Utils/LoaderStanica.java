package edu.unizg.foi.uzdiz.zbelina20.Utils;

import edu.unizg.foi.uzdiz.zbelina20.Models.Stanica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoaderStanica {
    public static List<Stanica> ucitajStanice(String nazivDatoteke) {
        List<Stanica> stanice = new ArrayList<>();

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
                    double DOPoOsovini = Double.parseDouble(dijelovi[10].trim());
                    double DOPoDuznomM = Double.parseDouble(dijelovi[11].trim());
                    String statusPruge = dijelovi[12].trim();
                    int duzina = Integer.parseInt(dijelovi[13].trim());

                    stanice.add(new Stanica(stanica, oznakaPruge, vrstaStanice, statusStanice, ulazIzlazPutnika, utovarIstovarRobe, kategorijaPruge, brojPerona,
                            vrstaPruge, brojKolosjeka, DOPoOsovini, DOPoDuznomM, statusPruge, duzina));
                } catch (NumberFormatException e) {
                    System.out.printf("Greška u datoteci %s, red %d: Neispravan format za broj\n", nazivDatoteke, brojLinije);
                }
            }
        } catch (IOException e) {
            System.out.println("Greška pri čitanju datoteke: " + e.getMessage());
        }

        return stanice;
    }
}

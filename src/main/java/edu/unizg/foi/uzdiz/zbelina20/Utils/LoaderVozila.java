package edu.unizg.foi.uzdiz.zbelina20.Utils;

import edu.unizg.foi.uzdiz.zbelina20.Models.PrijevoznoSredstvo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoaderVozila {
    public static List<PrijevoznoSredstvo> ucitajDatotekuVozila(String nazivDatoteke) {
        List<PrijevoznoSredstvo> vozila = new ArrayList<>();
        int ukupnePogreske = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivDatoteke), StandardCharsets.UTF_8))) {
            String linija;
            int brojLinije = 1;

            br.readLine();

            while ((linija = br.readLine()) != null) {
                brojLinije++;
                if (linija.trim().isEmpty()) continue;

                String[] dijelovi = linija.split(";");
                if (dijelovi.length != 18) {
                    ukupnePogreske++;
                    System.out.printf("Greška %d u datoteci %s, red %d: Neispravan broj stupaca (%d umjesto 14). Sadržaj: %s\n",
                            ukupnePogreske, nazivDatoteke, brojLinije, dijelovi.length, linija);
                    continue;
                }

                try {
                    String oznaka = dijelovi[0].trim();
                    //String opis = dijelovi[1].trim();
                    String proizvodac = dijelovi[2].trim();
                    int godina = Integer.parseInt(dijelovi[3].trim());
                    String namjena = dijelovi[4].trim();
                    String vrstaPrijevoza = dijelovi[5].trim();
                    String vrstaPogona = dijelovi[6].trim();
                    double maksBrzina = Double.parseDouble(dijelovi[7].trim().replace(",", "."));
                    double maksSnaga = Double.parseDouble(dijelovi[8].trim().replace(",", "."));
                    int brojSjedecihMjesta = Integer.parseInt(dijelovi[9].trim());
                    int brojStajacihMjesta = Integer.parseInt(dijelovi[10].trim());
                    int brojBicikala = Integer.parseInt(dijelovi[11].trim());
                    int brojKreveta = Integer.parseInt(dijelovi[12].trim());
                    int brojAutomobila = Integer.parseInt(dijelovi[13].trim());
                    double nosivost = Double.parseDouble(dijelovi[14].trim().replace(",", "."));
                    //double povrsina = Double.parseDouble(dijelovi[15].trim().replace(",", "."));
                    double zapremina = Double.parseDouble(dijelovi[16].trim().replace(",", "."));
                    String status = dijelovi[17].trim();

                    vozila.add(new PrijevoznoSredstvo(oznaka, namjena, vrstaPrijevoza,
                            vrstaPogona, maksSnaga, maksBrzina, godina, proizvodac, brojSjedecihMjesta, brojStajacihMjesta,
                            brojBicikala, brojKreveta, brojAutomobila, nosivost, zapremina, status));
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

        System.out.println("Vozila uspješno učitana!");
        if (ukupnePogreske > 0) {
            System.out.printf("Ukupno pogrešaka: %d\n", ukupnePogreske);
        }

        return vozila;
    }
}

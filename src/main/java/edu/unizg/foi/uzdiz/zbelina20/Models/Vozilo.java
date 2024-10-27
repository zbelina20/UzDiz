package edu.unizg.foi.uzdiz.zbelina20.Models;

public class Vozilo {
    private String oznaka;
    private String opis;
    private String proizvodac;
    private int godina;
    private String namjena;
    private String vrstaPrijevoza;
    private String vrstaPogona;
    private double maksBrzina;
    private double maksSnaga;
    private int brojSjedecihMjesta;
    private int brojStajacihMjesta;
    private int brojBicikala;
    private int brojKreveta;
    private int brojAutomobila;
    private double nosivost;
    private double povrsina;
    private double zapremina;
    private String status;

    public Vozilo(String oznaka, String opis, String proizvodac, int godina, String namjena, String vrstaPrijevoza,
                  String vrstaPogona, double maksBrzina, double maksSnaga, int brojSjedecihMjesta,
                  int brojStajacihMjesta, int brojBicikala, int brojKreveta, int brojAutomobila,
                  double nosivost, double povrsina, double zapremina, String status) {
        this.oznaka = oznaka;
        this.opis = opis;
        this.proizvodac = proizvodac;
        this.godina = godina;
        this.namjena = namjena;
        this.vrstaPrijevoza = vrstaPrijevoza;
        this.vrstaPogona = vrstaPogona;
        this.maksBrzina = maksBrzina;
        this.maksSnaga = maksSnaga;
        this.brojSjedecihMjesta = brojSjedecihMjesta;
        this.brojStajacihMjesta = brojStajacihMjesta;
        this.brojBicikala = brojBicikala;
        this.brojKreveta = brojKreveta;
        this.brojAutomobila = brojAutomobila;
        this.nosivost = nosivost;
        this.povrsina = povrsina;
        this.zapremina = zapremina;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Vozilo: %s, Opis: %s, Proizvodac: %s, Godina: %d, Namjena: %s, " +
                        "Vrsta prijevoza: %s, Vrsta pogona: %s, Maks. brzina: %.2f km/h, " +
                        "Maks. snaga: %.2f kW, Broj sjedecih mjesta: %d, Broj stajacih mjesta: %d, " +
                        "Broj bicikala: %d, Broj kreveta: %d, Broj automobila: %d, " +
                        "Nosivost: %.2f t, Povrsina: %.2f m², Zapremina: %.2f m³, Status: %s",
                oznaka, opis, proizvodac, godina, namjena, vrstaPrijevoza,
                vrstaPogona, maksBrzina, maksSnaga, brojSjedecihMjesta, brojStajacihMjesta,
                brojBicikala, brojKreveta, brojAutomobila, nosivost, povrsina, zapremina, status);
    }
}

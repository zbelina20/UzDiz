package edu.unizg.foi.uzdiz.zbelina20.Models;

public class PrijevoznoSredstvo {
    private String oznaka;
    private String namjena;
    private String vrstaPrijevoza;
    private String vrstaPogona;
    private double maksSnaga;
    private double maksBrzina;
    private int godinaProizvodnje;
    private String proizvodac;
    private int brojSjedecihMjesta;
    private int brojStajacihMjesta;
    private int brojBicikala;
    private int brojKreveta;
    private int brojAutomobila;
    private double nosivost;
    private double zapremina;
    private String status;

    public PrijevoznoSredstvo(String oznaka, String namjena, String vrstaPrijevoza, String vrstaPogona,
                              double maksSnaga, double maksBrzina, int godinaProizvodnje, String proizvodac, int brojSjedecihMjesta,
                              int brojStajacihMjesta, int brojBicikala, int brojKreveta, int brojAutomobila,
                              double nosivost, double zapremina, String status) {
        this.oznaka = oznaka;
        this.proizvodac = proizvodac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.namjena = namjena;
        this.vrstaPogona = vrstaPogona;
        this.vrstaPrijevoza = vrstaPrijevoza;
        this.maksBrzina = maksBrzina;
        this.maksSnaga = maksSnaga;
        this.brojSjedecihMjesta = brojSjedecihMjesta;
        this.brojStajacihMjesta = brojStajacihMjesta;
        this.brojBicikala = brojBicikala;
        this.brojKreveta = brojKreveta;
        this.brojAutomobila = brojAutomobila;
        this.nosivost = nosivost;
        this.zapremina = zapremina;
        this.status = status;
    }
}

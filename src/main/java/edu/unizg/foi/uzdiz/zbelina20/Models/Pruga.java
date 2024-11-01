package edu.unizg.foi.uzdiz.zbelina20.Models;

public class Pruga {
    private String oznakaPruge;
    private String kategorijaPruge;
    private String nacinPrijevoza;
    private Integer brojKolosijeka;
    private Integer duzina;
    private Double DOPoOsovini;
    private Double DOPoDuznomM;
    private String statusPruge;

    public Pruga(String oznakaPruge, String kategorijaPruge, String nacinPrijevoza, Integer brojKolosijeka,
                 Integer duzina, Double DOPoOsovini, Double DOPoDuznomM, String statusPruge) {
        this.oznakaPruge = oznakaPruge;
        this.kategorijaPruge = kategorijaPruge;
        this.nacinPrijevoza = nacinPrijevoza;
        this.brojKolosijeka = brojKolosijeka;
        this.duzina = duzina;
        this.DOPoOsovini = DOPoOsovini;
        this.DOPoDuznomM = DOPoDuznomM;
        this.statusPruge = statusPruge;
    }
}

package edu.unizg.foi.uzdiz.zbelina20.Models;

public class Stanica {
    private String stanica;
    private String oznakaPruge;
    private String vrstaStanice;
    private String statusStanice;
    private String ulazIzlazPutnika;
    private String utovarIstovarRobe;
    private String kategorijaPruge;
    private Integer brojPerona;
    private String vrstaPruge;
    private Integer brojKolosjeka;
    private Double DOPoOsovini;
    private Double DOPoDuznomM;
    private String statusPruge;
    private Integer duzina;

    public Stanica(String stanica, String oznakaPruge, String vrstaStanice, String statusStanice, String ulazIzlazPutnika, String utovarIstovarRobe,
                   String kategorijaPruge, Integer brojPerona, String vrstaPruge, Integer brojKolosjeka, Double DOPoOsovini, Double DOPoDuznomM, String statusPruge,
                   Integer duzina) {
        this.stanica = stanica;
        this.oznakaPruge = oznakaPruge;
        this.vrstaStanice = vrstaStanice;
        this.statusStanice = statusStanice;
        this.ulazIzlazPutnika = ulazIzlazPutnika;
        this.utovarIstovarRobe = utovarIstovarRobe;
        this.kategorijaPruge = kategorijaPruge;
        this.brojPerona = brojPerona;
        this.vrstaPruge = vrstaPruge;
        this.brojKolosjeka = brojKolosjeka;
        this.DOPoOsovini = DOPoOsovini;
        this.DOPoDuznomM = DOPoDuznomM;
        this.statusPruge = statusPruge;
        this.duzina = duzina;
    }
}

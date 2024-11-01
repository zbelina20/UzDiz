package edu.unizg.foi.uzdiz.zbelina20.Models;

public class Stanica {
    private String stanica;
    private String vrstaStanice;
    private String ulazIzlazPutnika;
    private String utovarIstovarRobe;
    private Integer brojPerona;
    //private String vrstaPruge;
    private String statusStanice;

    public Stanica(String stanica, String vrstaStanice, String ulazIzlazPutnika, String utovarIstovarRobe,
                   Integer brojPerona, String statusStanice) {
        this.stanica = stanica;
        this.vrstaStanice = vrstaStanice;
        this.ulazIzlazPutnika = ulazIzlazPutnika;
        this.utovarIstovarRobe = utovarIstovarRobe;
        this.brojPerona = brojPerona;
        this.statusStanice = statusStanice;
    }
}

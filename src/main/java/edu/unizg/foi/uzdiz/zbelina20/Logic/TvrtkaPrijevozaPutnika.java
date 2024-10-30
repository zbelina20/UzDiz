package edu.unizg.foi.uzdiz.zbelina20.Logic;

public class TvrtkaPrijevozaPutnika {
    private static TvrtkaPrijevozaPutnika instance;

    private TvrtkaPrijevozaPutnika(){}

    public static TvrtkaPrijevozaPutnika getInstance() {
        if (instance == null) {
            instance = new TvrtkaPrijevozaPutnika();
        }
        return instance;
    }
}

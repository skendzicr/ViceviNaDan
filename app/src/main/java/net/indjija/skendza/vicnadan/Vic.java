package net.indjija.skendza.vicnadan;

/**
 * Created by skendza on 23.12.2014.
 */
public class Vic {

    private String vicPitanje;
    private String vicOdgovor;

    public Vic(String vicPitanje, String vicOdgovor) {
        this.vicPitanje = vicPitanje;
        this.vicOdgovor = vicOdgovor;
    }

    public String getVicPitanje() {
        return vicPitanje;
    }

    public void setVicPitanje(String vicPitanje) {
        this.vicPitanje = vicPitanje;
    }

    public String getVicOdgovor() {
        return vicOdgovor;
    }

    public void setVicOdgovor(String vicOdgovor) {
        this.vicOdgovor = vicOdgovor;
    }
}

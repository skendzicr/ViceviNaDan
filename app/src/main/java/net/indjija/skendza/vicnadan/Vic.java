package net.indjija.skendza.vicnadan;

/**
 * Created by skendza on 23.12.2014.
 */
public class Vic
{
    private final String pitanje;
    private final String odgovor;

    public Vic(String pitanje, String odgovor)
    {
        this.pitanje = pitanje;
        this.odgovor = odgovor;
    }

    public String getPitanje()
    {
        return pitanje;
    }

    public String getOdgovor()
    {
        return odgovor;
    }
}

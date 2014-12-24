package net.indjija.skendza.vicnadan;

import java.util.List;
import java.util.Random;

/**
 * Klasa zaduzena za dohvatanje tikova iz kolekcije viceva.
 * Pod tickom se podrazumeva sekvenca stringova u formatu:
 * Pitanje->Odgovor->[sledeci random vic]->Pitanje->Odgovor itd.
 *
 * Created by null on 24.12.14.
 */
public class VicTicker implements Ticker
{
    /**
     * Pomocna klasa za pracenje stanja trenutnog vica
     */
    static private class VicTracker
    {
        Vic vic;
        boolean pitan;
        boolean odgovoren;

        void reset(Vic vic)
        {
            this.vic = vic;
            pitan = false;
            odgovoren = false;
        }

        boolean shouldReset()
        {
            return vic == null || (pitan && odgovoren);
        }
    }

    private final List<Vic> vicevi;

    private final Random rand = new Random();

    private final VicTracker vicTracker = new VicTracker();

    public VicTicker(List<Vic> vicevi)
    {
        if(vicevi == null || vicevi.isEmpty())
            throw new IllegalArgumentException("Lista viceva ne sme biti prazna!");
        this.vicevi = vicevi;
    }

    @Override
    public String tick()
    {
        // Cela ideja ovde je da ne mora da se vodi racuna o broju klikova,
        // pogotovo ne u Activity-u.
        // Realizovano kao interfejs jer je tiker generalno korisna stvar i moze da radi svasta nesto.
        if(vicTracker.shouldReset())
            vicTracker.reset(sledeciVic());

        if (!vicTracker.pitan)
        {
            vicTracker.pitan = true;
            return vicTracker.vic.getPitanje();
        }
        else
        {
            vicTracker.odgovoren = true;
            return vicTracker.vic.getOdgovor();
        }
    }

    private int getRandomInt()
    {
        return rand.nextInt(vicevi.size());
    }

    private Vic sledeciVic()
    {
        return vicevi.get(getRandomInt());
    }
}

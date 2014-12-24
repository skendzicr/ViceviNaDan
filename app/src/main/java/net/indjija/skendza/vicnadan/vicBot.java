package net.indjija.skendza.vicnadan;

import java.util.ArrayList;

/**
 * Created by skendza on 23.12.2014.
 */
public class vicBot {

    public ArrayList<Vic> viceviKojeZnam = null;
    public String pitanje;
    public String odgovor;

    public vicBot(ArrayList<Vic> viceviKojeZnam) {
        this.viceviKojeZnam = viceviKojeZnam;
    }

    public void izaberiVic()
    {
        Double randomNumDouble = new Double(Math.random()*viceviKojeZnam.size());
        int randomNum = randomNumDouble.intValue();

        Vic mojVic = viceviKojeZnam.get(randomNum);

        namestiVic(mojVic);


    }

    public void namestiVic(Vic vic)
    {
       pitanje = vic.getVicPitanje();
       odgovor = vic.getVicOdgovor();
    }




}

package net.indjija.skendza.vicnadan;

import android.content.Context;

import java.util.ArrayList;


/**
 * Created by skendza on 23.12.2014.
 */
public class zbirkaViceva {

    public static ArrayList<Vic> JSONZbirkaViceva()
    {
        Vic v;
        ArrayList<Vic> zbirkaViceva = new ArrayList<Vic>();

        zbirkaViceva.add(new Vic("Zašto žene žive u proseku duže od muškaraca?",
                "Zato što im je Bog vratio vreme koje izgube na parkiralištu!"));
        zbirkaViceva.add(new Vic("Zašto plavuša nosi naočare na stomaku ?",
                "Jer ima slepo crevo!"));
        zbirkaViceva.add(new Vic("Šta rade pilići kad uđu u kafanu? ",
                "Zato što im je Bog vratio vrijeme koje izgube na parkiralištu!"));
        zbirkaViceva.add(new Vic( "Zašto u našem Telekomu nema seks afera? ",
                "Zato što je incest zabranjen."));
        zbirkaViceva.add(new Vic("Koja je razlika između 'Juga 45' i Jehovinog svedoka? ?",
                "Jehovinom svedoku uvijek možeš da zalupiš vrata"));
        zbirkaViceva.add(new Vic("Zašto slon nema kompjuter ?",
                "Zato što se boji miša !"));

        return zbirkaViceva;
    }




}

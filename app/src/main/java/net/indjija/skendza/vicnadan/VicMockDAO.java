package net.indjija.skendza.vicnadan;

import java.util.ArrayList;
import java.util.List;


/**
 * Preimenovano u Mock DAO (Mock Data Access Object) sto je najcesci naziv
 * za ovakvu vrstu mock data kontejnera.
 *
 * Created by skendza on 23.12.2014.
 */
public class VicMockDAO
{

    // "Coding to interfaces, not implementations." - zlatno pravilo
    static private final List<Vic> VICEVI;

    // Staticka inicijalizacija
    static
    {
        VICEVI = new ArrayList<Vic>();

        VICEVI.add(new Vic("Zašto žene žive u proseku duže od muškaraca?", "Zato što im je Bog vratio vreme koje izgube na parkiralištu!"));
        VICEVI.add(new Vic("Zašto plavuša nosi naočare na stomaku ?", "Jer ima slepo crevo!"));
        VICEVI.add(new Vic("Šta rade pilići kad uđu u kafanu? ", "Piju piju pijuuuu!"));
        VICEVI.add(new Vic("Zašto u našem Telekomu nema seks afera? ", "Zato što je incest zabranjen."));
        VICEVI.add(new Vic("Koja je razlika između 'Juga 45' i Jehovinog svedoka? ?", "Jehovinom svedoku uvijek možeš da zalupiš vrata"));
        VICEVI.add(new Vic("Zašto slon nema kompjuter ?", "Zato što se boji miša !"));
    }

    // Glumimo factory method, shatro dohvatamo instancu.
    static public List<Vic> getInstance()
    {
        return VICEVI;
    }
}

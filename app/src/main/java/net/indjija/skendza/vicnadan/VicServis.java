package net.indjija.skendza.vicnadan;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;

/**
 *
 */
public class VicServis extends Service
{
    private List<Vic> vicevi;

    private void loadVicevi()
    {
        vicevi = VicMockDAO.getInstance();
    }

    public class LocalBinder extends Binder
    {
        public VicServis getService()
        {
            return VicServis.this;
        }
    }

    private LocalBinder localBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent)
    {
        return localBinder;
    }

    public Vic getVicAt(int index)
    {
        // Listi pristupamo preko aksesora, da bi se okinuo lazy reset
        return getVicevi().get(index);
    }

    public List<Vic> getVicevi()
    {
        // Lazy initialization:
        if (vicevi == null || vicevi.isEmpty())
            loadVicevi();
        return vicevi;
    }
}

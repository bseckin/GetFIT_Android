package trainingsplan;

import android.content.res.Resources;
import android.util.Log;

import com.packone.login.R;

import trainingsplan.strategy.IZiel;

/**
 * Created by Berkay on 26.11.2014.
 */
public class Trainingsplan {
    private static Trainingsplan instance = null;
    private IZiel _ziel;

    // leerer Konstruktor
    private Trainingsplan() {}

    public static Trainingsplan getTrainingsplan() {
        if ( instance == null ) {
            instance = new Trainingsplan();
        }
        return instance;
    }

    /**
     * Hier wird der eigentliche Plan GEHOLT. (erstellt wirds in der "Ziel" Klasse)
     * und als 2D-Array zurueckgegeben. ([Übung], [Satzzahl])
     *
     * @param frequenz
     * @return
     */
    public String[][][] getPlan(int frequenz, String erfahrung){
        //String anfaenger = Resources.getSystem().getString(R.string.anfaenger);
        String anfaenger = "Keine - Ich bin Anfänger";

        String[][][] plan;
        // Erstellt plan je nach Ziel:
        if(erfahrung.equals(anfaenger)){
            plan = get_ziel().erstellePlan_Anfaenger(frequenz);
        } else {
            plan = get_ziel().erstellePlan_Fortgeschritten(frequenz);
        }
        return plan;
    }

    /**
     * Setzt IZiel zum Ausgewaehlten Ziel.
     * @param _ziel
     */
    public void set_ziel(IZiel _ziel) {
        this._ziel = _ziel;
    }

    public IZiel get_ziel() {
        return _ziel;
    }
}

package com.packone.login;

import android.util.Log;

import java.util.Arrays;

import trainingsplan.IZiel;

/**
 * Created by Berkay on 26.11.2014.
 */
public class Trainingsplan {
    private static Trainingsplan instance = null;

    private IZiel _ziel;
    //Frequenz freq;

    // Konstruktor
    private Trainingsplan() {
        //_ziel.getPlan(); //beim Aufruf von new Trainingsplan muss ein Ziel sein um erstelle plan zu machen
    }

    public static Trainingsplan getTrainingsplan() {
        if ( instance == null ) {
            instance = new Trainingsplan();
        }
        return instance;
    }

    public String[][] getPlan(){
        // Erstellt plan je nach Ziel:
        String[][] plan =_ziel.erstellePlan();
        Log.d("String[][] erPlAN:", "" + Arrays.deepToString(plan));
        return plan;
    }

    public IZiel get_ziel() {
        return _ziel;
    }

    public void set_ziel(IZiel _ziel) {
        this._ziel = _ziel;
    }
}

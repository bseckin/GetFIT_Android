package com.packone.login;

import trainingsplan.IZiel;

/**
 * Created by Berkay on 26.11.2014.
 */
public class Trainingsplan {
    private IZiel _ziel;
    //Frequenz freq;

    // Konstruktor
    public Trainingsplan() {
        _ziel.erstellePlan();
    }

    public IZiel get_ziel() {
        return _ziel;
    }

    public void set_ziel(IZiel _ziel) {
        this._ziel = _ziel;
    }
}

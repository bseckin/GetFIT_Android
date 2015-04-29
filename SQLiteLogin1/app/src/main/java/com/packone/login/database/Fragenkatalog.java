package com.packone.login.database;

/**
 * Created by Berkay on 16.11.2014.
 */
public class Fragenkatalog {
    //TODO Fragenkatalog Daten von dem User speichern durch Radiobuttons
    // private variables
    private String _frage1;
    private String _frage2;
    private String _frage3;
    private String _frage4;
    private String _frage5;

    // Empty constructor
    public Fragenkatalog() {}

    // Constructor
    public Fragenkatalog(String frage1, String frage2, String frage3, String frage4, String frage5) {
        this._frage1 = frage1;
        this._frage2 = frage2;
        this._frage3 = frage3;
        this._frage4 = frage4;
        this._frage5 = frage5;
    }

    // SETTER
    public void set_frage5(String frage5) {
        this._frage5 = frage5;
    }

    public void set_frage1(String frage1) {
        this._frage1 = frage1;
    }

    public void set_frage2(String frage2) {
        this._frage2 = frage2;
    }

    public void set_frage3(String frage3) {
        this._frage3 = frage3;
    }

    public void set_frage4(String frage4) {
        this._frage4 = frage4;
    }

    // GETTER METHODS
    public String get_frage1() {
        return _frage1;
    }

    public String get_frage2() {
        return _frage2;
    }

    public String get_frage3() {
        return _frage3;
    }

    public String get_frage4() {
        return _frage4;
    }

    public String get_frage5() {
        return _frage5;
    }

}
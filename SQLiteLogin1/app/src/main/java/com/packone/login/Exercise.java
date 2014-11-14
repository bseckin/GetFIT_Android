package com.packone.login;

/**
 * Created by Muhammed5 on 21.10.2014.
 */
public class Exercise {

    // private variables
    private int _id;
    private String _exerciesbez;

    // Empty constructor
    public Exercise() {

    }

    // constructor
    public Exercise(int id, String exerciesbez) {
        this._id = id;
        this._exerciesbez = exerciesbez;

    }


    // getting id
    public int getExId() {
        return this._id;
    }

    // setting id
    public void setExId(int id) {
        this._id = id;
    }

    // getting exercies bez.
    public String getExBez() {
        return this._exerciesbez;
    }

    // setting exercies bez.
    public void setExBez(String exerciesbez) {
        this._exerciesbez = exerciesbez;
    }


}

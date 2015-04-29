package com.packone.login.database;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class Food {

    // private variables
    private int _id;
    private String _name;
    private int _protein;
    private int _fats;
    private int _carbs;
    private int _kcal;


    // Empty constructor
    public Food() {
    }


    // constructor
    public Food(
            int id,
            String name,
            int protein,
            int fats,
            int carbs,
            int kcal
    ) {
        this._id = id;
        this._name = name;
        this._protein = protein;
        this._carbs = carbs;
        this._fats = fats;
        this._kcal = kcal;

    }


    // Setter getter for Username
    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    //Setter Getter for Password
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    // Setter Getter for Email
    public int getProtein() {
        return this._protein;
    }

    public void setProtein(int protein) {
        this._protein = protein;
    }

    // Setter Getter for Gender
    public int getFats() {
        return this._fats;
    }

    public void setFats(int fats) {
        this._fats = fats;
    }

    //Setter Getter for Height
    public int getCarbs() {
        return this._carbs;
    }

    public void setCarbs(int carbs) {
        this._carbs = carbs;
    }

    //Setter and getter for Kcal
    public int get_kcal() {
        return _kcal;
    }

    public void set_kcal(int _kcal) {
        this._kcal = _kcal;
    }


}
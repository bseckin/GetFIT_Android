package com.packone.login;

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
    private String _protein;
    private String _fats;
    private String _carbs;


    // Empty constructor
    public Food() {
    }


    // constructor
    public Food(
            int id,
            String name,
            String protein,
            String fats,
            String carbs
         ) {
        this._id = id;
        this._name = name;
        this._protein = protein;
        this._carbs = carbs;
        this._fats = fats;
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
    public String getProtein() {
        return this._protein;
    }

    public void setProtein(String protein) {
        this._protein = protein;
    }

    // Setter Getter for Gender
    public String getFats() {
        return this._fats;
    }

    public void setFats(String fats) {
        this._fats = fats;
    }

    //Setter Getter for Height
    public String getCarbs() {
        return this._carbs;
    }

    public void setCarbs(String carbs) {
        this._carbs = carbs;
    }



}
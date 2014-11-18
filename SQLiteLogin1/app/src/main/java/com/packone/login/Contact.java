package com.packone.login;

/**
 * @author: Kanyilidz Muhammedmehdi, SECKIN Berkay
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class Contact {

    // private variables
    private String _uname;
    private String _pword;
    private String _email;
    private String _gender;
    private int _height;
    private int _weight;

    // fragenkatalog
    private String _antwortF1;
    private String _antwortF2;
    private String _antwortF3;
    private String _antwortF4;

    // Empty constructor
    public Contact() {}


    // constructor
    public Contact(
            String uname,
            String pword,
            String email,
            String gender,
            int weight,
            int height,
            String antwortF1,
            String antwortF2,
            String antwortF3,
            String antwortF4) {
        this._uname = uname;
        this._pword = pword;
        this._email = email;
        this._gender = gender;
        this._weight = weight;
        this._height = height;
        this._antwortF1 = antwortF1;
        this._antwortF2 = antwortF2;
        this._antwortF3 = antwortF3;
        this._antwortF4 = antwortF4;
    }

    // constructor
    public Contact(String pword, String email) {
        this._pword = pword;
        this._email = email;
    }

    // Setter getter for Username
    public String getUname() {
        return this._uname;
    }

    public void setUname(String uname) {
        this._uname = uname;
    }

    //Setter Getter for Password
    public String getPword() {
        return this._pword;
    }

    public void setPword(String pword) {
        this._pword = pword;
    }

    // Setter Getter for Email
    public String getEmail() {
        return this._email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    // Setter Getter for Gender
    public String getGender() {
        return this._gender;
    }

    public void setGender(String gender) {
        this._gender = gender;
    }

    //Setter Getter for Height
    public int getHeight() {
        return this._height;
    }

    public void setHeight(int height) {
        this._height = height;
    }

    //Setter Getter for Weight
    public int getWeight() {
        return this._weight;
    }

    public void setWeight(int weight) {
        this._weight = weight;
    }

    public String get_antwortF1() {
        return _antwortF1;
    }

    // FRAGENKATALOG GETTER SETTER
    public void set_antwortF1(String _antwortF1) {
        this._antwortF1 = _antwortF1;
    }

    public String get_antwortF2() {
        return _antwortF2;
    }

    public void set_antwortF2(String _antwortF2) {
        this._antwortF2 = _antwortF2;
    }

    public String get_antwortF4() {
        return _antwortF4;
    }

    public void set_antwortF4(String _antwortF4) {
        this._antwortF4 = _antwortF4;
    }

    public String get_antwortF3() {
        return _antwortF3;
    }

    public void set_antwortF3(String _antwortF3) {
        this._antwortF3 = _antwortF3;
    }
}
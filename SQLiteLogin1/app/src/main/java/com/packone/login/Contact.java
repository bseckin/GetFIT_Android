package com.packone.login;

/**
 * @author: Kanyilidz Muhammedmehdi UND SECKIN BERKAY
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class Contact {

    // private variables
    String _uname;
    String _pword;
    String _email;

    // Empty constructor
    public Contact() {

    }

    // constructor
    public Contact(String upword, String pword, String _email) {
        this._uname = upword;
        this._pword = pword;
        this._email = _email;
    }

    // constructor
    public Contact(String pword, String _email) {
        this._pword = pword;
        this._email = _email;
    }

    // getting upword
    public String getUname() {
        return this._uname;
    }

    // setting upword
    public void setUname(String uname) {
        this._uname = uname;
    }

    // getting pword
    public String getPword() {
        return this._pword;
    }

    // setting pword
    public void setPword(String pword) {
        this._pword = pword;
    }

    // getting phone number
    public String getEmail() {
        return this._email;
    }

    // setting phone number
    public void setEmail(String email) {
        this._email = email;
    }
}
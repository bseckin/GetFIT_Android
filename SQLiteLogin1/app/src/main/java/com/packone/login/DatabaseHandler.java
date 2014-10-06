package com.packone.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GetFit2";

    // Contacts table name
    private static final String TABLE_CONTACTS = "login";

    // Contacts Table Columns names
    private static final String KEY_USERNAME = "uname";
    private static final String KEY_PASSWORD = "pword";
    private static final String KEY_EMAIL = "emial";
    private int exists;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Insert: ", "Inserting new table!!!!!!!!!!!!!!!!!");
        this.exists = 0;
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_USERNAME + " TEXT," + KEY_PASSWORD + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, contact.getUname()); // Contact Name
        values.put(KEY_PASSWORD, contact.getPword()); // Contact Name
        values.put(KEY_EMAIL, contact.getEmail()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);

        db.close(); // Closing database connection
    }

    // Getting single contact
    Contact getContact(String uname) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_USERNAME,
                        KEY_PASSWORD, KEY_EMAIL}, KEY_USERNAME + "=?",
                new String[]{String.valueOf(uname)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(cursor.getString(0),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setUname(cursor.getString(0));
                contact.setPword(cursor.getString(1));
                contact.setEmail(cursor.getString(2));


                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());


        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PASSWORD, contact.getPword());
        values.put(KEY_EMAIL, contact.getEmail());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_USERNAME + " = ?",
                new String[]{String.valueOf(contact.getUname())});
    }

    // Deleting single contact
    public void deleteContact() {
        SQLiteDatabase db = this.getWritableDatabase();
        /**db.delete(TABLE_CONTACTS, KEY_USERNAME + " = ?",
         new String[] { String.valueOf(contact.getID()) });
         */

        Log.d("Insert: ", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        String DEL = "DELETE FROM login";
        Log.d("Insert: ", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        db.execSQL(DEL);
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount(String name) {
        //try {
            // Your risky code goes between these curly braces!!!
         /**
          *  String countQuery = "SELECT COUNT(uname) FROM login WHERE uname = " + "'" + name + "'";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            Log.d("!!!!!!!!!!!", "!! " + cursor.getCount());
            cursor.close();
            Log.d("!!!!!!!!!!!", "WAS EAST:::::::::" + cursor.getCount());
            // return count
            return cursor.getCount();


        catch(Exception ex) {
            // Your exception handling code goes between these
            // curly braces, similar to the exception clause
            // in a PL/SQL block.
            ex.printStackTrace();
            Log.d("!!!!!!!!!!!","WAS EAST::::::::!!!!!!!!!!!!" + name);
            this.exists = 0;
        }
*/


        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(uname) FROM login where uname = ?";
        Cursor mcursor = db.rawQuery(count, new String [] {name});
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        return icount;





    }



}
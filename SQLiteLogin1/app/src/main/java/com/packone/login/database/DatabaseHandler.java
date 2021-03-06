package com.packone.login.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kanyilidz Muhammedmehdi, Seckin Berkay
 * @version: 0.9.3
 * @date: 01.10.2014
 * Beschreibung: This Class contains all Operations for deleting updating and creating an entry in the Database
 * Futhermore there are implemented some Connection Methods
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GetFit2";

    /* ------------------------- TABLES ------------------------------ */
    private static final String TABLE_CONTACTS = "login";
    private static final String TABLE_EXERCISE = "exercise";
    private static final String TABLE_FOOD = "food";
    //private static final String TABLE_DEVELOPER_DATA = "data";


    /* ============= COLUMNS from TABLE  "LOGIN" ================ */
    private static final String KEY_USERNAME = "uname";
    private static final String KEY_PASSWORD = "pword";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";

    //TODO FRAGENKATLOG WERTE IN LOGIN TABELLE SPEICHERN WEILS BESSER IST
   /* -====="FRAGENKATALOG"  ========- */
    private static final String KEY_ZIEL = "ziel";
    private static final String KEY_AKT = "aktivitaet";
    private static final String KEY_ERFAHRUNG = "erfahrung";
    private static final String KEY_QUANTITAET = "haufigkeit";
    private static final String KEY_KOERPERTYP = "koerpertyp";
    // private static final String KEY_FRAGE5 = "frage5";


    /* ============ COLUMNS from TABLE  "EXERCISES" ============== */
    private static final String KEY_EXID = "id";
    private static final String KEY_EXERCISEBEZ = "exercisebez";

    /* ============ COLUMNS from TABLE  "FOOD" ============== */
    private static final String KEY_FOODID = "id";
    private static final String KEY_FOODNAME = "foodname";
    private static final String KEY_PROTEIN = "protein";
    private static final String KEY_FATS = "fats";
    private static final String KEY_CARBS = "carbs";
    private static final String KEY_KCAL = "kcal";

    /* ============ COLUMNS from TABLE  "DATA" ============== */
    private static final String KEY_LAST_PLAN = "myplan";

    private int exists;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    /**
     * Creating Tables
     *
     * @param
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Insert: ", "@@@@!!!! CREATE TABLES: LOGIN, EXERCISE !!!@@@@");
        this.exists = 0;
        //========= CREATE TABLE LOGIN ==========
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                        + KEY_USERNAME + " TEXT,"
                        + KEY_PASSWORD + " TEXT,"
                        + KEY_EMAIL + " TEXT,"
                        + KEY_GENDER + " TEXT,"
                        + KEY_HEIGHT + " INTEGER,"
                        + KEY_WEIGHT + " INTEGER,"

                        // Fragenkatalog Werte
                        + KEY_ZIEL + " TEXT,"
                        + KEY_AKT + " TEXT,"
                        + KEY_ERFAHRUNG + " TEXT,"
                        + KEY_QUANTITAET + " TEXT,"
                        + KEY_KOERPERTYP + " TEXT"
                        + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        //========= CREATE TABLE EXERCISE ==========
        String CREATE_EXERCISE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISE + "("
                        + KEY_EXID + " INTEGER PRIMARY KEY,"
                        + KEY_EXERCISEBEZ + " TEXT"
                        + ")";
        db.execSQL(CREATE_EXERCISE_TABLE);

        //========= CREATE TABLE FOOD ==========
        String CREATE_FOOD_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_FOOD + "("
                        + KEY_FOODID + " INTEGER PRIMARY KEY,"
                        + KEY_FOODNAME + " TEXT, "
                        + KEY_PROTEIN + " INTEGER, "
                        + KEY_FATS + " INTEGER, "
                        + KEY_CARBS + " INTEGER,"
                        + KEY_KCAL + " INTEGER"
                        + ")";
        db.execSQL(CREATE_FOOD_TABLE);

        //========= CREATE TABLE TABLE_DEVELOPER_DATA ==========
        /*String CREATE_TABLE_DEVELOPER_DATA =
                "CREATE TABLE IF NOT EXISTS " + TABLE_DEVELOPER_DATA + "("
                        + KEY_LAST_PLAN + " INTEGER PRIMARY KEY,"
                        + ")";
        db.execSQL(CREATE_TABLE_DEVELOPER_DATA);*/


        String[] insertFood = {
                                "INSERT INTO food VALUES(1,'radischen',1,0.1,1.9,14);",
                                "INSERT INTO food VALUES(2,'quark',14,0.2,4,75);",
                                "INSERT INTO food VALUES(3,'kräuter',3,0.8,5.1,41);",
                                "INSERT INTO food VALUES(4,'vollkornbrot',7,1.36,42.8,215);",
                                "INSERT INTO food VALUES(5,'apfel',0,0.4,11.4,52);",
                                "INSERT INTO food VALUES(6,'vollkornnudeln',5,5,18.9,143);",
                                "INSERT INTO food VALUES(7,'zucchini',2,0.4,2,19);",
                                "INSERT INTO food VALUES(8,'broccholi',3,0.2,2.5,26);",
                                "INSERT INTO food VALUES(9,'schlagsahne',3,10,4.1,118);",
                                "INSERT INTO food VALUES(10,'milch',3,3.5,4.8,64);",
                                "INSERT INTO food VALUES(11,'gemüse',3,0.3,0.8,17);",
                                "INSERT INTO food VALUES(12,'speisequark',14,0.2,4,75);",
                                "INSERT INTO food VALUES(13,'möhre',2,2.65,13.7,88);",
                                "INSERT INTO food VALUES(14,'seelachsfilet',10,7.84,1.1,115);",
                                "INSERT INTO food VALUES(15,'Kochschinken',19,3,1,107);",
                                "INSERT INTO food VALUES(16,'kartoffel',2,2.65,13.7,88);"

        };

        for(int i = 0; i <= insertFood.length-1; i++) {
            db.execSQL(insertFood[i]);
        }

    }

    /**
     * Dropping all Tables in a Database
     *
     * @param db, int, int
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVELOPER_DATA);
        // Create tables again
        onCreate(db);
    }

    /**************************************************************************************/
    /************************ OPERATIONS FOR THE LOGIN TABLE ******************************/
    /**************************************************************************************/
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /**
     * Adding new contact
     *
     * @param contact
     */
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // Kontaktdaten
        values.put(KEY_USERNAME, contact.getUname()); // Contact Name
        values.put(KEY_PASSWORD, contact.getPword()); // Contact Name
        values.put(KEY_EMAIL, contact.getEmail()); // Contact Phone
        values.put(KEY_GENDER, contact.getGender()); // Contact Name
        values.put(KEY_HEIGHT, contact.getHeight()); // Contact Name
        values.put(KEY_WEIGHT, contact.getWeight()); // Contact Phone

        // Fragenkatalog
        values.put(KEY_ZIEL, contact.getZiel());
        values.put(KEY_AKT, contact.getAkt());
        values.put(KEY_ERFAHRUNG, contact.getErfahrung());
        values.put(KEY_QUANTITAET, contact.getQuant());
        values.put(KEY_KOERPERTYP, contact.get_ktyp());
        //values.put(KEY_FRAGE5, "");

        // INSERT ROWS
        db.insert(TABLE_CONTACTS, null, values);

        db.close(); // Closing database connection
    }


    /**
     * Getting single contact
     *
     * @param uname Username als String
     * @return contact
     */
    public Contact getContact(String uname) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_USERNAME,
                        KEY_PASSWORD, KEY_EMAIL, KEY_GENDER, KEY_HEIGHT, KEY_WEIGHT}, KEY_USERNAME + "=?",
                new String[]{String.valueOf(uname)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10)
        );

        return contact;
    }

    /***********************************************************
     *********************** MUHI *******************
     ************************************************************/
    /**
     * Getting single contact
     *
     * @param uname Username als String
     * @return contact
     */
    public List<Contact> getContactMuhi(String uname) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS+" WHERE uname = '" + uname+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setUname(cursor.getString(0));
                contact.setPword(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contact.setGender(cursor.getString(3));
                contact.setHeight(Integer.parseInt(cursor.getString(4)));
                contact.setWeight(Integer.parseInt(cursor.getString(5)));
                contact.setZiel(cursor.getString(6));
                contact.setAkt(cursor.getString(7));
                contact.setErfahrung(cursor.getString(8));
                contact.setQuant(cursor.getString(9));
                contact.set_ktyp(cursor.getString(10));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }

/***********************************************************/




    /**
     * Getting All Contacts
     *
     * @return List Liefert alle Kontakte
     */
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
                contact.setGender(cursor.getString(3));
                contact.setHeight(Integer.parseInt(cursor.getString(4)));
                contact.setWeight(Integer.parseInt(cursor.getString(5)));
                contact.setZiel(cursor.getString(6));
                contact.setAkt(cursor.getString(7));
                contact.setErfahrung(cursor.getString(8));
                contact.setQuant(cursor.getString(9));
                contact.set_ktyp(cursor.getString(10));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }

    /**
     * Holt die eingegebenen, konistenten Werte vom Fragenkatalog
     *
     * @return
     */
    public Contact getFragenkatalog(String uname) {
        String currentUser = uname;
        //List<Contact> contactFragenList = new ArrayList<Contact>();
        // Select Fragenkatalog Query
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT "
                + KEY_ZIEL + ", "
                + KEY_AKT + ", "
                + KEY_ERFAHRUNG + ", "
                + KEY_QUANTITAET + " FROM "
                + TABLE_CONTACTS + " WHERE uname='"+ currentUser + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact fragenkatalog_contact = new Contact(
                cursor.getString(0),    // Ziel
                cursor.getString(1),    // Akt
                cursor.getString(2),    // Erfahrung
                cursor.getString(3)     // Quantitaet
        );
        // return contact
        return fragenkatalog_contact;
    }


    /**
     * Updating single contact
     *
     * @param contact
     * @return int
     */
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PASSWORD, contact.getPword());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_GENDER, contact.getGender());
        values.put(KEY_HEIGHT, contact.getHeight());
        values.put(KEY_WEIGHT, contact.getWeight());
        values.put(KEY_ZIEL, contact.getZiel());
        values.put(KEY_AKT, contact.getAkt());
        values.put(KEY_ERFAHRUNG, contact.getErfahrung());
        values.put(KEY_QUANTITAET, contact.getQuant());
        values.put(KEY_KOERPERTYP, contact.get_ktyp());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_USERNAME + " = ?",
                new String[]{String.valueOf(contact.getUname())});
    }

    /**
     * Deleting single contact
     */
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

    /**
     * Getting contacts Count
     *
     * @param name
     * @return int Anzahl von allen Kontakten
     */
    public int getContactsCount(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(uname) FROM login where uname = ?";
        Cursor mcursor = db.rawQuery(count, new String[]{name});
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        return icount;
    }
    /**************************************************************************************/
    /************************ OPERATIONS FOR THE EXERCISE TABLE ***************************/
    /**************************************************************************************/
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /**
     * Adding new contact
     *
     * @param exercise
     */
    void addExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXID, exercise.getExId()); // Contact Name
        values.put(KEY_EXERCISEBEZ, exercise.getExBez()); // Contact Name

        // Inserting Row
        db.insert(TABLE_EXERCISE, null, values);

        db.close(); // Closing database connection
    }

    /**
     * Getting single exercise
     *
     * @param id Die id von der Uebung
     * @return Exercise
     */
    Exercise getExercise(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EXERCISE, new String[]{KEY_EXID,
                        KEY_EXERCISEBEZ}, KEY_EXID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Exercise exercise = new Exercise(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return contact
        return exercise;
    }

    /**
     * Getting All exercises
     *
     * @return List Liste von allen Uebungen
     */
    public List<Exercise> getAllExercises() {
        List<Exercise> exerciseList = new ArrayList<Exercise>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXERCISE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setExId(Integer.parseInt(cursor.getString(0)));
                exercise.setExBez(cursor.getString(1));

                // Adding contact to list
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }
        // return contact list
        return exerciseList;
    }

    /**
     * Updating single contact
     *
     * @param exercise
     */
    public int updateExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXERCISEBEZ, exercise.getExBez());

        // updating row
        return db.update(TABLE_EXERCISE, values, KEY_EXERCISEBEZ + " = ?",
                new String[]{String.valueOf(exercise.getExBez())});
    }

    /**
     * Deleting all exercises
     */
    public void deleteExercise() {
        SQLiteDatabase db = this.getWritableDatabase();
        /**db.delete(TABLE_CONTACTS, KEY_USERNAME + " = ?",
         new String[] { String.valueOf(contact.getID()) });
         */

        Log.d("Insert: ", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        String DEL = "DELETE FROM exercise";
        Log.d("Insert: ", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        db.execSQL(DEL);
        db.close();
    }

    /**
     * Getting contacts Count
     *
     * @param exbez
     * @return int
     */
    public int getExerciseCount(String exbez) {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(" + KEY_EXID + ") FROM login where " + KEY_EXERCISEBEZ + "= ?";
        Cursor mcursor = db.rawQuery(count, new String[]{exbez});
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        return icount;
    }

    /**************************************************************************************/
    /************************ OPERATIONS FOR THE FOOD TABLE ***************************/
    /**************************************************************************************/
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /**
     * Adding new foods
     *
     * @param food
     */
    void addFood(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOODID, food.getId()); // Contact Name
        values.put(KEY_FOODNAME, food.getName()); // Contact Name
        values.put(KEY_PROTEIN, food.getProtein()); // Contact Name
        values.put(KEY_FATS, food.getFats()); // Contact Name
        values.put(KEY_CARBS, food.getCarbs()); // Contact Name
        values.put(KEY_KCAL, food.get_kcal()); // Contact Name

        // Inserting Row
        db.insert(TABLE_FOOD, null, values);

        db.close(); // Closing database connection
    }

    /**
     * Getting single exercise
     *
     * @param name Die id von der Uebung
     * @return Exercise
     */
    public List<Food> getFood(String name) {
        List<Food> foodList = new ArrayList<Food>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD+" WHERE foodname = '" + name+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setId(cursor.getInt(0));
                food.setName(cursor.getString(1));
                food.setProtein(cursor.getInt(2));
                food.setFats(cursor.getInt(3));
                food.setCarbs(cursor.getInt(4));
                food.set_kcal(cursor.getInt(5));

                // Adding contact to list
                foodList.add(food);
            } while (cursor.moveToNext());
        }
        // return contact list
        return foodList;
    }

    /**
     * Getting All Contacts
     *
     * @return List Liefert alle Kontakte
     */
    public List<Food> getAllFoods() {
        List<Food> foodList = new ArrayList<Food>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setId(cursor.getInt(0));
                food.setName(cursor.getString(1));
                food.setProtein(cursor.getInt(2));
                food.setFats(cursor.getInt(3));
                food.setCarbs(cursor.getInt(4));
                food.set_kcal(cursor.getInt(5));

                // Adding contact to list
                foodList.add(food);
            } while (cursor.moveToNext());
        }
        // return contact list
        return foodList;
    }


    /**************************************************************************************/
    /************************ OPERATIONS FOR THE TABLE_DEVELOPER_DATA **********************/
    /**************************************************************************************/
    /*public void addLastPlan(int plan_index) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LAST_PLAN, plan_index);

        // Inserting Row
        db.insert(TABLE_DEVELOPER_DATA, null, values);

        db.close(); // Closing database connection
    } */

    /*public int getLastPlan(){
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT myplan FROM data";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int plan_index = mcursor.getInt(0);

        return plan_index;
    }*/
}
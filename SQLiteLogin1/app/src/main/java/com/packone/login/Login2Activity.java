package com.packone.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import info.androidhive.slidingmenu.MainActivity;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.8
 * @date: 29.09.2014
 * Diese Klasse beinhaltet folgende Funktionalitäten
 *          -Überprüfung der Eingabefelder
 *          -Aufrufen der Nächsten Activity bzw ausgabe einer Fehlermeldung
 */
public class Login2Activity extends Activity {
    private Button mButton;
    private EditText muname;
    private EditText mpword;
    private boolean checkUname = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        final DatabaseHandler db = new DatabaseHandler(this);


        //Initialisierung der Buttons und Eingabefelder
        this.mButton = (Button) findViewById(R.id.blogin);
        this.muname = (EditText) findViewById(R.id.loguname);
        this.mpword = (EditText) findViewById(R.id.logpword);


        this.mButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             * Diese Methode wird aufgerufen falls der Button blogin2 betätigt wird
             * Die Hauptaufgabe dieser Methode besteht darin die Benutzereingaben in die
             * Datenbank zu spechern.
             */
            public void onClick(View view) {


                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                List<Contact> contacts = db.getAllContacts();

                //Mit einer for-Schleife lesen wir alle Einträge aus der Datenbank.
                //Mit den getter-Methoden können wir spetzifizieren welche spalte zurückgeliefert
                //werden soll
                for (Contact cn : contacts) {
                   //Hier erfolgt eine Überprüfung ob die Eingabe des Benutzers im DB ist
                   //.matches vergleicht ein String mit einem regulären Ausdruck(in unserem Fall cn.getUname())
                    if (muname.getText().toString().matches(cn.getUname()) && mpword.getText().toString().matches(cn.getPword())) {
                        checkUname = true; //sind die EIngaben des Benutzers im DB so wurd die boolean Variable auf true gesetzt
                        break; //nur wenn die Eingabe auch im Datenbank existiert wird die schleife unterbrochen ansonsten wird die variable checkuname überschrieben selbst wenn der eintrag existiert
                    } else {
                        checkUname = false; //sind die eingegebenen daten nicht im DB vorhanden wird die Variable auf False gesetzt
                    }
                }

                // Hier überprüfen wir ob die Eingabedaten nun im Datenbank waren oder nicht
                if (checkUname == true) {
                    // Mit Intent(actuelle activity, zielactivity) befördern wir den Benutzer zur nächsten seite
                    Intent intent = new Intent(Login2Activity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    //Toast setzten
                    Context context = getApplicationContext();
                    //Toast Massage hinzufügen
                    CharSequence text = "Ihr Benutzername oder Password stimmen nicht überein.";
                    //Die Länge des Toasts ermitteln
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


    }


}

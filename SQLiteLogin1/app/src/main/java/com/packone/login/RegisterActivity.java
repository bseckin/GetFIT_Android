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

import info.androidhive.slidingmenu.NavigationActivity;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class RegisterActivity extends Activity {

    private Button mButton;
    private EditText muname;
    private EditText mpword;
    private EditText memail;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DatabaseHandler db = new DatabaseHandler(this);
        //    db.deleteContact();
        Log.d("Insert: ", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        mButton = (Button) findViewById(R.id.breg);
        muname = (EditText) findViewById(R.id.uname);
        mpword = (EditText) findViewById(R.id.pword);
        memail = (EditText) findViewById(R.id.email);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //New COMMENT

                /**
                 * CRUD Operations
                 * */
                // Inserting Contacts
                if ((memail.getText().toString().equals("")) || (mpword.getText().toString().equals("")) || (muname.getText().toString().equals(""))) {
                    Context context = getApplicationContext();
                    CharSequence text = "Geben sie etwas ein";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if (isValidEMail(memail.getText().toString()) == false) {

                    Context context = getApplicationContext();
                    CharSequence text = "Die Email Adresse ist nicht korrekt.";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    Log.d("!!!!!!!!!!!!!!!!!!!!!", "!!!!!!!!!!!!!!!!!!!!!!");
                    String name = muname.getText().toString();
                    int zahl = db.getContactsCount(name);

                    Log.d("!!!!!! ", "WAS EAST " + zahl);
                    Log.d("!!!!!! ", "WAS EAST " + name);
                    if (db.getContactsCount(muname.getText().toString()) == 0) {
                        Log.d("Insert: ", "Inserting ..");
                        //  db.deleteContact();

                        db.addContact(new Contact(muname.getText().toString(), mpword
                                .getText().toString(), memail.getText().toString()));

                        // Reading all contacts
                        Log.d("Reading: ", "Reading all contacts..");
                        List<Contact> contacts = db.getAllContacts();

                        for (Contact cn : contacts) {
                            String log = "Username: " + cn.getUname() + " ,Name: "
                                    + cn.getPword() + " ,Phone: " + cn.getEmail();
                            // Writing Contacts to log
                            Log.d("Name: ", log);
                        }

                        Intent intent = new Intent(RegisterActivity.this, NavigationActivity.class);
                        startActivity(intent);
                        //Intent intent = new Intent(RegisterActivity.this, WLifingActivity.class);
                        //startActivity(intent);


                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Der User existiert bereits. Bitte geben Sie einen neuen Namen ein.";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                }
            }
        });


    }

    private boolean isValidEMail(String s) {
        s = s.trim();

        int at, dot, len = s.length();

        // s nicht angegeben (oder nur Whitespaces), oder kein @ bzw .

        if ((len == 0) ||
                ((at = s.indexOf('@')) == -1) || ((dot = s.lastIndexOf('.')) == -1))
            return false;

        // keine EMailadresse vor @ Zeichen oder . vor &

        if ((at == 0) || (dot < at))
            return false;

        // Mindestens zwei Zeichen für die Endung
        Log.d("Insert: ", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy:::::::::::::::::" + dot + 2);
        return dot + 2 < len;
    }


}
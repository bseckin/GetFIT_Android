package com.packone.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

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
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText mheight;
    private EditText weight;
    private SeekBar weightcontrol = null;

    //TODO: - Exercise implementieren
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        weightcontrol = (SeekBar) findViewById(R.id.volume_bar_weight);
        weight = (EditText) findViewById(R.id.weight);
        weightcontrol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                weight.setText("" + progressChanged);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final DatabaseHandler db = new DatabaseHandler(this);
        //    db.deleteContact();
        Log.d("INSERT: ", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        mButton = (Button) findViewById(R.id.breg);
        muname = (EditText) findViewById(R.id.uname);
        mpword = (EditText) findViewById(R.id.pword);
        memail = (EditText) findViewById(R.id.email);
        radioSexGroup = (RadioGroup) findViewById(R.id.gender);
        mheight = (EditText) findViewById(R.id.height);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /**
                 * CRUD Operations
                 * */
                // USER REGISTRATION
                /* Check ob alle Eingabe ausgefullt wurden */
                if ((memail.getText().toString().equals("")) || (mpword.getText().toString().equals("")) || (muname.getText().toString().equals("")) || (radioSexGroup.getCheckedRadioButtonId() == -1)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Geben sie etwas ein";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                /* Check ob Email gueltig ist */
                if (isValidEMail(memail.getText().toString()) == false) {
                    Context context = getApplicationContext();
                    CharSequence text = "Die Email Adresse ist nicht korrekt.";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    //Überprüfen ob der user bereits im datenbank gespeichert ist
                    if (db.getContactsCount(muname.getText().toString()) == 0) {

                        // get selected radio button from radioGroup
                        int selectedId = radioSexGroup.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioSexButton = (RadioButton) findViewById(selectedId);
                        /*
                        db.addContact(
                                new Contact(
                                    muname.getText().toString(),
                                    mpword.getText().toString(),
                                    memail.getText().toString(),
                                    radioSexButton.getText().toString(),
                                    Integer.parseInt(mheight.getText().toString()),
                                    Integer.parseInt(weight.getText().toString())
                                )
                        );
                        */
                        /* CHECK FOR : Reading all contacts
                        Log.d("Reading: ", "Reading all contacts..");
                        List<Contact> contacts = db.getAllContacts();

                        for (Contact cn : contacts) {
                            String log = "Username: " + cn.getUname() + " ,Name: "
                                    + cn.getPword() + " ,Phone: " + cn.getEmail() + ", Gender: " + cn.getGender() + " ,Hieght: "
                                    + cn.getHeight() + " ,Weight: " + cn.getWeight();
                            // Writing Contacts to log
                            Log.d("Name: ", log);
                        }
                        */
                        Intent intent = new Intent(RegisterActivity.this, RegistrierungFragenkatalogActivity.class);
                        intent.putExtra("username", muname.getText().toString());
                        intent.putExtra("password", mpword.getText().toString());
                        intent.putExtra("email", memail.getText().toString());
                        intent.putExtra("gender", radioSexButton.getText().toString());
                        intent.putExtra("height", mheight.getText().toString());
                        intent.putExtra("weight", weight.getText().toString());
                        startActivity(intent);

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

    /**
     * Check ob Email gueltig ist
     * @param s
     * @return
     */
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
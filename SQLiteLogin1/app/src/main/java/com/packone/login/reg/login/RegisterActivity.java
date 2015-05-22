package com.packone.login.reg.login;

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

import com.packone.login.R;
import com.packone.login.database.DatabaseHandler;

import java.util.ArrayList;

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

    private boolean checkInt;
    protected ArrayList<String> databaseArray;

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

        // Dekleration des Datenbank arrays
        // in dieses array kommen alle eingaben des Benutzers im Login screen hinein
        weight.setEnabled(false);
        databaseArray = new ArrayList<String>();
        mButton = (Button) findViewById(R.id.breg);
        muname = (EditText) findViewById(R.id.uname);
        mpword = (EditText) findViewById(R.id.pword);
        memail = (EditText) findViewById(R.id.email);
        radioSexGroup = (RadioGroup) findViewById(R.id.gender);
        mheight = (EditText) findViewById(R.id.height);
        checkInt = true;
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /**
                 * CRUD Operations
                 * */
                // USER REGISTRATION
                // CHECK ob alle Eingabe ausgefullt wurden */

                String weightcon = weight.getText().toString();
                Integer.parseInt("123");
                if (Integer.parseInt(weightcon) < 30) {
                    Context context = getApplicationContext();
                    CharSequence text = "Ihr gewicht ist zu niedrig. Nehmen Sie zu. Sie Lauch!!!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if ((memail.getText().toString().equals(""))
                            || (mpword.getText().toString().equals(""))
                            || (muname.getText().toString().equals(""))
                            || (radioSexGroup.getCheckedRadioButtonId() == -1)
                            || (mheight.getText().toString().equals(""))
                            ) {
                        Context context = getApplicationContext();
                        CharSequence text = "Bitte alle Felder ausfüllen!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {

                        // CHECK ob Email gueltig ist //
                        if (isValidEMail(memail.getText().toString()) == false) {
                            Context context = getApplicationContext();
                            CharSequence text = "Die Email Adresse ist nicht korrekt.";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        } else {
                            // CHECK ob der user bereits im datenbank gespeichert ist
                            if (db.getContactsCount(muname.getText().toString()) == 0) {

                                // get selected radio button from radioGroup
                                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                                // find the radiobutton by returned id
                                radioSexButton = (RadioButton) findViewById(selectedId);

                                //Die variablen zur registrierungFragenkatalog activity weiter leiten
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
                                CharSequence text = "Der Username wird bereits verwendet. Versuchen Sie einen anderen Namen!";
                                int duration = Toast.LENGTH_LONG;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }

                        }
                    }
                }
            }
        });
    }

    /**
     * Check ob Email gueltig ist
     *
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
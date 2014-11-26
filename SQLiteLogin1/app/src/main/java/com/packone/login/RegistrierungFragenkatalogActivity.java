package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import info.androidhive.slidingmenu.NavigationActivity;
import trainingsplan.AllgemeineFitness;
import trainingsplan.Ausdauer;
import trainingsplan.Gewichtsverlust;
import trainingsplan.MasseMuskelaufbau;
import trainingsplan.Rueckenstaerkung;

public class RegistrierungFragenkatalogActivity extends Activity {
    // ATTRIBUTE
    // Frage 1
    private RadioGroup radioGroupFrage1;
    private RadioButton F1radioBtn1, F1radioBtn2, F1radioBtn3, F1radioBtn4, F1radioBtn5;
    // Frage 2
    private RadioGroup radioGroupFrage2;
    private RadioButton F2radioBtn1, F2radioBtn2, F2radioBtn3;

    // Frage 3
    private RadioGroup radioGroupFrage3;
    private RadioButton F3radioBtn1, F3radioBtn2, F3radioBtn3;

    // Frage 4
    private RadioGroup radioGroupFrage4;
    private RadioButton F4radioBtn1, F4radioBtn2, F4radioBtn3;

    private Button btn_fragenkatalog_fertig; //bestaetigen Button
    private static String UNAME = "";
    private static String PASSWORD = "";
    private static String EMAIL = "";
    private static String GENDER = "";
    private static String HEIGHT = "";
    private static String WEIGHT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung_fragenkatalog);

        //WERTE VON REGISTER ACTICITY VON USER NEHMEN
        Intent intent = getIntent();
        UNAME = intent.getStringExtra("username");
        PASSWORD = intent.getStringExtra("password");
        EMAIL = intent.getStringExtra("email");
        GENDER = intent.getStringExtra("gender");
        HEIGHT = intent.getStringExtra("height");
        WEIGHT = intent.getStringExtra("weight");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Wenn der User Fragenkatalog vollständig und korrekt ausgefüllt hat,
     * kommt er zum Hauptscreen (NavigatiationAcitivty)
     * @param view
     */
    public void fragenkatalog_fertig(View view){
        // TRAININGSZIEL
        radioGroupFrage1 = (RadioGroup)findViewById(R.id.rg_frage1);
        int selectedF1 = radioGroupFrage1.getCheckedRadioButtonId();
        RadioButton rf1 = (RadioButton)findViewById(selectedF1);
        String antwortF1 = rf1.getText().toString();
        Log.d("--------------- Frage 1:", antwortF1);

        // WAS MACHT ES DIR SCHWER AKTIVER ZU SEIN?
        radioGroupFrage2 = (RadioGroup)findViewById(R.id.rg_frage2);
        int selectedF2 = radioGroupFrage2.getCheckedRadioButtonId();
        RadioButton rf2 = (RadioButton)findViewById(selectedF2);
        String antwortF2 = rf2.getText().toString();
        Log.d("--------------- Frage 2:", antwortF2);

        // ERFAHRUNGSLEVEL
        radioGroupFrage3 = (RadioGroup)findViewById(R.id.rg_frage3);
        int selectedF3 = radioGroupFrage3.getCheckedRadioButtonId();
        RadioButton rf3 = (RadioButton)findViewById(selectedF3);
        String antwortF3 = rf3.getText().toString();
        Log.d("--------------- Frage 3:", antwortF3);

        // WIE OFT KANNST DU PRO WOCHE TRAINIEREN GEHEN?
        radioGroupFrage4 = (RadioGroup)findViewById(R.id.rg_frage4);
        int selectedF4 = radioGroupFrage4.getCheckedRadioButtonId();
        RadioButton rf4 = (RadioButton)findViewById(selectedF4);
        String antwortF4 = rf4.getText().toString();
        Log.d("--------------- Frage 4:", antwortF4);

        // IN DB Speichern
        final DatabaseHandler db = new DatabaseHandler(this);
        db.addContact(
              new Contact(
                    UNAME,
                    PASSWORD,
                    EMAIL,
                    GENDER,
                    Integer.parseInt(HEIGHT),
                    Integer.parseInt(WEIGHT),
                    antwortF1,
                    antwortF2,
                    antwortF3,
                    antwortF4
              )
        );

        // ========= TRAININGSPLAN ERSTELLEN =========
        Trainingsplan tp = new Trainingsplan();
        // Masse und Muskelaufbau - Trainingsplan
        if(antwortF1 == getString(R.string.masseaufbau)) tp.set_ziel(new MasseMuskelaufbau());
        // Gewichtsverlust - Trainingsplan
        if(antwortF1 == getString(R.string.gewichtsverlust)) tp.set_ziel(new Gewichtsverlust());
        // Erhöhung der Ausdauer - Trainingsplan
        if(antwortF1 == getString(R.string.kondition)) tp.set_ziel(new Ausdauer());
        // Rückenstärkung - Trainignsplan
        if(antwortF1 == getString(R.string.ruecken)) tp.set_ziel(new Rueckenstaerkung());
        // Einfache allgemein Fitness - Trainingsplan
        if(antwortF1 == getString(R.string.allgemein)) tp.set_ziel(new AllgemeineFitness());

        // ========= ERNÄHRUNGSPLAN ERSTELLEN =========

        Intent intent = new Intent(RegistrierungFragenkatalogActivity.this, NavigationActivity.class);
        startActivity(intent);
    }
}

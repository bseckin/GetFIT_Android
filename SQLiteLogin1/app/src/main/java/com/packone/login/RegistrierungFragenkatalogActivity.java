package com.packone.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

    private Button btn_fragenkatalog_fertig;        //bestaetigen Button

    // Trainingsfrequenz vom Benutzer
    public int frequenz = 0;

    //Was der User ausgewählt hat vom Fragenkatalog
    public String antwortF1;
    public String antwortF2;
    public String antwortF3;
    public String antwortF4;

    // Für DB
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
        // " TRAININGSZIEL "
        radioGroupFrage1 = (RadioGroup)findViewById(R.id.rg_frage1);
        int selectedF1 = radioGroupFrage1.getCheckedRadioButtonId();
        RadioButton rf1 = (RadioButton)findViewById(selectedF1);
        antwortF1 = rf1.getText().toString();
        Log.d("--------------- Frage 1:", antwortF1);

        // " WAS MACHT ES DIR SCHWER AKTIVER ZU SEIN? "
        radioGroupFrage2 = (RadioGroup)findViewById(R.id.rg_frage2);
        int selectedF2 = radioGroupFrage2.getCheckedRadioButtonId();
        RadioButton rf2 = (RadioButton)findViewById(selectedF2);
        antwortF2 = rf2.getText().toString();
        Log.d("--------------- Frage 2:", antwortF2);

        // " ERFAHRUNGSLEVEL "
        radioGroupFrage3 = (RadioGroup)findViewById(R.id.rg_frage3);
        int selectedF3 = radioGroupFrage3.getCheckedRadioButtonId();
        RadioButton rf3 = (RadioButton)findViewById(selectedF3);
        antwortF3 = rf3.getText().toString();
        Log.d("--------------- Frage 3:", antwortF3);

        // " WIE OFT KANNST DU PRO WOCHE TRAINIEREN GEHEN? "
        radioGroupFrage4 = (RadioGroup)findViewById(R.id.rg_frage4);
        int selectedF4 = radioGroupFrage4.getCheckedRadioButtonId();
        RadioButton rf4 = (RadioButton)findViewById(selectedF4);
        antwortF4 = rf4.getText().toString();
        Log.d("--------------- Frage 4:", antwortF4);


        // [DATEN ÜBERPRÜFUNG] - Ob alle Fragen beantwortet wurden.
        if( antwortF1.equals("") || antwortF2.equals("") || antwortF3.equals("") || antwortF4.equals("")) {
            Context context = getApplicationContext();
            CharSequence text = "Bitte füllen Sie den Fragenkatalog komplett aus!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            // Wie oft dieser Benutzer in der Woche trainieren kann in Variable speichern
            if(antwortF4.equals(getString(R.string.zwei_mal_training))) this.frequenz = 2;  // Zweimal pro Woche
            if(antwortF4.equals(getString(R.string.drei_mal_training))) this.frequenz = 3;  // Dreimal pro Woche
            if(antwortF4.equals(getString(R.string.vier_mal_training))) this.frequenz = 4;  // Mehr als 4 mal pro Woche

            // ============ TRAININGSPLAN ERSTELLEN ============
            Trainingsplan fertiger_Trainingsplan = erstelleTP();


            //TODO ========= ERNÄHRUNGSPLAN ERSTELLEN =========

            /*
            * =================================================
            * Bei korrekten Eingaben UND erfolgreichem speichern in die DB
            * kann die nächste Acitivty gestartet werden
            * =================================================
            */
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

            // Hauptmenü-Activity Starten
            Intent intent = new Intent(RegistrierungFragenkatalogActivity.this, NavigationActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Erstellt Trainingsplan durch den ausgefüllten Fragenkatalog
     *
     * @return Trainingsplan
     */
    public Trainingsplan erstelleTP(){
        Trainingsplan tp = new Trainingsplan();

        // Masse und Muskelaufbau - Trainingsplan
        if(antwortF1 == getString(R.string.masseaufbau)) {
            tp.set_ziel(new MasseMuskelaufbau(frequenz));
            tp.erstellePlan();
            Log.d("==================== MASSE UND MUSKELAUFBAU", " - TP ");
        } else {
            // Gewichtsverlust - Trainingsplan
            if ( antwortF1 == getString(R.string.gewichtsverlust) ) {
                tp.set_ziel(new Gewichtsverlust(frequenz));
                tp.erstellePlan();
                Log.d("==================== GEWICHTSVERLUST", " - TP ");
            } else {
                // Erhöhung der Ausdauer - Trainingsplan
                if ( antwortF1.equals(getString(R.string.kondition)) ) {
                    tp.set_ziel(new Ausdauer(frequenz));
                    tp.erstellePlan();
                    Log.d("==================== KONDITION", " - TP ");
                } else {
                    // Rückenstärkung - Trainignsplan
                    if ( antwortF1 == getString(R.string.ruecken) ) {
                        tp.set_ziel(new Rueckenstaerkung(frequenz));
                        tp.erstellePlan();
                        Log.d("==================== RUECKEN STÄRKUNG", " - TP ");
                    } else {
                        // Einfache allgemein Fitness - Trainingsplan
                        if ( antwortF1 == getString(R.string.allgemein) ) {
                            tp.set_ziel(new AllgemeineFitness(frequenz));
                            tp.erstellePlan();
                            Log.d("==================== ALLGEMEIN FITNESS", " - TP ");
                        }
                    }
                }
            }
        }
        return tp;
    }
}

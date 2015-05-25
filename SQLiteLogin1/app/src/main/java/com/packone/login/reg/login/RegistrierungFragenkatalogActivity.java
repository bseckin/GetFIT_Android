package com.packone.login.reg.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.packone.login.GlobalClass;
import com.packone.login.R;
import com.packone.login.database.Contact;
import com.packone.login.database.DatabaseHandler;

import menu.androidhive.navdrawer.NavigationActivity;

public class RegistrierungFragenkatalogActivity extends Activity {
    // ATTRIBUTE
    private RadioGroup radioGroupFrage1;    // Frage 1
    private RadioGroup radioGroupFrage2;    // Frage 2
    private RadioGroup radioGroupFrage3;    // Frage 3
    private RadioGroup radioGroupFrage4;    // Frage 4

    private RadioGroup radioGroupFrage6;    // Frage 6
    public int frequenz = 0;    // Trainingsfrequenz vom Benutzer

    //Was der User ausgewählt hat vom Fragenkatalog
    public String antwortF1;
    public String antwortF2;
    public String antwortF3;
    public String antwortF4;
    public String antwortF6;

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

        TextView bhelp = (TextView) findViewById(R.id.helpText);
        bhelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegistrierungFragenkatalogActivity.this, BodyInfoActivity.class);
                startActivity(intent);
                Log.d("!!!!!!!!!!!!!","!!!!!!!!!!!");
            }
        });

        // WERTE VON REGISTER ACTICITY VON USER NEHMEN
        Intent intent = getIntent();
        UNAME = intent.getStringExtra("username");
        PASSWORD = intent.getStringExtra("password");
        EMAIL = intent.getStringExtra("email");
        GENDER = intent.getStringExtra("gender");
        HEIGHT = intent.getStringExtra("height");
        Log.d("FRAGKAT:HEIGHT,", ""+HEIGHT);
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
        boolean frage1_OK = false;
        boolean frage2_OK = false;
        boolean frage3_OK = false;
        boolean frage4_OK = false;
        boolean frage6_OK = false;
        // " TRAININGSZIEL "
        radioGroupFrage1 = (RadioGroup)findViewById(R.id.rg_frage1);
        int selectedF1;
        if(radioGroupFrage1.getCheckedRadioButtonId() != -1) {
            frage1_OK = true;
            Log.d("radioGroupFrage1", "wurde ausgefüllt");
            selectedF1 = radioGroupFrage1.getCheckedRadioButtonId();
            RadioButton rf1 = (RadioButton)findViewById(selectedF1);
            antwortF1 = rf1.getText().toString();
        } else frage1_OK = false;

        // " WAS MACHT ES DIR SCHWER AKTIVER ZU SEIN? "
        radioGroupFrage2 = (RadioGroup)findViewById(R.id.rg_frage2);
        int selectedF2;
        if(radioGroupFrage2.getCheckedRadioButtonId() != -1) {
            frage2_OK = true;
            selectedF2 = radioGroupFrage2.getCheckedRadioButtonId();
            RadioButton rf2 = (RadioButton) findViewById(selectedF2);
            antwortF2 = rf2.getText().toString();
        } else frage2_OK = false;

        // " ERFAHRUNGSLEVEL "
        radioGroupFrage3 = (RadioGroup)findViewById(R.id.rg_frage3);
        int selectedF3;
        if(radioGroupFrage3.getCheckedRadioButtonId() != -1) {
            frage3_OK = true;
            selectedF3 = radioGroupFrage3.getCheckedRadioButtonId();
            RadioButton rf3 = (RadioButton)findViewById(selectedF3);
            antwortF3 = rf3.getText().toString();
        } else frage3_OK = false;

        // " WIE OFT KANNST DU PRO WOCHE TRAINIEREN GEHEN? "
        radioGroupFrage4 = (RadioGroup)findViewById(R.id.rg_frage4);
        int selectedF4;
        if(radioGroupFrage4.getCheckedRadioButtonId() != -1) {
            frage4_OK = true;
            selectedF4 = radioGroupFrage4.getCheckedRadioButtonId();
            RadioButton rf4 = (RadioButton) findViewById(selectedF4);
            antwortF4 = rf4.getText().toString();
        } else frage4_OK = false;

        radioGroupFrage6 = (RadioGroup)findViewById(R.id.rg_frage6);
        if(radioGroupFrage4.getCheckedRadioButtonId() != -1) {
            frage6_OK = true;
            int selectedF6 = radioGroupFrage6.getCheckedRadioButtonId();
            RadioButton rf6 = (RadioButton) findViewById(selectedF6);
            antwortF6 = rf6.getText().toString();
        } else frage6_OK = false;


        // [DATEN ÜBERPRÜFUNG] - Ob alle Fragen beantwortet wurden.
        if ( !frage1_OK || !frage2_OK || !frage3_OK || !frage4_OK || !frage6_OK) {
            CharSequence text = "Bitte füllen Sie den Fragenkatalog komplett aus!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        } else {
            // Wie oft dieser Benutzer in der Woche trainieren kann in Variable speichern
            if(antwortF4.equals(getString(R.string.zwei_mal_training))) this.frequenz = 2;  // Zweimal pro Woche
            if(antwortF4.equals(getString(R.string.drei_mal_training))) this.frequenz = 3;  // Dreimal pro Woche
            if(antwortF4.equals(getString(R.string.vier_mal_training))) this.frequenz = 4;  // Mehr als 4 mal pro Woche

            // Speichern in DB
            final DatabaseHandler db = new DatabaseHandler(this);
            db.addContact(
                    new Contact(
                            UNAME,
                            PASSWORD,
                            EMAIL,
                            GENDER,
                            Integer.parseInt(WEIGHT),
                            Integer.parseInt(HEIGHT),
                            antwortF1,
                            antwortF2,
                            antwortF3,
                            antwortF4,
                            antwortF6
                    )
            );
            Log.d("RegFragenkatalog", "INSERT in DB erfolgreich!");

            // Calling Application class (see application tag in AndroidManifest.xml)
            final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

            //Set username in global/application context
            globalVariable.setName(UNAME);

            /* ============================================================
            * Bei korrekten Eingaben UND erfolgreichem speichern in die DB
            * kann die nächste Acitivty gestartet werden
            * =============================================================*/
            Log.d("Activity","Starting NavigationActivity");
            Intent intent = new Intent(this, NavigationActivity.class);
            intent.putExtra("uname", UNAME);
            startActivity(intent);
        }
    }
}

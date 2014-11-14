package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import info.androidhive.slidingmenu.NavigationActivity;


public class RegistrierungFragenkatalogActivity extends Activity {
    // ATTRIBUTE ODER GRAFISCHE ELEMENTE
    // Frage 1
    private RadioGroup radioGroupFrage1;
    private RadioButton radioBtn1, radioBtn2;

    // Frage 2
    private RadioGroup radioGroupFrage2;
    //private RadioButton radioBtn, radioBtn2, radioBtn2;

    // Frage 3
    private RadioGroup radioGroupFrage3;
    //private RadioButton radioBtn1, radioBtn2, radioBtn2;

    // Frage 4
    private RadioGroup radioGroupFrage4;
    //private RadioButton radioBtn1, radioBtn2, radioBtn2;
    private Button btn_fragenkatalog_fertig; //bestaetigen Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung_fragenkatalog);
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
        Intent intent = new Intent(RegistrierungFragenkatalogActivity.this, NavigationActivity.class);
        startActivity(intent);
    }
}

package com.packone.login;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class HomeScreen extends Activity {
    // Habe eine Testvariable erstellt - SECKIN BERKAY
    String TESTVARIABLE_SECKIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_home_screen, menu);
        return true;
    }

}

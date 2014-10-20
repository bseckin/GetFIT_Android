package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import info.androidhive.slidingmenu.NavigationActivity;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */

/**
 *  NICHT IN VERWENDUNG
 */
public class GoalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_goal);

    }

    public void onClick(View view) {
        Intent intent = new Intent(GoalActivity.this, NavigationActivity.class);
        startActivity(intent);
        finish();
    }

}

package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SingleMenuItemActivity  extends Activity {
	
	// XML node keys
	static final String KEY_NAME = "name";
	static final String KEY_KJ = "kj";
	static final String KEY_KCAL = "kcal";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        String name = in.getStringExtra(KEY_NAME);
        String kj = in.getStringExtra(KEY_KJ);
        String kcal = in.getStringExtra(KEY_KCAL);
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblKj = (TextView) findViewById(R.id.kj_label);
        TextView lblKcal = (TextView) findViewById(R.id.kcal_label);
        
        lblName.setText(name);
        lblKj.setText(kj);
        lblKcal.setText(kcal);
    }
}

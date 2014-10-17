package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author: Kanyilidz Muhammedmehdi
 * @version: 0.9.1
 * @date: 01.10.2014
 * Beschreibung
 */
public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /**
         Button breg = (Button) findViewById(R.id.registrierung);
         breg.setOnClickListener(this);
         */

        Button blogin = (Button) findViewById(R.id.blogin);
        blogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Button breg = (Button) findViewById(R.id.registrierung);
        breg.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });


    }
/*

	@Override
	public void onClick(View v) {
		startActivity(new Intent(this, RegisterActivity.class));
	}
	*/

}

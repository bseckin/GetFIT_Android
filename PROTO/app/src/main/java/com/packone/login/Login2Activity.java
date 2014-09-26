package com.packone.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class Login2Activity extends Activity {
    private Button mButton;
	private EditText muname;
	private EditText mpword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login2);
		

		final DatabaseHandler db = new DatabaseHandler(this);

		Log.d("Insert: ", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		// Log.d("Insert: ",
		// muname.getText().toString()+mpword.getText().toString()+
		// memail.getText().toString());
		mButton = (Button) findViewById(R.id.blogin2);

		muname = (EditText) findViewById(R.id.loguname);
		mpword = (EditText) findViewById(R.id.logpword);
	
		mButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

		
				
				// Reading all contacts
				Log.d("Reading: ", "Reading all contacts..");
				List<Contact> contacts = db.getAllContacts();

				for (Contact cn : contacts) {
					Log.d("Reading: ", "xxxxxxxxxxxxxxxyyyyyyyyyyyyyyxxxxxxxxxxxxxyyyyyyyyxxxxxxxxxx");
					//cn.getPword().toString()
					Log.d("OUTPU: ", cn.getPword());
					Log.d("OUTPU: ", cn.getUname());
					
					Log.d("OUTPUT: ", muname.getText().toString());
					Log.d("OUTPUT: ", mpword.getText().toString());
					if (muname.getText().toString().matches(cn.getUname()) && mpword.getText().toString().matches(cn.getPword())){
						String log = "Username: " + cn.getUname() + " ,Name: "
								+ cn.getPword() + " ,Phone: " + cn.getEmail();
						Log.d("Name: ", log);
						Intent intent = new Intent(Login2Activity.this, GoalActivity.class);
		                startActivity(intent);
		                finish();
					} else {
                        Context context = getApplicationContext();
                        CharSequence text = "Ihr Benutzername oder Password stimmen nicht überein.";
                        int duration = Toast.LENGTH_LONG;

                         Toast toast = Toast.makeText(context, text, duration);
                         toast.show();
                    }
					// Writing Contacts to log
					
					
					
				}
			}
		});
		
		
	}



}

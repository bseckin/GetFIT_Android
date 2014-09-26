package com.packone.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
/**
		Button breg = (Button) findViewById(R.id.registrierung);
		breg.setOnClickListener(this);
	*/
		
		Button blogin= (Button)findViewById(R.id.login);
		   blogin.setOnClickListener(new OnClickListener() 
		    {   public void onClick(View v) 
		        {   
		            Intent intent = new Intent(StartActivity.this, Login2Activity.class);
		                startActivity(intent);      
		                finish();
		        }
		    });
		   
		   Button breg= (Button)findViewById(R.id.registrierung);
		   breg.setOnClickListener(new OnClickListener() 
		    {   public void onClick(View v) 
		        {   
		            Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
		                startActivity(intent);      
		                finish();
		        }
		    });
		    
		    
	}

    public void testMethodeKanyildiz(){
        Log.i("NICHTS","NICHTS");
    }
/*

	@Override
	public void onClick(View v) {
		startActivity(new Intent(this, RegisterActivity.class));
	}
	*/
    public void testMethodeSECKIN(){
        //EXTRA FEATURE HINZUGEFÜGT
        Log.i("HALLO", "Hallo Welt");
    }

}

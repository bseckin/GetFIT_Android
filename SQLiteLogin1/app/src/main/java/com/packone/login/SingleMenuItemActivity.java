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
    static final String KEY_FAT = "fat_gram";
    static final String KEY_PROT = "protein_gram";
    static final String KEY_KH = "kh_gram";
    static final String KEY_SUGAR = "sugar_gram";
    static final String KEY_AMOUNT = "amount";
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
        String fat_gram = in.getStringExtra(KEY_FAT);
        String protein_gram = in.getStringExtra(KEY_PROT);
        String kh_gram = in.getStringExtra(KEY_KH);
        String sugar_gram = in.getStringExtra(KEY_SUGAR);
        String amount = in.getStringExtra(KEY_AMOUNT);

        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblKj = (TextView) findViewById(R.id.kj_label);
        TextView lblKcal = (TextView) findViewById(R.id.kcal_label);
        TextView lblFat = (TextView) findViewById(R.id.fat_label);
        TextView lblProt = (TextView) findViewById(R.id.prot_label);
        TextView lblKh = (TextView) findViewById(R.id.kh_label);
        TextView lblSugar = (TextView) findViewById(R.id.sugar_label);
        TextView lblAmount = (TextView) findViewById(R.id.amount_label);

        lblName.setText(name);
        lblKj.setText(kj);
        lblKcal.setText(kcal);
        lblFat.setText(fat_gram);
        lblProt.setText(protein_gram);
        lblKh.setText(kh_gram);
        lblSugar.setText(sugar_gram);
        lblAmount.setText(amount);
    }
}

package com.packone.login;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.text.Editable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.os.StrictMode;

import android.view.Menu;
import android.widget.Button;
import android.view.View.OnClickListener;

public class AndroidXMLParsingActivity extends ListActivity {

	// All static variables
	String URL = "http://fddb.info/api/v12/search/item_short.xml?lang=de";
	// XML node keys
    String SEARCHED_ITEM;
    String KEY_SHORTITEM = "shortitem";
	String KEY_NAME = "name";
    String KEY_KJ = "kj";
    String KEY_KCAL = "kcal";
    String KEY_FAT = "fat_gram";
    String KEY_PROT = "protein_gram";
    String KEY_KH = "kh_gram";
    String API_KEY = "&apikey=5U92BAMH4Z3QK6TXVBU3EQ0N";
    EditText inputSearch;

	@Override
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {


                SEARCHED_ITEM = inputSearch.getText().toString();
                SEARCHED_ITEM = SEARCHED_ITEM.replace(" ","+");

                ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

                XMLParser parser = new XMLParser();
                String xml = parser.getXmlFromUrl(URL + "&q=" + SEARCHED_ITEM + API_KEY); // getting XML
                Document doc = parser.getDomElement(xml); // getting DOM element

                NodeList nl = doc.getElementsByTagName(KEY_SHORTITEM);

                if (nl != null && nl.getLength() > 0) {
                    // looping through all item nodes <item>
                    for (int i = 0; i < nl.getLength(); i++) {
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
                        Element e = (Element) nl.item(i);
                        // adding each child node to HashMap key => value
                        map.put(KEY_NAME, parser.getCharacterDataFromElement(e, KEY_NAME));
                        map.put(KEY_KJ, parser.getValue(e, KEY_KJ));
                        map.put(KEY_KCAL, parser.getValue(e, KEY_KCAL));
                        map.put(KEY_FAT, parser.getValue(e, KEY_FAT));
                        map.put(KEY_PROT, parser.getValue(e, KEY_PROT));
                        map.put(KEY_KH, parser.getValue(e, KEY_KH));


                        // adding HashList to ArrayList
                        menuItems.add(map);
                    }
                }

                // Adding menuItems to ListView
                ListAdapter adapter = new SimpleAdapter(getApplicationContext(), menuItems,
                        R.layout.listen_item,
                        new String[]{KEY_NAME, KEY_KJ, KEY_KCAL, KEY_FAT, KEY_PROT, KEY_KH}, new int[]{
                        R.id.name, R.id.kj, R.id.kcal, R.id.fat_gram, R.id.protein_gram, R.id.kh_gram});

                setListAdapter(adapter);

                // selecting single ListView item
                ListView lv = getListView();

                lv.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        // getting values from selected ListItem
                        String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
                        String kj = ((TextView) view.findViewById(R.id.kj)).getText().toString();
                        String kcal = ((TextView) view.findViewById(R.id.kcal)).getText().toString();
                        String fat_gram = ((TextView) view.findViewById(R.id.fat_gram)).getText().toString();
                        String protein_gram = ((TextView) view.findViewById(R.id.protein_gram)).getText().toString();
                        String kh_gram = ((TextView) view.findViewById(R.id.kh_gram)).getText().toString();

                        // Starting new intent
                        Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                        in.putExtra(KEY_NAME, name);
                        in.putExtra(KEY_KJ, kj);
                        in.putExtra(KEY_KCAL, kcal);
                        in.putExtra(KEY_FAT, fat_gram);
                        in.putExtra(KEY_PROT, protein_gram);
                        in.putExtra(KEY_KH, kh_gram);
                        startActivity(in);

                    }
                });
            }

        });
    }
}
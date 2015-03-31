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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.os.StrictMode;

public class AndroidXMLParsingActivity extends ListActivity {

	// All static variables
	static final String URL = "http://fddb.info/api/v12/search/item_short.xml?lang=de";
	// XML node keys
    static final String SEARCHED_ITEM = "&q=egg";
	static final String KEY_RESULT = "result"; // parent node
    static final String KEY_ITEM = "items";
    static final String KEY_SHORTITEM = "shortitem";
	//static final String KEY_AMOUNT = "amount";
    static final String KEY_DESCRIPTION = "description";
	static final String KEY_NAME = "name";
    static final String KEY_KJ = "kj";
    static final String KEY_KCAL = "kcal";
    static final String API_KEY = "&apikey=5U92BAMH4Z3QK6TXVBU3EQ0N";

	@Override
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL+SEARCHED_ITEM+API_KEY); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element

		NodeList nl = doc.getElementsByTagName(KEY_SHORTITEM);
        NodeList nlName = doc.getElementsByTagName(KEY_DESCRIPTION);

        if(nl != null && nl.getLength() > 0) {
            // looping through all item nodes <item>
            for (int i = 0; i < nl.getLength(); i++) {
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);
                // adding each child node to HashMap key => value
                map.put(KEY_NAME, parser.getCharacterDataFromElement(e, KEY_NAME));
                map.put(KEY_KJ, parser.getValue(e, KEY_KJ));
                map.put(KEY_KCAL, parser.getValue(e, KEY_KCAL));


                // adding HashList to ArrayList
                menuItems.add(map);
            }
        }

		// Adding menuItems to ListView
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.listen_item,
				new String[] { KEY_NAME, KEY_KJ, KEY_KCAL }, new int[] {
						R.id.name, R.id.kj, R.id.kcal });

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
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(KEY_NAME, name);
				in.putExtra(KEY_KJ, kj);
				in.putExtra(KEY_KCAL, kcal);
				startActivity(in);

			}
		});
	}
}
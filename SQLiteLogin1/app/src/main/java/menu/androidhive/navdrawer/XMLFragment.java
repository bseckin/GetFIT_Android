package menu.androidhive.navdrawer;

/**
 *  @author Kilinc Osman
 *  @since 5.2.2015
 */

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.packone.login.R;
import com.packone.login.SingleMenuItemActivity;
import com.packone.login.XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class XMLFragment extends ListFragment {

    // Alle statische Variablen

    //URL Adresse
    String URL = "http://fddb.info/api/v12/search/item_short.xml?lang=de";
    //Gesuchte Produkt
    String SEARCHED_ITEM;
    String KEY_SHORTITEM = "shortitem";
    String KEY_NAME = "name";
    String KEY_KJ = "kj";
    String KEY_KCAL = "kcal";
    String KEY_FAT = "fat_gram";
    String KEY_PROT = "protein_gram";
    String KEY_KH = "kh_gram";
    String KEY_SUGAR = "sugar_gram";
    String API_KEY = "&apikey=5U92BAMH4Z3QK6TXVBU3EQ0N";
    String KEY_AMOUNT = "amount";
    EditText inputSearch;

    private View rootView;
    private ConnectivityManager cm;
    private NetworkInfo wlan;
    private NetworkInfo mobil;

    private Context getApplicationContext() {
        return getActivity().getApplicationContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fragment_xml, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);
        Button button1 = (Button) rootView.findViewById(R.id.button1);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isOnline()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), (android.R.style.Theme_Holo_Dialog)));
                        builder.setMessage("Sie benötigen eine Internetverindung!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //do things
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        //CharSequence text = "Kein Internet!";
                        //Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                        //toast.show();
                    } else {

                        SEARCHED_ITEM = inputSearch.getText().toString();
                        SEARCHED_ITEM = SEARCHED_ITEM.replace(" ", "+");

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
                                map.put(KEY_SUGAR, parser.getValue(e, KEY_SUGAR));
                                map.put(KEY_AMOUNT, parser.getValue(e, KEY_AMOUNT));


                                // adding HashList to ArrayList
                                menuItems.add(map);
                            }
                        }

                        // Adding menuItems to ListView
                        ListAdapter adapter = new SimpleAdapter(getApplicationContext(), menuItems,
                                R.layout.listen_item,
                                new String[]{KEY_NAME, KEY_KJ, KEY_KCAL, KEY_FAT, KEY_PROT, KEY_KH, KEY_SUGAR, KEY_AMOUNT}, new int[]{
                                R.id.name, R.id.kj, R.id.kcal, R.id.fat_gram, R.id.protein_gram, R.id.kh_gram, R.id.sugar_gram, R.id.amount});

                        setListAdapter(adapter);

                        // selecting single ListView item
                        ListView lv = getListView();


                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
                                String sugar_gram = ((TextView) view.findViewById(R.id.sugar_gram)).getText().toString();
                                String amount = ((TextView) view.findViewById(R.id.amount)).getText().toString();


                                // Neues Intent wird gestartet
                                Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                                in.putExtra(KEY_NAME, name);
                                in.putExtra(KEY_KJ, kj);
                                in.putExtra(KEY_KCAL, kcal);
                                in.putExtra(KEY_FAT, fat_gram);
                                in.putExtra(KEY_PROT, protein_gram);
                                in.putExtra(KEY_KH, kh_gram);
                                in.putExtra(KEY_SUGAR, sugar_gram);
                                in.putExtra(KEY_AMOUNT, amount);
                                startActivity(in);

                            }
                        });
                    }
                }
            });
        return rootView;
    }

    /**
     * Checkt ob Internet verbindung vorhanden ist
     * @return
     */
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}

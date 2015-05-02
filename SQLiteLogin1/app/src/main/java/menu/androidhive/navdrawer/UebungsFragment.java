package menu.androidhive.navdrawer;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.packone.login.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uebungsliste.BauchUebungen_Activity;
import uebungsliste.BeineUebungen_Activity;
import uebungsliste.BizepsUebungen_Activity;
import uebungsliste.BrustUebungen_Activity;
import uebungsliste.ObererRueckenUebungen_Activity;
import uebungsliste.SchulterUebungen_Activity;
import uebungsliste.TrizepsUebungen_Activity;
import uebungsliste.UntererRueckenUebungen_Activity;

public class UebungsFragment extends ListFragment {

    // Array of strings storing country names
    String[] uebungesname = new String[] {
            "Brust",
            "Oberer Rücken",
            "Unterer Rücken",
            "Beine",
            "Schultern",
            "Bizeps",
            "Trizeps",
            "Bauch",
    };

    // Array of integers points to images stored in /res/drawable/
    int[] icons = new int[]{
            R.drawable.brusticon,
            R.drawable.obererrueckenicon,
            R.drawable.untererrueckenicon,
            R.drawable.beineicon,
            R.drawable.schultervorneicon,
            R.drawable.bizepsicon,
            R.drawable.trizepsiicon,
            R.drawable.bauchicon,
    };

    // Array of strings to store currencies
    String[] currency = new String[] { "Beschreibung..", "", "", "", "", "", "","" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i< uebungesname.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", uebungesname[i]);
            //hm.put("cur","Beschreibung : " + currency[i]);
            hm.put("flag", Integer.toString(icons[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag, R.id.txt, R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        /*
            0 - "Brust",
            1 - "Oberer Rücken",
            2 - "Unterer Rücken",
            3 - "Beine",
            4 - "Schultern",
            5 - "Bizeps",
            6 - "Trizeps",
            7 - "Bauch",
         */
        switch (position){
            case 0: // "Brust" wurde geklickt... Alle Uebungen für die Brust anzeigen
                intent = new Intent(getActivity(), BrustUebungen_Activity.class);
                startActivity(intent);
                break;
            case 1: // "Oberer Ruecken" wurde geklickt...
                intent = new Intent(getActivity(), ObererRueckenUebungen_Activity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity(), UntererRueckenUebungen_Activity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getActivity(), BeineUebungen_Activity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(getActivity(), SchulterUebungen_Activity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(getActivity(), BizepsUebungen_Activity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(getActivity(), TrizepsUebungen_Activity.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(getActivity(), BauchUebungen_Activity.class);
                startActivity(intent);
                break;
        }
        Log.d("onListItemClick", "" + position);
    }
}
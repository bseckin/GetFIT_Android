package info.androidhive.slidingmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.packone.login.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UebungsFragment extends ListFragment {

    // Array of strings storing country names
    String[] uebungesname = new String[] {
            "Brust",
            "Oberer Rücken",
            "Unterer Rücken",
            "Beine",
            "Vordere/Seitliche Schultern",
            "Hintere Schultern",
            "Bizeps",
            "Trizeps",
            "Bauch",
            "Seitlicher Bauch"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            R.drawable.brusticon,
            R.drawable.obererrueckenicon,
            R.drawable.untererrueckenicon,
            R.drawable.beineicon,
            R.drawable.schultervorneicon,
            R.drawable.schulterhintenicon,
            R.drawable.bizepsicon,
            R.drawable.trizepsiicon,
            R.drawable.bauchicon,
            R.drawable.seitlicherbauchicon
    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "Beschreibung..",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i< uebungesname.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", uebungesname[i]);
            //hm.put("cur","Beschreibung : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt, R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.packone.login.R;

public class UebungsFragment extends Fragment {
	
	public UebungsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_uebungen, container, false);

        // Liste arrangieren
        String[] myItems = {"Brust", "Rücken", "Beine", "Schulter", "Bizpes", "Trizeps"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.da_item, myItems);

        // Configure ListView:
        ListView listView = (ListView)rootView.findViewById(R.id.listViewMain);
        listView.setAdapter(adapter);

        return rootView;
    }

    private void populateListView() {

    }
}

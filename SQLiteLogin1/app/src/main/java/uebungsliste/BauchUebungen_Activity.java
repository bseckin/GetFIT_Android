package uebungsliste;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.packone.login.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * Listet alle Uebungen fuer den Bauch auf mit dynamischen Image Loader
 */
public class BauchUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

    private static final String TAG = "StaggeredGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private Uebungsliste_ADAPTER mAdapter;

    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        setTitle("Bauchübungen/Rumpf");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        ArrayList<UebungItem> data = Bauch.getData();

        mAdapter = new Uebungsliste_ADAPTER(this, android.R.layout.simple_list_item_1, data);

        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVED_DATA_KEY, mData);
    }

    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onScrollStateChanged:" + scrollState);
    }

    @Override
    public void onScroll(final AbsListView view, final int firstVisibleItem, final int visibleItemCount, final int totalItemCount) {
        Log.d(TAG, "onScroll firstVisibleItem:" + firstVisibleItem +
                " visibleItemCount:" + visibleItemCount +
                " totalItemCount:" + totalItemCount);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ArrayList<UebungItem> data = Bauch.getData();
        Toast.makeText(this, "" + data.get(position).getText(), Toast.LENGTH_SHORT).show();
                /*
            "Situps",
            "Bauchheben",
            "Klappmesser",
            "Beinheben",
            "Abwechselndes überkreuzen der Beine",
             */

        if(data.get(position).getText().equals("Situps")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=WDSmlFfbgW4")));
        if(data.get(position).getText().equals("Bauchheben")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xeQn7k8nsPI")));
        if(data.get(position).getText().equals("Klappmesser")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=y6Bv_0Shhc8")));
        if(data.get(position).getText().equals("Beinheben")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-rA3K2eEoRw")));
        if(data.get(position).getText().equals("Abwechselndes überkreuzen der Beine")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=nWKTmFv76I8")));
    }
}
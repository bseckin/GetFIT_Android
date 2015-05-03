package uebungsliste;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.packone.login.R;

import java.util.ArrayList;

/*
 * Listet alle Uebungen fuer die Beinmuskulatur auf mit dynamischen Image Loader
 */
public class BeineUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

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

        setTitle("Bauchübungen");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);
        mAdapter = new Uebungsliste_ADAPTER(this, android.R.layout.simple_list_item_1, generateData());

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

    private ArrayList<String> generateData() {
        ArrayList<String> listData = new ArrayList<String>();
        listData.add("http://mhstatic.de/fm/1/thumbnails/Fitness_Lexikon_Uebung_122b.584955.jpg.2409847.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/08/Beinpressen.jpg"); //Fliegende
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/06/Ausfallschritt.jpg"); //schraegbankdrucken
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/08/Beinbeugen-im-Liegen-am-Ger%C3%A4t.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/08/Sitzendes-Wadenheben-am-Ger%C3%A4t.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/08/Stehendes-Wadenheben-am-Ger%C3%A4t.jpg");
        return listData;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}
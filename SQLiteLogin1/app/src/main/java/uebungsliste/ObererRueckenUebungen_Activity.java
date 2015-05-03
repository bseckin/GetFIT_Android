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
 * Listet alle Uebungen fuer den oberen Teil des Rueckens(Latissimus) auf mit dynamischen Image Loader
 */
public class ObererRueckenUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

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

        setTitle("Oberer Ruecken/Latissimus");
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
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/06/Einarmiges-Kurzhantel-Rudern-auf-der-Bank.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/06/Rudern-am-Kabelzug.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/06/Langhantel-Rudern.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/07/Latzug.jpg");
        listData.add("http://www.uebungen.ws/wp-content/uploads/2011/06/Rudern-mit-der-T-Stange-Langhantel.jpg");
        listData.add("http://www.sportplus.org/site/images/stories/products/SportPlus-SP-PUB-005-10100885_2.jpg");
        listData.add("http://i.ytimg.com/vi/Um2ln8ILBQw/maxresdefault.jpg");
        return listData;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}
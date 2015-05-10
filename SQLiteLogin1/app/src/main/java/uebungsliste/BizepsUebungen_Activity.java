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

import java.util.ArrayList;

/*
 * Listet alle Uebungen fuer den Bizeps auf mit dynamischen Image Loader
 */
public class BizepsUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

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

        setTitle("Bizepsübungen");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        ArrayList<UebungItem> data = Bizeps.getData();

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
        ArrayList<UebungItem> data = Bizeps.getData();
        Toast.makeText(this, "" + data.get(position).getText(), Toast.LENGTH_SHORT).show();

        /*
            "Langhantel-Curls",
            "Konzentrations-Curls",
            "Kurzhantel-Curls",
            "Scottcurls",
            "Schrägbank-Scottcurls"
             */

        if(data.get(position).getText().equals("Langhantel-Curls")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=u2HcuquNrJA")));
        if(data.get(position).getText().equals("Konzentrations-Curls")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=gGsNOYyuqW0")));
        if(data.get(position).getText().equals("Kurzhantel-Curls")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=FtAz_85aVxE")));
        if(data.get(position).getText().equals("Scottcurls")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dG6Q6uir6oU")));
    }
}
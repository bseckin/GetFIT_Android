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
 * Listet alle Uebungen fuer die Brustmuskeln auf mit dynamischen Image Loader
 */
public class BrustUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

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

        setTitle("Brustübungen");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        ArrayList<UebungItem> data = Brust.getData();

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
        ArrayList<UebungItem> data = Brust.getData();
        Toast.makeText(this, "" + data.get(position).getText(), Toast.LENGTH_SHORT).show();

        if(data.get(position).getText().equals("Bankdrücken")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=MVO3G1GvwaU")));
        if(data.get(position).getText().equals("Butterfly-am-Kabelzug")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7rVwltgBOUI")));
        if(data.get(position).getText().equals("Kurzhantel-Fliegende")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=A7mGtCwOCdo")));
        if(data.get(position).getText().equals("Schrägbankdrück en")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=L82lODQWOY4")));
        if(data.get(position).getText().equals("Brustpresse")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aB6ouAqairg&feature=youtu.be&t=2m1s")));
        if(data.get(position).getText().equals("Kurzhantel-Bankdrücken")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=X_gttpiWeYY")));
        if(data.get(position).getText().equals("Liegestütze")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ZZsLRHKiAn8")));
    }
}
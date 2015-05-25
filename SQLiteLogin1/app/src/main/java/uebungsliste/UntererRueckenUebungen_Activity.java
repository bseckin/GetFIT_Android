package uebungsliste;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.packone.login.R;

import java.util.ArrayList;
/*
 * Listet alle Uebungen fuer den unteren Ruecken auf mit dynamischen Image Loader
 */
public class UntererRueckenUebungen_Activity extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

    private static final String TAG = "StaggeredGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private Uebungsliste_ADAPTER mAdapter;

    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         ACTIONBAR Farbe, und Textfarbe:
          */
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34585c")));
        bar.setTitle(Html.fromHtml("<font color='#FFFFFF'>Unterer Ruecken Übungen</font>"));
        setContentView(R.layout.gridview);

        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        ArrayList<UebungItem> data = UntererRuecken.getData();

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
        ArrayList<UebungItem> data = UntererRuecken.getData();
        Toast.makeText(this, "" + data.get(position).getText(), Toast.LENGTH_SHORT).show();
        /* Übungsnamen:
            "Kreuzheben",
            "Rückenstrecker",
            "Good-Mornings",
            "Rückenstrecken im Liegen"
        */

        if(data.get(position).getText().equals("Kreuzheben")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kFrBf94S-sA")));
        if(data.get(position).getText().equals("Rückenstrecker")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=f3mi7leyc-M")));
        if(data.get(position).getText().equals("Rückenstrecken im Liegen")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=QHSjfbwNbhE")));
    }
}
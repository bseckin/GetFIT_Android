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

        ArrayList<UebungItem> data = ObererRuecken.getData();

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
        ArrayList<UebungItem> data = ObererRuecken.getData();
        Toast.makeText(this, "" + data.get(position).getText(), Toast.LENGTH_SHORT).show();
        /* Übungsnamen
                "Einarmiges Kurzhantel Rudern auf der Flachbank",
                "Rudern am Kabelzug",
                "Langhantel Rudern",
                "Latzug zur Brust",
                "T-Bar Rudern mit der Langhantel",
                "Klimmzüge",
                "Enges Latziehen zur Brust"
        */

        if(data.get(position).getText().equals("Einarmiges Kurzhantel Rudern")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uYvQ-cf-EtM")));
        if(data.get(position).getText().equals("Rudern am Kabelzug")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=eSORDmFnmjI")));
        if(data.get(position).getText().equals("Langhantel Rudern")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=raTfrz2O3pI")));
        if(data.get(position).getText().equals("Latzug zur Brust")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aDrLiFniKE4")));
        if(data.get(position).getText().equals("T-Bar Rudern mit der Langhantel")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=MlcoD1zKsOs")));
        if(data.get(position).getText().equals("Klimmzüge")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ua4yifBX2t0")));
        if(data.get(position).getText().equals("Enges Latziehen zur Brust")) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_UGioBI-8g8")));
    }
}
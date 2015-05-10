package uebungsliste;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.packone.login.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Uebungsliste_ADAPTER extends ArrayAdapter<UebungItem> {

    private static final String TAG = "SampleAdapter";

    private LayoutInflater mLayoutInflater = null;
    private Random mRandom = null;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();
    private ArrayList<UebungItem> data;

    public Uebungsliste_ADAPTER(Activity context, int textViewResourceId, ArrayList<UebungItem> data) {
        super(context, textViewResourceId, data);

        this.data = data;

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext())
                .defaultDisplayImageOptions(defaultOptions)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new WeakMemoryCache()).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP

        this.mLayoutInflater = LayoutInflater.from(context);
        this.mRandom = new Random();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.staggered_gridview_custom_row_layout, parent, false);

            vh = new ViewHolder();

            vh.imgView = (DynamicHeightImageView) convertView.findViewById(R.id.stg_imgView);

            vh.textView = (DynamicHeightTextView) convertView.findViewById(R.id.stg_textView);

            UebungItem uei = data.get(position);

            ImageLoader.getInstance().displayImage(uei.getImage(), vh.imgView);

            vh.textView.setText(uei.getText());

            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        double positionHeight = getPositionRatio(position);
        vh.imgView.setHeightRatio(positionHeight);

        return convertView;
    }

    static class ViewHolder {
        DynamicHeightImageView imgView;
        DynamicHeightTextView textView;
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5
        // the width
    }
}
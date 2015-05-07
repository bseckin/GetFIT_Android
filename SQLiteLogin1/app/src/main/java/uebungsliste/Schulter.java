package uebungsliste;

import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkay on 06.05.2015.
 */
public class Schulter {
    private static String[] images = new String[] {
        "http://www.uebungen.ws/wp-content/uploads/2012/01/Frontheben.jpg",
        "http://i.ytimg.com/vi/qEwKCR5JCog/sddefault.jpg",
        "http://oi62.tinypic.com/25s8w29.jpg",
        "http://i58.tinypic.com/n1f2vq.jpg",
        "http://www.uebungen.ws/wp-content/uploads/2011/06/vorgebeugtes-seitheben.jpg",
        "http://www.uebungen.ws/wp-content/uploads/2011/07/Butterfly-Reverse.jpg",
        "http://www.uebungen.ws/wp-content/uploads/2011/07/Aufrechtes-Rudern.jpg"
    };

    private static String[] text = new String[] {
            "Frontheben",
            "Kurzhantel Schulterdrücken",
            "Military-Press",
            "Seitheben",
            "vorgebeugtes-seitheben",
            "Butterfly-Reverse",
            "Aufrechtes-Rudern"
    };

    public static ArrayList<UebungItem> getData() {
        ArrayList<UebungItem> data = new ArrayList<UebungItem>();

        for (int i = 0; i < images.length; i++) {
            UebungItem ui = new UebungItem(images[i], text[i]);

            data.add(ui);
        }

        return data;
    }
}
package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class UntererRuecken {
    private static String[] images = new String[] {
            "http://i.imgur.com/aJD4078.jpg",
            "http://i.imgur.com/rkmAQje.jpg",
            "http://i.imgur.com/0ydcXk4.jpg"
    };

    private static String[] text = new String[] {
            "Kreuzheben",
            "Rückenstrecker",
            "Rückenstrecken im Liegen"
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
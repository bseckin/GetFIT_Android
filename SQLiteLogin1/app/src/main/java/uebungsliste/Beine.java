package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Beine {
    private static String[] images = new String[] {
            "http://i.imgur.com/l10OKED.jpg",
            "http://i.imgur.com/OstEw9G.jpg",
            "http://i.imgur.com/YwB0P8Q.jpg",
            "http://i.imgur.com/ENXHf1z.jpg",
            "http://i.imgur.com/1FbuwyD.jpg"
    };

    private static String[] text = new String[] {
            "Kniebeugen",
            "Beinpresse",
            "Ausfallschritt",
            "Beinbeuger",
            "Sitzendes-Wadenheben"
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
package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Beine {
    private static String[] images = new String[] {
            "http://mhstatic.de/fm/1/thumbnails/Fitness_Lexikon_Uebung_122b.584955.jpg.2409847.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/08/Beinpressen.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Ausfallschritt.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/08/Beinbeugen-im-Liegen-am-Ger%C3%A4t.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/08/Sitzendes-Wadenheben-am-Ger%C3%A4t.jpg"

    };

    private static String[] text = new String[] {
            "Kniebeugen",
            "Beinpresse",
            "Ausfallschritt",
            "Beinbeuger",
            "Sitzendes-Wadenheben-am-Gerät"
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
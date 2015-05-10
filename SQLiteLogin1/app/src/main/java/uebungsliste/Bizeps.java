package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Bizeps {
    private static String[] images = new String[] {
            "http://oi61.tinypic.com/zxwjf5.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Konzentriertes-Armbeugen.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Kurzhantel-Armbeugen.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Scottcurls.jpg"
    };

    private static String[] text = new String[] {
            "Langhantel-Curls",
            "Konzentrations-Curls",
            "Kurzhantel-Curls",
            "Scottcurls"
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
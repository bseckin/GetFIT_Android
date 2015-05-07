package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class ObererRuecken {
    private static String[] images = new String[] {
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Einarmiges-Kurzhantel-Rudern-auf-der-Bank.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Rudern-am-Kabelzug.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Langhantel-Rudern.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/07/Latzug.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Rudern-mit-der-T-Stange-Langhantel.jpg",
            "http://www.sportplus.org/site/images/stories/products/SportPlus-SP-PUB-005-10100885_2.jpg",
            "http://i.ytimg.com/vi/Um2ln8ILBQw/maxresdefault.jpg",
    };

    private static String[] text = new String[] {
            "Einarmiges Kurzhantel Rudern auf der Flachbank",
            "Rudern am Kabelzug",
            "Langhantel Rudern",
            "Latzug zur Brust",
            "T-Bar Rudern mit der Langhantel",
            "Klimmzüge",
            "Enges Latziehen zur Brust"
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
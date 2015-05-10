package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class ObererRuecken {
    private static String[] images = new String[] {
            "http://i.imgur.com/YVi66qJ.jpg",
            "http://i.imgur.com/TAW9v4T.jpg",
            "http://i.imgur.com/BQnmPeo.jpg",
            "http://i.imgur.com/6MCBrgJ.jpg",
            "http://i.imgur.com/ALoz8ap.jpg",
            "http://i.imgur.com/DqC5V5j.jpg",
            "http://i.imgur.com/EdZOZwx.jpg",
    };

    private static String[] text = new String[] {
            "Einarmiges Kurzhantel Rudern",
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
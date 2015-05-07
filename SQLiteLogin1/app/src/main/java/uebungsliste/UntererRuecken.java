package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class UntererRuecken {
    private static String[] images = new String[] {
            "http://i62.tinypic.com/s58lr8.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/07/R%C3%BCckenstrecker.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/07/Good-Mornings.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/07/R%C3%BCckenstrecken-im-Liegen.jpg"
    };

    private static String[] text = new String[] {
            "Kreuzheben",
            "Rückenstrecker",
            "Good-Mornings",
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
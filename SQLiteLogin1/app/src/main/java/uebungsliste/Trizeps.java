package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Trizeps {
    private static String[] images = new String[] {
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Dips.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Arnold-Dips.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Enges-Bankdr%C3%BCcken.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Trizeps-Liegest%C3%BCtze.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/06/Kickbacks.jpg",
            "http://mhstatic.de/fm/1/thumbnails/Fitness_Lexikon_Uebung_101b.584195.jpg.2409807.jpg"
    };

    private static String[] text = new String[] {
            "Dips",
            "Arnold-Dips",
            "Enges Bankdrücken",
            "Trizeps Liegestütze",
            "Kickbacks",
            "Trizepsdrücken am Seilzug"
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
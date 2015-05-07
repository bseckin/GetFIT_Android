package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Bauch {
    private static String[] images = new String[] {
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Crunches.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Sit-Ups-auf-der-Schr%C3%A4gbank.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/H%C3%BCftheben.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Crunches-mit-ausgestreckten-Armen.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Klappmesser.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Beinheben.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Abwechselndes-%C3%9Cberkreuzen-der-Beine.jpg",
            "http://www.uebungen.ws/wp-content/uploads/2011/09/Korkenzieher.jpg"
    };

    private static String[] text = new String[] {
            "Crunches",
            "Situps",
            "Bauchheben",
            "Crunches-mit-ausgestreckten-Armen",
            "Klappmesser",
            "Beinheben",
            "Abwechselndes überkreuzen der Beine",
            "Beinheben",
            "Korkenzieher"
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
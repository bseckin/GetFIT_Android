package uebungsliste;

import java.util.ArrayList;

/**
 * Created by Berkay on 07.05.2015.
 */
public class Brust {
    private static String[] images = new String[] {
            "http://i.imgur.com/vgkRPWu.jpg",
            "http://i.imgur.com/ZKBbtco.jpg",
            "http://i.imgur.com/8wfgRA1.jpg",
            "http://i.imgur.com/Y4F3Lug.jpg",
            "http://i.imgur.com/TI5O1xi.jpg",
            "http://i.imgur.com/xUByAuA.jpg",
            "http://i.imgur.com/ZKBbtco.jpg"

    };

    private static String[] text = new String[] {
            "Butterfly-am-Kabelzug",
            "Kurzhantel-Fliegende",
            "Bankdrücken",
            "Schräbankdrücken",
            "Brustpresse",
            "Kurzhantel-Bankdrücken",
            "Liegestütze"
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
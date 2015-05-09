package uebungsliste;

/**
 * Created by Berkay on 06.05.2015.
 */
public class UebungItem {
    private String image;
    private String text;

    public UebungItem(String image, String text) {
        this.image = image;
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}

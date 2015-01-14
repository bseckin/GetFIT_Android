package trainingsplan;

/**
 * Trainingsplan für Gewichtsverlust
 * Created by Berkay on 26.11.2014.
 */
public class Gewichtsverlust implements IZiel {
    // Konstruktor
    public Gewichtsverlust() {}

    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        return new String[0][][];
    }

    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        return new String[0][][];
    }
}

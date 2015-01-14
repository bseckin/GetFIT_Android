package trainingsplan;

/**
 * Trainingsplan mit mehr Fokus auf Ausdauer
 * Created by Berkay on 26.11.2014.
 */
public class Ausdauer implements IZiel {
    // Konstruktor
    public Ausdauer() {}

    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        return new String[0][][];
    }

    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        return new String[0][][];
    }
}

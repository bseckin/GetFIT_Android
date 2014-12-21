package trainingsplan;

/**
 * Traningsplan für Rückenstärkung
 * Created by Berkay on 26.11.2014.
 */
public class Rueckenstaerkung implements IZiel {
    // Wie oft pro Woche Training?
    private int frequenz;

    // Konstruktor
    public Rueckenstaerkung(int frequenz) {
        this.frequenz = frequenz;
    }

    @Override
    public String[][] erstellePlan() {
        return new String[0][];
    }

    public int getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(int frequenz) {
        this.frequenz = frequenz;
    }
}

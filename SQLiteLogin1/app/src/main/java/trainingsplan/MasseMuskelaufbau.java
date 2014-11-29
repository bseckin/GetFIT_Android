package trainingsplan;

/**
 * Trainingsplan für Masse und Muskelaufbau
 * Created by Berkay on 26.11.2014.
 */
public class MasseMuskelaufbau implements IZiel {
    // Wie oft pro Woche Training?
    private int frequenz;

    // Konstruktor
    public MasseMuskelaufbau(int frequenz) {
        this.frequenz = frequenz;
    }

    @Override
    public void erstellePlan() {
    }

    public int getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(int frequenz) {
        this.frequenz = frequenz;
    }
}

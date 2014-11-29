package trainingsplan;

/**
 * Trainingsplan für allgemeine Fitness
 * Created by Berkay on 26.11.2014.
 */
public class AllgemeineFitness implements IZiel{
    // Wie oft pro Woche Training?
    private int frequenz;

    // Konstruktor
    public AllgemeineFitness(int frequenz) {
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

package trainingsplan;

/**
 * Created by Berkay on 26.11.2014.
 */
public class Rueckenstaerkung implements IZiel {
    /**
     * Traningsplan für Rückenstärkung
     */
    // Wie oft Training?
    private int _frequenz;

    // Konstruktor
    public Rueckenstaerkung(int frequenz){
        _frequenz = frequenz;
    }

    @Override
    public void erstellePlan() {

    }

    public int getFrequenz() {
        return _frequenz;
    }

    public void setFrequenz(int frequenz) {
        this._frequenz = frequenz;
    }

}

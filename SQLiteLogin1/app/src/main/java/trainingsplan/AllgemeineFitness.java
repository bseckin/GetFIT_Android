package trainingsplan;

/**
 * Trainingsplan für allgemeine Fitness
 * Created by Berkay on 26.11.2014.
 */
public class AllgemeineFitness implements IZiel{
    // Konstruktor
    public AllgemeineFitness() {}

    @Override
    public String[][] erstellePlan(int frequenz) {
        //2x pro Woche
        if (frequenz == 2) {
            String[][] plan = {
                    {"Laufen", "Flys", "Dips"},
                    {"3", "3", "2"}
            };
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche

        } else if ( frequenz >= 4 ) { //3x pro Woche

        }

        return new String[0][];
    }
}

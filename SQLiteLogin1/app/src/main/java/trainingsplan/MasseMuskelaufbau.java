package trainingsplan;

/**
 * Trainingsplan für Masse und Muskelaufbau
 * Created by Berkay on 26.11.2014.
 */
public class MasseMuskelaufbau implements IZiel {
    // Konstruktor
    public MasseMuskelaufbau() {}

    @Override
    public String[][] erstellePlan(int frequenz) {
        //2x pro Woche
        if ( frequenz == 2) {
            String[][] plan = {
                    {"BENCHPRESS Fark masse geht ab Bru", "Flys", "Dips"},
                    {"3", "3", "2"}
            };
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche

        } else if ( frequenz >= 4 ) { //3x pro Woche

        }

        return new String[0][];
    }
}

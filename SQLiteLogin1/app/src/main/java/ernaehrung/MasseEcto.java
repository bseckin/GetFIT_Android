package ernaehrung;

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public class MasseEcto extends Ernaehrungsplan {

    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolendesPlan) {
        AErnaehrung plan = null;
        if (pZuHolendesPlan.equals("Masse plan für Ectomorph")) {
            plan = new Ectomorph();
        }

        else {
            System.err.println("Ungültig!");
        }
        return plan;
    }
}

package ernaehrung;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class Mesomorph extends Ernaehrungsplan{

    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolenderPlan) {
        AErnaehrung plan = null;
        if (pZuHolenderPlan.equals("Masse und Muskelaufbau – für Schlanke Menschen")) {
            plan = new MasseEcto();
        }
        else {
            System.err.println("Gewichtsverlust");
        }
        return plan;
    }
}

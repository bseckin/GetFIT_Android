package ernaehrung;

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public class Ectomorph extends Ernaehrungsplan{


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

package ernaehrung;

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public class Ectomorph extends Ernaehrungsplan{


    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolendesPlan) {
       AErnaehrung plan = null;
        if (pZuHolendesPlan.equals("MasseEcto")) {
            plan = new MasseEcto();
        }
        else {
            System.err.println("Ungültig!");
        }
        return plan;
    }


}

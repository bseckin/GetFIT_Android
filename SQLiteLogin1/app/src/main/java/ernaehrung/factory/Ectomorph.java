package ernaehrung.factory;

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public class Ectomorph extends Ernaehrungsplan{


    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolenderPlan) {
       AErnaehrung plan = null;

          plan = new DefiEcto();

        return plan;
    }


}

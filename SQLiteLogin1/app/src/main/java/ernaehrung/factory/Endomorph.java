package ernaehrung.factory;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class Endomorph extends Ernaehrungsplan{
    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolenderPlan) {
        AErnaehrung plan = null;

        plan = new DefiEndo();

        return plan;
    }
}

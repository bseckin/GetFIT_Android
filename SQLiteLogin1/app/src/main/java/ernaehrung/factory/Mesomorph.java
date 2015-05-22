package ernaehrung.factory;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class Mesomorph extends Ernaehrungsplan{

    @Override
    protected AErnaehrung createAErnaehrung(String pZuHolenderPlan) {
        AErnaehrung plan = null;
            plan = new MasseMeso();

        return plan;
    }
}

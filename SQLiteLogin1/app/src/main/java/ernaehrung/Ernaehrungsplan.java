package ernaehrung;

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public abstract class Ernaehrungsplan {

    public AErnaehrung holePlan(String pZuHolendesPlan) {
        //Delegation der Objekterstellung an Subklasse
        AErnaehrung plan = createAErnaehrung(pZuHolendesPlan);

        //ICH BINS MUHI BRAH
        //weitere verarbeitung
        plan.goal();

        return plan;
    }

    //Definition der Factory Method
    protected abstract AErnaehrung createAErnaehrung(String pZuHolenderPlan);

}

package trainingsplan.strategy;

/**
 * Created by Berkay on 26.11.2014.
 */
public interface IZiel {
    public String[][][] erstellePlan_Anfaenger(int frequenz);
    public String[][][] erstellePlan_Fortgeschritten(int frequenz);
}

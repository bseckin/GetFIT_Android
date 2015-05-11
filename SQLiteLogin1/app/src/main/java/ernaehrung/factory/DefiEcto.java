package ernaehrung.factory;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class DefiEcto extends AErnaehrung{

    private String[][] morgens;
    private String[][] mittags;
    private String[][] preWorkout;
    private String[][] nachmittag;
    private String[][] abends;

    public String[][][] starten() {
        String[][][] ret = new String[][][]{
                {{"Bez","Radischen", "Quark", "Kräuter", "Vollkornbrot"},
                        {"Menge","100", "500", "50", "200"}},
                {{"Bez","Apfel"},{"Menge","200"}},
                {{"Bez","Vollkornnudeln", "Möhre","Zucchini","Broccoli", "Kochschinken","Schlagsahne","Milch"}, {"Menge","100","80","100","50","50","40","200"}},
                {{"Bez","Möhre","Gemüse","Speisequark","Kräuter"}, {"Menge","50","100","125","50"}},
                {{"Bez","Kartoffel", "Möhre", "Broccholi","Seelachsfilet",}, {"Menge","500", "50", "150","300"}}};
        return (ret);
    }
}

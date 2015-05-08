package ernaehrung.factory;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class DefiEndo extends AErnaehrung{

    private String[][] morgens;
    private String[][] mittags;
    private String[][] preWorkout;
    private String[][] nachmittag;
    private String[][] abends;

    public String[][][] starten() {
        String[][][] ret = new String[][][]{
                {{"Radischen", "Quark", "Kräuter", "Vollkornbrot"},
                        {"100", "500", "50", "200"}},
                {{"Apfel"},{"200"}},
                {{"Vollkornnudeln", "Möhre","Zucchini","Broccoli", "Kochschinken","Schlagsahne","Milch"}, {"100","80","100","50","50","40","200"}},
                {{"Möhre","Gemüse","Speisequark","Kräuter"}, {"50","100","125","50"}},
                {{"Kartoffel", "Möhre", "Broccholi","Seelachsfilet",}, {"500", "50", "150","300"}}};
        return (ret);
    }
}

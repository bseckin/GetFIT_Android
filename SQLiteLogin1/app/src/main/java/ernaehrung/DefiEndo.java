package ernaehrung;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class DefiEndo {
    private String[][] morgens;
    private String[][] mittags;
    private String[][] preWorkout;
    private String[][] nachmittag;
    private String[][] abends;

    public String[][][] starten() {
        String[][][] ret = new String[][][]{
                {{"Radischen", "Quark", "Kräuter", "Vollkornbrot"},
                        {"45", "500", "50", "40"}},
                {{"Apfel"},{"200"}},
                {{"Vollkornnudeln", "Möhre","Zucchini","Broccoli", "Kochschinken","Schlagsahne","Milch"}, {"50","30","50","50","50","40","50"}},
                {{"Möhre","Gemüse","Speisequark","Kräuter"}, {"50","100","125","25"}},
                {{"Kartoffel", "Möhre", "Broccholi","Seelachsfilet",}, {"100", "50", "50","150"}}};
        return (ret);
    }
}

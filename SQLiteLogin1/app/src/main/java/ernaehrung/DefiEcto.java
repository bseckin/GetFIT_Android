package ernaehrung;

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
        morgens = new String[][]{{"3 Radischen", "2 x Quark", "Kräuter", "Vollkornbrot"},
                {"3x15g", "2 x 250g", "beliebig", "40g"}};
        mittags = new String[][]{{"Apfel"},
                {"200g"}};
        preWorkout = new String[][]{{"Banane"},
                {"mittlere Größe"}};
        nachmittag = new String[][]{{"Nüsse"},
                {"50g"}};
        abends = new String[][]{{"Thunfisch", "Mais", "Magerquark"},
                {"150g", "150g", "500g"}};

        String[][][] ret = new String[][][]{
                {{"3 Radischen", "2 x Quark", "Kräuter", "Vollkornbrot"},
                        {"3x15g", "2 x 250g", "beliebig", "40g"}},
                {{"Apfel"},{"200g"}},
                {{"Vollkornnudeln", "Möhre","Zucchini","Broccoli", "Kochscinken","Schlagsahne","Milch"}, {"50g","30g","50g","50g","50g","40ml","50ml"}},
                {{"Möhre","Gemüse","Speisequark mager","Kräuter"}, {"50g","100g","125g","25g"}},
                {{"Kartoffel", "Möhre", "Broccholi","Seelachsfilet",}, {"100g", "50g", "50g","150g"}}};
        return (ret);
    }
}

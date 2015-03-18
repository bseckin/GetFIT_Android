package ernaehrung;
/**
 * Morgens

 2 Scheiben Eiweißbrot (2x 60g) 	321,6 	32,16 	12,72 	12
 2 Scheiben Hähnchenbrust (2x 20g) 	42 	8,4 	0,4 	0,8
 Butter (Brotaufstrich, 10g) 	74 	0,1 	0,1 	8,2
 2 gekochte Eier (Größe M) 	184,8 	15,4 	0,6 	13,2

 Gesamt 	622,4 	56,06 	13,82 	34,2

 Mittags

 Putenbrust (250g) 	267,5 	60 	0 	2,5
 Reis (60g) 	209,4 	4,2 	46,6 	0,4

 Gesamt 	476,9 	64,2 	46,6 	2,9

 Pre-Workout

 Banane (mittlere Größe) 	105 	1,29 	26,95 	0,4

 Nachmittags

 Nüsse (50g) 	160 	14,4 	7,54 	44,8

 Abends

 Thunfisch (150g) 	169,5 	39 	0 	1,5
 Mais (150g) 	120 	4,35 	16,2 	2,85

 Gesamt 	289,5 	43,35 	16,2 	4,35

 Vor dem Schlafen

 Magerquark (500g) 	310 	60 	20 	1

 Gesamt am Tag: 	Kcal 	EW (g) 	KH (g) 	F (g)
 1963,8 	239,3 	131,11 	87,65
 *
 */

/**
 * Created by Muhammed5 on 26.11.2014.
 */
public class MasseEcto extends AErnaehrung {

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
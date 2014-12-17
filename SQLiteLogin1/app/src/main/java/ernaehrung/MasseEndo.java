package ernaehrung;

import android.util.Log;

/**
 * Created by Muhammed5 on 17.12.2014.
 */
public class MasseEndo {

    private String[][] morgens;
    private String[][] mittags;
    private String[][] preWorkout;
    private String[][] nachmittag;
    private String[][] abends;

    public String[][][] starten() {
        Log.d("!!!!!!!!!!!!!!!!!!$$$$$$$$$$$$$$$$$$$", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        morgens = new String[][]{{"2 Scheiben Eiweißbrot", "2 Scheiben Haenchenbrust", "Butter", "2 gekochte Eier"},
                {"2x60g", "2x20g", "10g", "größe M"}};
        mittags = new String[][]{{"Putenbrust", "Reis"},
                {"250g", "60g"}};
        preWorkout = new String[][]{{"Banane"},
                {"mittlere Größe"}};
        nachmittag = new String[][]{{"Nüsse"},
                {"50g"}};
        abends = new String[][]{{"Thunfisch", "Mais", "Magerquark"},
                {"150g", "150g", "500g"}};

        String[][][] ret = new String[][][]{
                {{"2 Scheiben Eiweißbrot", "2 Scheiben Haenchenbrust", "Butter", "2 gekochte Eier"},
                        {"2x60g", "2x20g", "10g", "größe M"}},
                {{"Putenbrust", "Reis"}, {"250g", "60g"}},
                {{"Banane"}, {"mittlere Größe"}},
                {{"Nüsse"}, {"50g"}},
                {{"Thunfisch", "Mais", "Magerquark"}, {"150g", "150g", "500g"}}};
        return (ret);
    }
}

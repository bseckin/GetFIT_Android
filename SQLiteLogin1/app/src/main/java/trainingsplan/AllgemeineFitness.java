package trainingsplan;

/**
 * Trainingsplan für allgemeine Fitness
 * Created by Berkay on 26.11.2014.
 */
public class AllgemeineFitness implements IZiel{
    // Konstruktor
    public AllgemeineFitness() {}

    @Override
    public String[][][] erstellePlan(int frequenz) {
        //2x pro Woche
        if (frequenz == 2) {
            /*
            Dieser Plan ist von LOOX:
            "FITNESS STEIGERN - GANZKÖRPER FIT" - Sven Seidenstücker
             */
            String[][][] plan = {{
                    {
                            "Kniebeugen",
                            "Brustpresse",
                            "Latzug breit zur Brust",
                            "Frenchpress",
                            "Bizepsmaschine",
                            "Rückenstrecker",
                            "Crunch"
                    },
                    {
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3"
                    }
            }};
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche
            /*
            Dieser Plan ist von LOOX:
            "FITNESS STEIGERN - GANZKÖRPER BASIC" - Benny Braun
             */
            String[][][] plan = {{
                    {
                            "Bankdrücken",
                            "Butterfly",
                            "Latzugmaschine",
                            "Ruderzugmaschine",
                            "Beinpresse",
                            "Crunch",
                            "Rückenstrecker"
                    },
                    {
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3"
                    }
            }};
            return plan;
        } else if ( frequenz >= 4 ) { //3x pro Woche
            String[][] plan = {
                    {
                            "Bankdrücken",
                            "Butterfly",
                            "Latzugmaschine",
                            "Ruderzugmaschine",
                            "Beinpresse",
                            "Crunch",
                            "Rückenstrecker"
                    },
                    {
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3",
                            "3"
                    }
            };
        }

        return new String[0][][];
    }
}

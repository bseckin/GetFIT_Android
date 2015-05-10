package trainingsplan.strategy;

/**
 * Trainingsplan für Gewichtsverlust
 * Created by Berkay on 26.11.2014.
 */
public class Gewichtsverlust implements IZiel {
    // Konstruktor
    public Gewichtsverlust() {}

    /**
     * =============================================================================================
     *                                      ANFÄNGER -  Plan
     * =============================================================================================
     * Erstellt einen Plan für einen Anfänger, mit seiner ausgewählten Trainingsfrequenz.
     *
     * @param frequenz
     * @return anfaenger plan
     */
    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        //2x pro Woche
        if ( frequenz >= 2 ) {
            // GANZKÖRPER
            String[][][] plan = {
                    {
                            {
                                    "Kniebeugen",
                                    "Brustpresse",
                                    "Ruderzugmaschine",
                                    "Butterfly Reverse",
                                    "Crunch",
                                    "Laufband"
                            },
                            {
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "25 Minuten"
                            }
                    },
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Brustpresse",
                                    "Latziehen zur Brust",
                                    "Butterfly Reverse",
                                    "Crunch",
                                    "Rückenstrecker",
                                    "Laufband"

                            },
                            {
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "25 Minuten"
                            }
                    }
            };
            return plan;
        }
        return new String[0][][];
    }


    /**
     * =============================================================================================
     *                               FORTGESCHRITTEN/ERFAHREN - Plan
     * =============================================================================================
     *
     * Erstellt einen Plan für einen ERFAHRENEN, mit seiner ausgewählten Trainingsfrequenz.
     *
     * @param frequenz
     * @return fortgeschrittener plan
     */
    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        //2x pro Woche
        if ( frequenz == 2) {
            // GANZKÖRPER
            String[][][] plan = {
                    {   // --- 1te TRAININGSEINHEIT
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Bankdrücken",
                                    "Butterfly",
                                    "Kurzhantel Rudern",
                                    "Latzug zur Brust",
                                    "Crunch"
                            },
                            // SATZZAHL
                            {
                                    "4",
                                    "2",
                                    "3",
                                    "2",
                                    "3",
                                    "2",
                                    "3",
                            }
                    },
                    {   // --- 2te TRAININGSEINHEIT
                            {
                                    "Schräges Bankdrücken",
                                    "Fliegende",
                                    "Ruderzugmaschine",
                                    "Enges Latziehen zur Brust",
                                    "Crosstrainer"
                            },
                            // SATZZAHL
                            {
                                    "3",
                                    "2",
                                    "3",
                                    "3",
                                    "30 Minuten",
                            }

                    }
            };
            return plan;

        } else if ( frequenz >= 3 ) { //3x pro Woche
            String[][][] plan = {
                    // 1te TRAININGSEINHEIT
                    {
                            {
                                    "Crosstrainer",
                                    "Bankdrücken",
                                    "Fliegende",
                                    "Dips",
                                    "Crunches",
                                    "Laufbaund"
                            },
                            {
                                    "15 Minuten",
                                    "3",
                                    "2",
                                    "3",
                                    "3",
                                    "30 Minuten"
                            }
                    },
                    // 2te  TRAININGSEINHEIT
                    {
                            {
                                    "Rudergerät",
                                    "Kreuzheben",
                                    "Kurzhantel Rudern",
                                    "Latzug weit zur Brust",
                                    "Laufband"
                            },
                            {
                                    "10 Minuten",
                                    "3",
                                    "3",
                                    "3",
                                    "30 Minuten"
                            }
                    },

                    // 3te  TRAININGSEINHEIT
                    {
                            {
                                    "Crosstrainer - Laufen",
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Wadenheben",
                                    "Laufband"
                            },
                            {
                                    "10 Minuten",
                                    "4",
                                    "4",
                                    "3",
                                    "20 Minuten"
                            }
                    }
            };
            return plan;
        }
        return new String[0][][];
    }
}

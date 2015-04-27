package trainingsplan;

/**
 * Traningsplan für Rückenstärkung
 * Created by Berkay on 26.11.2014.
 */
public class Rueckenstaerkung implements IZiel {
    // Konstruktor
    public Rueckenstaerkung() {}


    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        //@TODO TP NICHT 3x/4x das gleiche! --ALLGEMEINE FITNESS--
        //@TODO MANN/FRAU TP?
        //2x pro Woche
        if (frequenz == 2) {
            /*
            Dieser Plan ist von LOOX:
            "RÜCKENKRÄFTIGUNG - RÜCKEN FIT" - Johannes Luckas
             */
            String[][][] plan = {
                    {
                        {
                            "Kreuzheben",
                            "Ruderzugmaschine",
                            "Butterfly Reverse",
                            "Brustpresse",
                            "Latzugmaschine",
                            "Beinpresse",
                            "Beinheben/Crunches",
                        },
                        {
                            "3",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                        }
                    },
                    {
                        {
                                    "Kreuzheben",
                                    "Ruderzugmaschine",
                                    "Butterfly Reverse",
                                    "Brustpresse",
                                    "Latzugmaschine",
                                    "Beinpresse",
                                    "Beinheben/Crunches",
                        },
                        {
                                    "3",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                                    "2",
                        }
                    }
            };
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche
            /*
            Dieser Plan ist von LOOX:
            "RÜCKENKRÄFTIGUNG - RÜCKEN FIT" - Johannes Luckas
             */

            String[][][] plan = {
                    // 1te Einheit
                    {
                        {
                            "Ruderzugmaschine",
                            "Butterfly Reverse",
                            "Brustpresse",
                            "Latzugmaschine eng/weiter Griff",
                            "Beinpresse",
                            "Reverse Crunch",
                            "Bauchmaschine",
                            "Rückenstrecker"
                        },
                        {
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2"
                        }
                    },
                    // 2te Einheit
                    {
                        {
                            "Kreuzheben",
                            "Ruderzugmaschine",
                            "Butterfly Reverse",
                            "Brustpresse",
                            "Latzugmaschine",
                            "Beinpresse",
                            "Beinheben/Crunches",
                        },
                        {
                            "3",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                        }
                    },
                    // 3te Einheit
                    {
                        {
                            "Ruderzugmaschine",
                            "Butterfly Reverse",
                            "Brustpresse",
                            "Latzugmaschine eng/weiter Griff",
                            "Beinpresse",
                            "Reverse Crunch",
                            "Bauchmaschine",
                            "Rückenstrecker"
                        },
                        {
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2"
                        }
                    }
            };
            // Plan zurückgeben
            return plan;
        } else if ( frequenz >= 4 ) { //3x pro Woche
            /*
            Dieser Plan ist von LOOX:
            "RÜCKENKRÄFTIGUNG - RÜCKEN FIT" - Johannes Luckas
             */
            String[][][] plan = {{
                    {
                            "Ruderzugmaschine",
                            "Butterfly Reverse",
                            "Brustpresse",
                            "Latzugmaschine eng/weiter Griff",
                            "Beinpresse",
                            "Reverse Crunch",
                            "Bauchmaschine",
                            "Rückenstrecker"
                    },
                    {
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2",
                            "2"
                    }
            }};
            // Plan zurückgeben
            return plan;
        }

        return new String[0][][];
    }

    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        return new String[0][][];
    }
}

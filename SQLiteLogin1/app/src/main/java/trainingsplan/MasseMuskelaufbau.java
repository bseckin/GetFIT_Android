package trainingsplan;

/**
 * Trainingsplan für "Masse und Muskelaufbau"
 *
 * Konkrete implementierung der PLÄNE.
 * Je nach Frequenz(Häufigkeit), und Erfahrungslevel wird der Plan erstellt.
 *
 * Created by Berkay on 26.11.2014.
 */
public class MasseMuskelaufbau implements IZiel {
    // leerer Konstruktor
    public MasseMuskelaufbau() {}



    // ===================================== ANFÄNGER ======================================== //

    /**
     * Erstellt einen Plan für einen Anfänger, mit seiner ausgewählten Trainingsfrequenz.
     *
     * @param frequenz
     * @return
     */
    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        return new String[0][][];
    }

    // ==================================== FORTGESCHRITTEN ===================================== //

    /**
     * Erstellt einen Plan für einen Anfänger, mit seiner ausgewählten Trainingsfrequenz.
     *
     * @param frequenz
     * @return
     */
    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        //2x pro Woche
        if ( frequenz == 2) {
            // GANZKÖRPER
            String[][][] plan = {
                    {
                        {
                        "Grundübung: Bankdrücken",
                        "Butterfly/Flys",
                        "Kurzhantel-Rudern",
                        "Ruderzugmaschine",
                        "Beinpresse",
                        "Crunch",
                        "Rückenstrecker"
                        },
                        {
                        "3",
                        "2",
                        "3",
                        "3",
                        "3",
                        "2"
                        }
                    }
            };
            return plan;

        } else if ( frequenz == 3 ) { //3x pro Woche
            //@TODO SPLITTRAINING ALSO nicht immer das gleiche trainieren -> hole nächste Einheit wenn diese Fertig
            // PUSH | PULL | BEINE
            String[][][] plan = {
                    // --- ERSTES ELEMENT
                    {
                        {
                                "TAG 1 1 1 1 Grundübung: Bankdrücken",
                                "Butterfly/Flys",
                                "Kurzhantel-Rudern",
                                "Ruderzugmaschine",
                                "Beinpresse",
                                "Crunch",
                                "Rückenstrecker"
                        },
                        {
                                "3",
                                "2",
                                "3",
                                "3",
                                "3",
                                "2"
                        }
                    },
                    // --- ZWEITES ELEMENT
                    {
                            {
                                    "TAG 2 2 2 2 Grundübung: Bankdrücken",
                                    "Butterfly/Flys",
                                    "Kurzhantel-Rudern",
                                    "Ruderzugmaschine",
                                    "Beinpresse",
                                    "Crunch",
                                    "Rückenstrecker"
                            },
                            {
                                    "3",
                                    "2",
                                    "3",
                                    "3",
                                    "3",
                                    "2"
                            }
                    },

                    // --- DRITTES ELEMENT
                    {
                            {
                                    "TAG 3 3 3 3 3 Grundübung: Bankdrücken",
                                    "Butterfly/Flys",
                                    "Kurzhantel-Rudern",
                                    "Ruderzugmaschine",
                                    "Beinpresse",
                                    "Crunch",
                                    "Rückenstrecker"
                            },
                            {
                                    "3",
                                    "2",
                                    "3",
                                    "3",
                                    "3",
                                    "2"
                            }
                    }
            };
            return plan;

        } else if ( frequenz >= 4 ) { //3x pro Woche
            // PUSH | PULL |  BEINE | SCHULTERN
            String[][][] plan = {
                    // PUSH --- ERSTES ELEMENT
                    {
                            {
                                    "Bankdrücken Langhantel",
                                    "Schrägbankdrücken KH",
                                    "Fliegende",
                                    "Dips",
                                    "Beinheben",
                                    "Crunches",
                            },
                            {
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "3"
                            }
                    },
                    // PULL --- ZWEITES ELEMENT
                    {
                            {
                                    "Kreuzheben",
                                    "Ruderzugmaschine",
                                    "Latzug zur Brust - weiter Griff",
                                    "Latzug zur Brust - enger Griff",
                                    "Beinpresse",
                                    "Bauch - Situps auf der negativ Bank",
                                    "Bauch - Bauchmaschine"
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
                    },

                    // BEINE--- DRITTES ELEMENT
                    {
                            {
                                    "Grundübung: Kniebeugen",
                                    "Beinpresse",
                                    "Leg extensions",
                                    "Leg curls",
                                    "Wadenheben"
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                                    "3"
                            }
                    },
                    // SCHULTER/ARME--- VIERTES ELEMENT
                    {
                            {
                                    "Schultedrücken",
                                    "Butterfly umgekehrt(reverse)",
                                    "Trizepsdrücken am Kabelzug",
                                    "Kurzhantel Stirndrücken",
                                    "Bizeps Hammercurls",
                            },
                            {
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "3"
                            }
                    }

            };
            return plan;
        }
        return new String[0][][];
    }
}

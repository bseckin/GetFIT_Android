package trainingsplan.strategy;

/**
 * Traningsplan für Rückenstärkung
 * Created by Berkay on 26.11.2014.
 */
public class Rueckenstaerkung implements IZiel {
    // Konstruktor
    public Rueckenstaerkung() {}


    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        //2x pro Woche
        if (frequenz == 2) {
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
            String[][][] plan = {
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
                            },
                    },

                    {
                            {
                                "Bankdrücken",
                                "Kurzehantel Fliegende",
                                "Kniebeugen",
                                "Rückenstrecker",
                                "Bauchmaschine"
                            },
                            {
                                "3",
                                "2",
                                "3",
                                "3",
                                "2"
                            }
                    }
            };
            // Plan zurückgeben
            return plan;
        }

        return new String[0][][];
    }

    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        //2x pro Woche
        if (frequenz == 2) {
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
        } else if ( frequenz >= 3 ) { //3x pro Woche
            String[][][] plan = {
                    // 1te Einheit
                    {
                            {
                                    "Ruderzugmaschine",
                                    "Butterfly Reverse",
                                    "Bankdrücken",
                                    "Kurzhantel Fliegende",
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
                                    "Kurzhantel Rudern",
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
        } else if ( frequenz == 4 ) { //3x pro Woche
            String[][][] plan = {
                    // 1te Einheit
                    {
                            {
                                    "Ruderzugmaschine",
                                    "Butterfly Reverse",
                                    "Bankdrücken",
                                    "Kurzhantel Fliegende",
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
                                    "Kurzhantel Rudern",
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
                    // 4te Einheit
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Wadenheben sitzend",
                                    "Rückenstrecker",
                                    "Bauchmaschine"
                            },
                            {
                                    "4",
                                    "3",
                                    "2",
                                    "3",
                                    "2"
                            }
                    }
            };
            // Plan zurückgeben
            return plan;
        }
        return new String[0][][];
    }
}

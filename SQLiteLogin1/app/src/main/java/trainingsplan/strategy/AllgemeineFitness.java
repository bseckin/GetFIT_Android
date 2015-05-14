package trainingsplan.strategy;

/**
 * Trainingsplan für allgemeine Fitness
 * Created by Berkay on 26.11.2014.
 */
public class AllgemeineFitness implements IZiel{
    // Konstruktor
    public AllgemeineFitness() {}

    /**
     *
     * @param frequenz
     * @return
     */
    @Override
    public String[][][] erstellePlan_Anfaenger(int frequenz) {
        //2x pro Woche
        if (frequenz == 2) {
            String[][][] plan = {
                    // --- 1te TRAININGSEINHEIT
                    {
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
                    },
                    // --- 2te TRAININGSEINHEIT
                    {
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
                    }
            };
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche
            // PUSH | PULL | BEINE
            String[][][] plan = {
                    // --- PUSH - 1te TRAININGSEINHEIT
                    {
                            {
                                    "Bankdrücken Langhantel",
                                    "Fliegende (Kurzhanteln)",
                                    "Dips",
                                    "Bauch - Beinheben hängend",
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                            }
                    },
                    // --- PULL - 2te  TRAININGSEINHEIT
                    {
                            {
                                    "Kreuzheben",
                                    "Rudern am Kabelzug",
                                    "Latzug zur Brust - enger Griff",
                                    "Reverse Flys",
                                    "Bizeps Curls",
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

                    // --- BEINE 3te  TRAININGSEINHEIT
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Laufband",
                                    "Crunches"
                            },
                            {
                                    "4",
                                    "3",
                                    "20 Minuten",
                                    "3"
                            }
                    },
            };
            return plan;
        }  else if ( frequenz == 4 ) { //3x pro Woche
            // PUSH | PULL | BEINE
            String[][][] plan = {
                    // --- PUSH - 1te TRAININGSEINHEIT
                    {
                            {
                                    "Bankdrücken Langhantel",
                                    "Fliegende (Kurzhanteln)",
                                    "Dips",
                                    "Bauch - Beinheben hängend",
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                            }
                    },
                    // --- PULL - 2te  TRAININGSEINHEIT
                    {
                            {
                                    "Kreuzheben",
                                    "Rudern am Kabelzug",
                                    "Latzug zur Brust - enger Griff",
                                    "Reverse Flys",
                                    "Bizeps Curls",
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

                    // --- BEINE 3te  TRAININGSEINHEIT
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Laufband",
                                    "Crunches",
                            },
                            {
                                    "4",
                                    "3",
                                    "20 Minuten",
                                    "3",
                            }
                    },
                    // SCHULTER/ARME--- 4te  TRAININGSEINHEIT
                    {
                            {
                                    "Schulterdrücken",
                                    "Reverse Butterfly",
                                    "Trizepsdrücken am Kabelzug",
                                    "Stirndrücken (Kurzhantel)",
                                    "Bizeps Hammercurls"
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

    @Override
    public String[][][] erstellePlan_Fortgeschritten(int frequenz) {
        //2x pro Woche
        if ( frequenz == 2) {
            // GANZKÖRPER
            String[][][] plan = {
                    {   // --- 1te TRAININGSEINHEIT
                            {
                                    "Langhantel Bankdrücken",
                                    "Fliegende (Kurzhantel)",
                                    "Kurzhantel-Rudern",
                                    "Latzug zur Brust - enger Griff",
                                    "Schulterdrücken (Kurzhantel)",
                                    "Beinheben hängend",
                            },
                            {
                                    "4",
                                    "3",
                                    "4",
                                    "3",
                                    "3",
                                    "3"
                            }
                    },
                    {   // --- 2te TRAININGSEINHEIT
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Beinstrecker",
                                    "Wadenheben stehend/sitzend",
                                    "Crunches",
                            },
                            {
                                    "4",
                                    "3",
                                    "2",
                                    "3",
                                    "3",
                            }

                    }
            };
            return plan;

        } else if ( frequenz == 3 ) { //3x pro Woche
            // PUSH | PULL | BEINE
            String[][][] plan = {
                    // --- PUSH - 1te TRAININGSEINHEIT
                    {
                            {
                                    "Bankdrücken Langhantel",
                                    "Fliegende (Kurzhanteln)",
                                    "Dips",
                                    "Enges Bankdrücken",
                                    "Schulterdrücken",
                                    "Bauch - Beinheben hängend"
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                            }
                    },
                    // --- PULL - 2te  TRAININGSEINHEIT
                    {
                            {
                                    "Kreuzheben",
                                    "Kurzhantel-Rudern",
                                    "Latzug zur Brust - enger Griff",
                                    "Reverse Flys",
                                    "Hammercurls",
                                    "Crunches"
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "3"
                            }
                    },

                    // --- BEINE 3te  TRAININGSEINHEIT
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Beinstrecker",
                                    "Wadenheben stehend/sitzend",
                                    "Crunches"
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                            }
                    }
            };
            return plan;

        } else if ( frequenz >= 4 ) { //3x pro Woche
            // PUSH | PULL |  BEINE | SCHULTERN
            String[][][] plan = {
                    // PUSH --- 1te  TRAININGSEINHEIT
                    {
                            {
                                    "Bankdrücken Langhantel",
                                    "Schrägbankdrücken KH",
                                    "Fliegende (Kurzhantel)",
                                    "Dips",
                                    "Beinheben hängend",
                                    "Bauch - Situps auf der negativ Bank"
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
                    // PULL --- 2te  TRAININGSEINHEIT
                    {
                            {
                                    "Kreuzheben",
                                    "Ruderzugmaschine",
                                    "Latzug zur Brust - weiter Griff",
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
                                    "3"
                            }
                    },

                    // BEINE--- 3te  TRAININGSEINHEIT
                    {
                            {
                                    "Kniebeugen",
                                    "Beinpresse",
                                    "Beinstrecker",
                                    "Beinbeuger",
                                    "Wadenheben stehend/sitzend",
                                    "Crosstrainer - Laufen"
                            },
                            {
                                    "4",
                                    "3",
                                    "3",
                                    "3",
                                    "3",
                                    "20 Minuten"
                            }
                    },
                    // SCHULTER/ARME--- 4te  TRAININGSEINHEIT
                    {
                            {
                                    "Schulterdrücken",
                                    "Reverse Butterfly",
                                    "Trizepsdrücken am Kabelzug",
                                    "Stirndrücken (Kurzhantel)",
                                    "Bizeps Hammercurls"
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

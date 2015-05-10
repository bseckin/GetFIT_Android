package menu.androidhive.navdrawer;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.packone.login.database.Contact;
import com.packone.login.database.DatabaseHandler;
import com.packone.login.GlobalClass;
import com.packone.login.R;
import trainingsplan.Trainingsplan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

import at.markushi.ui.CircleButton;
import trainingsplan.strategy.AllgemeineFitness;
import trainingsplan.strategy.Ausdauer;
import trainingsplan.strategy.Gewichtsverlust;
import trainingsplan.strategy.MasseMuskelaufbau;
import trainingsplan.strategy.Rueckenstaerkung;


public class TraningsFragment extends Fragment {
    // Attribute
    TableLayout table_layout_plan1;
    TableLayout table_layout_plan2;
    private String[][][] meinPlan;
    private int anzahl;
    private String[][] planEinheit;

    private SharedPreferences mPrefs;
    private static int pe;
    private int KEY_AKTUELLER_PLAN;

    // METHODEN
    public TraningsFragment(){}
	
	@Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_training, container, false);
        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        // Get username from global/application context
        final String name = globalVariable.getName();

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            anzahl = savedInstanceState.getInt("aktuell_plan", 0);
            Log.d("SavedInstance:", ""+anzahl);
        }

        // Überschrift:
        getHeutigesDatum();
        TextView ueberschrift = (TextView)rootView.findViewById(R.id.label_zu_trainierende_muskel);
        ueberschrift.setText(getHeutigesDatum());
        ueberschrift.setTextSize(23);
        ueberschrift.setTypeface(null, Typeface.BOLD);
        ueberschrift.setTextColor(Color.WHITE);

        // Fragenkatalog von diesem User auslesen.
        readFragenkatalog(name);

        // Tabelle aufsetzen
        table_layout_plan1 = (TableLayout) rootView.findViewById(R.id.tp_tablelayout);
        table_layout_plan1.removeAllViews();

        /*
         [0][0] => Erste Stelle ist der Plan; Zweite ist, Uebung bzw. Satzzahl
         z.B.: => [0ter Plan][Uebungen], [0terPlan][Satzahl]
         */

        //planEinheit = new String[][]{ this.meinPlan[0][0], this.meinPlan[0][1] };
        planEinheit = new String[][]{ this.meinPlan[1][0], this.meinPlan[1][1] };
        final int arraySize = meinPlan.length;
        Log.d("TRAININGSEINHEITEN", "==>" + arraySize);
        Log.d("KOMPLETTER PLAN", "" + Arrays.deepToString(meinPlan));

        // Tabelle erstellen
        //BuildTable(planEinheit[0].length - 1, 2, planEinheit);
        BuildTable(planEinheit[0].length, 2, planEinheit);

        CircleButton circleButton = (CircleButton) rootView.findViewById(R.id.btn_tfragment_teinheit_fertig);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                View layout = inflater.inflate(R.layout.custom_toast_layout,
                        (ViewGroup) rootView.findViewById(R.id.toast_layout_root));
                // TOAST: GRATULATION TRAINING FÜR HEUTE BEENDET!
                Toast toast = new Toast(getActivity());
                toast.setGravity(Gravity.BOTTOM, 0, 110);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();


                // nächste Trainingseinheit, wenn "FERTIG" mit dieser Einheit:
                for (int i = anzahl; i < arraySize; i += 1) {
                    planEinheit = new String[][]{
                            meinPlan[i][0], // Uebungsname
                            meinPlan[i][1]  // Satzzahl dazu
                    };
                    // clear View
                    table_layout_plan1.removeAllViews();
                    //BuildTable(planEinheit[1].length - 1, 2, planEinheit);    // ... ZEILEN, SPALTEN, DATA
                    BuildTable(planEinheit[1].length, 2, planEinheit);          // ... ZEILEN, SPALTEN, DATA
                    // nächster Trainings Einheit / Trainings-Tag
                    anzahl += 1;

                    //Wenn alle Trainingseinheiten gemacht wurden => von neu beginnen
                    if (anzahl == arraySize) anzahl = 0;
                    break;
                }
            }


        });


        //zufalls tipp
        TextView textView_tipps = (TextView)rootView.findViewById(R.id.tipp_textView);
        textView_tipps.setText("" + erzeugeZufallsTipp());


        // LOGS
        Log.d("TrainingsFragment:", "Aktuell eingeloggter USER:" + name);
        Log.d("TF:Attribut:meinPlan:", Arrays.deepToString(this.meinPlan));
        Log.d("Array:", "rows" + this.meinPlan[0].length + "\n" + "cols:" + this.meinPlan[1].length);

        return rootView;
    }

    private String erzeugeZufallsTipp() {
        ArrayList<String>  tippsList = new ArrayList<String>();
        tippsList.add("Eine korrekte Ausführung, ist ausschlaggebend für Muskelaufbau!");
        tippsList.add("Die Phase bei dem man das Gewicht runterlässt, heißt auch Negative!");
        tippsList.add("Die Phase bei dem man das Gewicht wegdrückt, heißt auch Positive!");
        tippsList.add("Nicht auf die Atmung vergessen!");
        tippsList.add("Immer genügend Wasser trinken während des Trainings!");
        tippsList.add("Pause zwischen den Sätzen, sollten für Muskelaufbau maximal 90 Sekunden dauern!");
        tippsList.add("Beim Training werden Glückshormone im Gehirn ausgelöst :-)");
        tippsList.add("Nicht aufgeben, wenn etwas nicht klappt - Übung macht den Meister!");
        tippsList.add("Durch das Training mit Freihantel ist für eine gute Balance wichtig");
        tippsList.add("Wählen Sie ein Gewicht, bei dem die letzten 2 Wiederholungen Sie herausfordert!");
        tippsList.add("5-10 Minuten Aufwärmen ist Pflicht! - z.B.: wenig Gewicht mit sehr vielen Wiederholungen!");
        tippsList.add("Auch Bauchmuskeln muss man trainieren, aber die Ernährung ist hierbei wichtiger");

        Collections.shuffle(tippsList);
        return tippsList.get(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("aktuell_plan", anzahl);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("onPause", "called--------");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("onStop", "called--------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("OnDestroy", "called--------");
    }

    /**
     * Erstellt Tabelle
     * @param rows
     * @param cols
     */
    public void BuildTable(int rows, int cols, String[][] plan) {
        // outer for loop
        for (int i = 0; i < rows; i++) {
            TableRow row = new TableRow(getActivity());
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 0; j < cols; j++) {
                TextView tv = new TextView(getActivity());
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                tv.setPadding(5, 5, 5, 10);
                tv.setText(plan[j][i]);
                row.addView(tv);
            }
            table_layout_plan1.addView(row);
        }
    }

    /**
     * Holt aktuelles Datum
     * @return
     */
    private String getHeutigesDatum() {
        //Aktuellen Tag holen
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //Date time = calendar.getTime();
        switch (day) {
            case Calendar.SUNDAY:
                Log.d("Calender", "SONNTAG");
                return "Heute ist Sonntag, Ihr Plan:";
            case Calendar.MONDAY:
                Log.d("Calender", "Montag");
                return "Heute ist Montag, Ihr Plan:";
            case Calendar.TUESDAY:
                Log.d("Calender", "Dienstag");
                return "Heute ist Dienstag, Ihr Plan:";
            case Calendar.WEDNESDAY:
                Log.d("Calender", "Mittwoch");
                return "Heute ist Mittwoch, Ihr Plan:";
            case Calendar.THURSDAY:
                Log.d("Calender", "Donnerstag");
                return "Heute ist Donnerstag, Ihr Plan:";
            case Calendar.FRIDAY:
                Log.d("Calender", "Freitag");
                return "Heute ist Freitag, Ihr Plan:";
            case Calendar.SATURDAY:
                Log.d("Calender", "Samstag");
                return "Heute ist Samstag, Ihr Plan:";
        }
        return null;
    }

    /**
     * Reading DB from Table "CONTACT"
     * Fragenkatalog-Antworten vom aktuell eingeloggten User aus DB auslesen.
     *
     * [Status] Methode funktioniert; konsistente Daten.
     * @param uname
     */
    private void readFragenkatalog(String uname){
        String currentUser = uname;
        DatabaseHandler db = new DatabaseHandler(getActivity());
        Contact fk = db.getFragenkatalog(currentUser);  //fk == fragenkatalog

        Log.d("TrainingsFragment:", "==" + "\n" + "== Fragenkatalog Werte: =="+ "\n" +
                fk.getZiel() + "\n" +
                fk.getAkt() + "\n" +
                fk.getErfahrung() + "\n" +
                fk.getQuant() + "\n");

        String ziel = fk.getZiel();
        String akt = fk.getAkt();
        String erfahrung = fk.getErfahrung();
        String quant = fk.getQuant();

        holePassendenPlan(ziel, akt, erfahrung, quant);
    }

    /**
     * Nimmt die Antworten vom User aus dem Fragenkatalog,
     * und holt sich nun einen passenden Plan
     *
     * [Status] Methode funktioniert; konsistente Daten.
     *
     * @param ziel
     * @param akt
     * @param erfahrung
     * @param quant
     */
    private void holePassendenPlan(String ziel, String akt, String erfahrung, String quant) {
        Log.d("holePassendenPlan(..)", "Übergeben im Param:" +ziel+ " | " +akt+  " | " + " | " +erfahrung+ " | " +quant);
        final int frequenz = getFrequenz(quant);

        // Alle möglichen Ziele:
        String allgemeineFitness = getString(R.string.allgemein);
        String ausdauer = getString(R.string.kondition);
        String gewichtsverlust = getString(R.string.gewichtsverlust);
        String masseaufbau = getString(R.string.masseaufbau);
        String rueckenStaerkung = getString(R.string.ruecken);

        Trainingsplan tp = Trainingsplan.getTrainingsplan();

        // switch geht nicht wegen konstante oder so
            // ALLGEMEIN KOERPERLICHE FITNESS
        if(ziel.equals(allgemeineFitness)){
            tp.set_ziel(new AllgemeineFitness());
            tp.getPlan(frequenz, erfahrung);
            Log.d("TF:- AllgemeineFitness-", Arrays.deepToString(tp.getPlan(frequenz, erfahrung)));
        } // AUSDAUER
        else if (ziel.equals(ausdauer)) {
            tp.set_ziel(new Ausdauer());
            this.meinPlan = tp.getPlan(frequenz, erfahrung);
            Log.d("TF:- Ausdauer -",  Arrays.deepToString(tp.getPlan(frequenz, erfahrung)));
        } // GEWICHTSVERLUST
        else if (ziel.equals(gewichtsverlust)) {
            tp.set_ziel(new Gewichtsverlust());
            this.meinPlan = tp.getPlan(frequenz, erfahrung);
            Log.d("TF:- Gewichtsverlust -",  Arrays.deepToString(tp.getPlan(frequenz, erfahrung)));
        } // MASSEAUFBAU
        else if (ziel.equals(masseaufbau)) {
            tp.set_ziel(new MasseMuskelaufbau());
            this.meinPlan = tp.getPlan(frequenz, erfahrung);
            Log.d("TF:- MasseMuskelaufbau-",  Arrays.deepToString(tp.getPlan(frequenz, erfahrung)));
        } // RUECKEN STAERKUNG
        else if (ziel.equals(rueckenStaerkung)) {
            tp.set_ziel(new Rueckenstaerkung());
            this.meinPlan = tp.getPlan(frequenz, erfahrung);
            Log.d("TF:- Rueckenstaerkung -",  Arrays.deepToString(tp.getPlan(frequenz, erfahrung)));
        } else {
            // Kein Plan gefunden ERROR
            Log.d("holePassendenPlan():", "Kein Plan gefunden!");
        }
    }

    /**
     * Macht aus der ausgewählte Trainingsfrequenz ein integer Wert
     *
     * [STATUS] Funktioniert; Konsistente Daten.
     * @param quantity
     * @return frequenz
     */
    private int getFrequenz(String quantity) {
        // Aus dem String die Trainingshäufigkeit auslesen
        int frequenz = 0;
        if ( quantity.equals(getString(R.string.zwei_mal_training)) ) {
            return frequenz = 2;
        } else if ( quantity.equals(getString(R.string.drei_mal_training)) ) {
            return frequenz = 3;
        } else if ( quantity.equals(getString(R.string.vier_mal_training)) ) {
            return frequenz = 4;
        }
        return frequenz;
    }
}

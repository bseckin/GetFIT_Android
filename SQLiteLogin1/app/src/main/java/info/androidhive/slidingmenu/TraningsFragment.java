package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.packone.login.Contact;
import com.packone.login.DatabaseHandler;
import com.packone.login.GlobalClass;
import com.packone.login.R;
import com.packone.login.Trainingsplan;

import java.util.Arrays;
import java.util.Calendar;

import trainingsplan.AllgemeineFitness;
import trainingsplan.Ausdauer;
import trainingsplan.Gewichtsverlust;
import trainingsplan.MasseMuskelaufbau;
import trainingsplan.Rueckenstaerkung;


public class TraningsFragment extends Fragment {
    // Attribute
    TableLayout table_layout_plan1;
    TableLayout table_layout_plan2;
    private String[][][] meinPlan;
    private int anzahl;
    private String[][] planEinheit;

	public TraningsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);
        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        // Get username from global/application context
        final String name = globalVariable.getName();

        // Überschrift:
        getHeutigesDatum();
        TextView ueberschrift = (TextView)rootView.findViewById(R.id.label_zu_trainierende_muskel);
        ueberschrift.setText(getHeutigesDatum());
        ueberschrift.setTextSize(23);
        ueberschrift.setTypeface(null, Typeface.BOLD);
        ueberschrift.setTextColor(Color.WHITE);

        // Fragenkatalog von diesem User auslesen.
        readFragenkatalog(name);

        //Tabelle
        table_layout_plan1 = (TableLayout) rootView.findViewById(R.id.tp_tablelayout);
        table_layout_plan1.removeAllViews();

        planEinheit = new String[][]{this.meinPlan[0][0],this.meinPlan[0][1]};
        BuildTable(planEinheit[0].length-1, 2, planEinheit);

        Button button = (Button) rootView.findViewById(R.id.btn_tfragment_teinheit_fertig);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // nächste Trainingseinheit, wenn "FERTIG" mit dieser Einheit:
                switch (anzahl) {
                    case 0:
                        planEinheit = new String[][]{meinPlan[1][0],meinPlan[1][1]};
                        table_layout_plan1.removeAllViews();
                        BuildTable(planEinheit[0].length-1, 2, planEinheit);
                        break;
                    case 1:
                        planEinheit = new String[][]{meinPlan[2][0],meinPlan[2][1]};
                        table_layout_plan1.removeAllViews();
                        BuildTable(planEinheit[0].length-1, 2, planEinheit);
                        break;
                    default:
                        //Von neu beginnen:
                        anzahl = -1; //weils unten erhöht wird und case nicht bei 0 beginnt sondern bei 1 !
                        table_layout_plan1.removeAllViews();
                        planEinheit = new String[][]{meinPlan[0][0], meinPlan[0][1]};
                        BuildTable(planEinheit[0].length-1, 2, planEinheit);
                        break;
                }
                anzahl++;

            }
        });

        // LOGS
        Log.d("TrainingsFragment:", "Aktuell eingeloggter USER:" + name);
        Log.d("TrainingsFragment:Attribut:meinPlan:", Arrays.deepToString(this.meinPlan));
        Log.d("Array:", "rows" + this.meinPlan[0].length + "\n" + "cols:" + this.meinPlan[1].length);

        return rootView;
    }

    private void holeNaechsteTrainingsEinheit() {

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
        int frequenz = getFrequenz(quant);

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
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- AllgemeineFitness -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // AUSDAUER
        else if (ziel.equals(ausdauer)) {
            tp.set_ziel(new Ausdauer());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- Ausdauer -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // GEWICHTSVERLUST
        else if (ziel.equals(gewichtsverlust)) {
            tp.set_ziel(new Gewichtsverlust());
            this.meinPlan = tp.getPlan(frequenz);

            Log.d("TrainingsFragment:- Gewichtsverlust -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // MASSEAUFBAU
        else if (ziel.equals(masseaufbau)) {
            tp.set_ziel(new MasseMuskelaufbau());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- MasseMuskelaufbau -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // RUECKEN STAERKUNG
        else if (ziel.equals(rueckenStaerkung)) {
            tp.set_ziel(new Rueckenstaerkung());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- Rueckenstaerkung -", Arrays.deepToString(tp.getPlan(frequenz)));
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

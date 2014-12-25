package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    TableLayout table_layout;
    private String[][] meinPlan;

	public TraningsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);
        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        // Get username from global/application context
        final String name = globalVariable.getName();
        Log.d("TrainingsFragment:", "Aktuell eingeloggter USER:" + name);

        readFragenkatalog(name);    // Fragenkatalog von diesem User auslesen.


        // Überschrift:
        getHeutigesDatum();
        TextView ueberschrift = (TextView)rootView.findViewById(R.id.label_zu_trainierende_muskel);
        ueberschrift.setText(getHeutigesDatum());
        ueberschrift.setTextSize(23);
        ueberschrift.setTypeface(null, Typeface.BOLD);
        ueberschrift.setTextColor(Color.WHITE);

        //Tabelle
        table_layout = (TableLayout) rootView.findViewById(R.id.tp_tablelayout);
        table_layout.removeAllViews();

        Log.d("TrainingsFragment:Attribut:meinPlan:", Arrays.deepToString(this.meinPlan));

        /**
        String[][] plan = {
                {"Bankdrücken", "Flys", "Dips"},
                {"3", "3", "2"}
        };
        */
        BuildTable(this.meinPlan[0].length-1, this.meinPlan[1].length-1, this.meinPlan);
        return rootView;
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
     *
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

                tv.setPadding(5, 5, 5, 5);
                tv.setText(plan[j][i]);
                row.addView(tv);
            }
            table_layout.addView(row);
        }
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
        String z = ziel;
        String a = akt;
        String e = erfahrung;
        String q = quant; // Trainingshäufigkeit/Frequenz
        int frequenz = getFrequenz(q);

        // Alle möglichen Ziele:
        String allgemeineFitness = getString(R.string.allgemein);
        String ausdauer = getString(R.string.kondition);
        String gewichtsverlust = getString(R.string.gewichtsverlust);
        String masseaufbau = getString(R.string.masseaufbau);
        String rueckenStaerkung = getString(R.string.ruecken);

        Trainingsplan tp = Trainingsplan.getTrainingsplan();

        // switch geht nicht wegen konstante oder so
            // ALLGEMEIN KOERPERLICHE FITNESS
        if(z.equals(allgemeineFitness)){
            tp.set_ziel(new AllgemeineFitness());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- AllgemeineFitness -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // AUSDAUER
        else if (z.equals(ausdauer)) {
            tp.set_ziel(new Ausdauer());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- Ausdauer -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // GEWICHTSVERLUST
        else if (z.equals(gewichtsverlust)) {
            tp.set_ziel(new Gewichtsverlust());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- Gewichtsverlust -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // MASSEAUFBAU
        else if (z.equals(masseaufbau)) {
            tp.set_ziel(new MasseMuskelaufbau());
            this.meinPlan = tp.getPlan(frequenz);
            Log.d("TrainingsFragment:- MasseMuskelaufbau -", Arrays.deepToString(tp.getPlan(frequenz)));
        } // RUECKEN STAERKUNG
        else if (z.equals(rueckenStaerkung)) {
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

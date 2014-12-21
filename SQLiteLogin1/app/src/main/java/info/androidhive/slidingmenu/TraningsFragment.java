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

import com.packone.login.R;

import java.util.Arrays;
import java.util.Calendar;


public class TraningsFragment extends Fragment {
    // Attribute
    TableLayout table_layout;

	public TraningsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);
        trainingsTagTitel();
        TextView ueberschrift = (TextView)rootView.findViewById(R.id.label_zu_trainierende_muskel);

        Bundle arguments = getArguments();
        if(arguments != null)
        {
            String[][] passed_list = (String[][]) arguments.getSerializable("TP_ARRAY");
            Log.d("LISTE##############", Arrays.deepToString(passed_list));
        } else {
            Log.d("FAIL", "GAFASD");
        }


        // " TRAININGSZIEL "
        //RegistrierungFragenkatalogActivity activity = (RegistrierungFragenkatalogActivity) getActivity();
        //String[][] s =((RegistrierungFragenkatalogActivity)getActivity()).getPlan();
        //String[][] s = Trainingsplan.getTrainingsplan().getPlan();

        //Aktuellen Tag als Überschrift setzen
        ueberschrift.setText(trainingsTagTitel());
        ueberschrift.setTextSize(23);
        ueberschrift.setTypeface(null, Typeface.BOLD);
        ueberschrift.setTextColor(Color.WHITE);

        //Tabelle
        table_layout = (TableLayout) rootView.findViewById(R.id.tp_tablelayout);
        table_layout.removeAllViews();

        //String[][] plan = tp.getPlan();
        //BuildTable(2, 3, tp.getPlan());
        String[][] plan = {
                {"Bankdrücken", "Flys", "Dips"},
                {"3", "3", "2"}
        };

        BuildTable(plan[0].length-1, plan[1].length-1, plan);
        return rootView;
    }


    private String trainingsTagTitel() {
        //Aktuellen Tag holen
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //Date time = calendar.getTime();
        switch (day) {
            case Calendar.SUNDAY:
                return "Heute ist Sonntag, Ihr Plan:";
            case Calendar.MONDAY:
                return "Heute ist Montag, Ihr Plan:";
            case Calendar.TUESDAY:
                return "Heute ist Dienstag, Ihr Plan:";
            case Calendar.WEDNESDAY:
                return "Heute ist Sonntag, Ihr Plan:";
            case Calendar.THURSDAY:
                return "Heute ist Sonntag, Ihr Plan:";
            case Calendar.FRIDAY:
                // etc ...
            case Calendar.SATURDAY:
                // etc ...
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
}

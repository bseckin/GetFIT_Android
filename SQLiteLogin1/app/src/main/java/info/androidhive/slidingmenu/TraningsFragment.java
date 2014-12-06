package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.packone.login.R;


public class TraningsFragment extends Fragment {
    // Attribute
    TableLayout table_layout;

	public TraningsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);

        table_layout = (TableLayout) rootView.findViewById(R.id.tp_tablelayout);
        table_layout.removeAllViews();
        BuildTable(4, 3);
        return rootView;
    }



    public void BuildTable(int rows, int cols) {
        // outer for loop
        for (int i = 1; i <= rows; i++) {

            TableRow row = new TableRow(getActivity().getApplicationContext());
            row.setLayoutParams(new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 1; j <= cols; j++) {
                TextView tv = new TextView(getActivity().getApplicationContext());
                tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                tv.setBackgroundResource(R.drawable.table_cell_shape);
                tv.setPadding(5, 5, 5, 5);
                tv.setTextColor(Color.BLACK);
                /* ------------------------------
                 * | SATZZAHL | ÜBUNG  | WDH    |
                 * ------------------------------ */
                if(i == 1) {
                    if(j == 1) {
                        tv.setTypeface(null, Typeface.BOLD); //FETT machen Überschrft
                        tv.setText("Satzzahl");
                    } else {
                        //tv.setText("R " + i + ", C" + j);
                        if(j == 2) {
                            tv.setTypeface(null, Typeface.BOLD);
                            tv.setText("Übung");
                        } else {
                            //tv.setText("R " + i + ", C" + j);
                            if(j == 3) {
                                tv.setTypeface(null, Typeface.BOLD);
                                tv.setText("Wdh.");
                            }
                        }
                    }
                } else {
                    tv.setText("R " + i + ", C" + j);
                }

                row.addView(tv);
            }

            table_layout.addView(row);

        }
    }
}

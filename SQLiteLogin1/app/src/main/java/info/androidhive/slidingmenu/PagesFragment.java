package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.packone.login.DatabaseHandler;
import com.packone.login.ErnaehrungActivity;
import com.packone.login.R;

import Nutrition.NutritionIntake;
import ernaehrung.AErnaehrung;
import ernaehrung.Ectomorph;
import ernaehrung.Ernaehrungsplan;
import ernaehrung.MasseEcto;

public class PagesFragment extends Fragment {
    private NutritionIntake ni;
    private float carbs;
    private float fat;
    private float protein;
    private float kcal;
    private String goal;
    private String typ;
    private Button mButton;
    private String marks[][];
    private TableLayout table_layout;
    private TableLayout table_layout_food;
    private Ernaehrungsplan ectoplan;
    private AErnaehrung EctoErnaehrung;
    private MasseEcto me;
    private String [][][] a;
    private String[][] food;
    private int anzahl;
    private int cols;
    private int rows;
    public PagesFragment(){}

    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.fragment_pages, container, false);


        //Konstruktor
        this.ni = new NutritionIntake(10, 10, 10);
        this.carbs = ni.getCarbs();
        this.fat = ni.getFett();
        this.protein = ni.getProtein();
        this.kcal = ni.getGu();

        // Formel für
        this.goal = "Masse";
        this.typ = "Ectomorph";
        this.ni = new NutritionIntake(90, 180, 18);
        this.ni.CalculaeFat();

        this.ectoplan = new Ectomorph();






        //TODO ??? Das Ziel muss aus der Datenbank kommen
        if (this.typ == "Ectomorph") {
            if (goal.equals("Masse")) {
                this.carbs = ni.getCarbs()+100;
                this.fat = ni.getFett()+20;
                this.protein = ni.getProtein()+10;
                this.kcal = ni.getGu()+200;
                EctoErnaehrung = ectoplan.holePlan("MasseEcto");
                a = EctoErnaehrung.starten();//"Pages startet"

            } else if (goal.equals("Defi")) {
                EctoErnaehrung = ectoplan.holePlan("DefiEcto");
                EctoErnaehrung.starten();//"Pages startet"
            } else {
            }
        }

        marks = new String[][]{{"Carbs", "Fat", "Proteine", "Kcal"}, {
                Float.toString(this.carbs),
                Float.toString(this.fat),
                Float.toString(this.protein),
                Float.toString(this.kcal)}};
        table_layout = (TableLayout) rootView.findViewById(R.id.tableLayout1);

        this.cols = marks.length-1;
        this.rows = marks[1].length-1;
        table_layout.removeAllViews();
        BuildTableNutrition(rows, cols,"1", marks);

        table_layout_food = (TableLayout) rootView.findViewById(R.id.tableLayout2);

        String[][] morgens = new String[][]{a[0][0],a[0][1]};


        cols =morgens.length-1;
        rows = morgens[1].length-1;
        table_layout_food.removeAllViews();
        BuildTableNutrition(rows, cols, "2", morgens);


        mButton = (Button) rootView.findViewById(R.id.bgeschafft);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (anzahl) {
                    case 0:
                        food = new String[][]{a[anzahl+1][0],a[anzahl+1][1]};
                        table_layout_food.removeAllViews();
                        cols =food.length-1;
                        rows = food[1].length-1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 1:
                        food = new String[][]{a[anzahl+1][0],a[anzahl+1][1]};
                        table_layout_food.removeAllViews();
                        cols =food.length-1;
                        rows = food[1].length-1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 2:
                        food = new String[][]{a[anzahl+1][0],a[anzahl+1][1]};
                        table_layout_food.removeAllViews();
                        cols =food.length-1;
                        rows = food[1].length-1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 3:
                        food = new String[][]{a[anzahl+1][0],a[anzahl+1][1]};
                        table_layout_food.removeAllViews();
                        cols =food.length-1;
                        rows = food[1].length-1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 4:
                        table_layout_food.removeAllViews();
                        RelativeLayout linearLayout = (RelativeLayout) rootView.findViewById(R.id.rlt);

                        TextView valueTV = new TextView(getActivity());
                        valueTV.setText("Glüchwunsch Sie sinf für heute fertig");
                        valueTV.setLayoutParams(new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.FILL_PARENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT));
                        linearLayout.addView(valueTV);
                    default:
                        break;

                 }
                anzahl++;
            }

        });

        mButton = (Button) rootView.findViewById(R.id.bnutrition);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ErnaehrungActivity.class);
                startActivity(intent);
            }

        });


        return rootView;
    }


    /**
     *
     * @param rows
     * @param cols
     */
    private void BuildTableNutrition(int rows, int cols, String vtable, String[][] a) {

        // outer for loop
        for (int i = 0; i <= rows; i++) {

            TableRow row = new TableRow(getActivity());
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 0; j <= cols; j++) {

                TextView tv = new TextView(getActivity());
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(a[j][i]);

                row.addView(tv);

            }
            if (vtable == "1") {
                table_layout.addView(row);
            } if (vtable == "2"){
                table_layout_food.addView(row);
            }
        }
    }

    private void drawScedule(int tanz, String[][][] array){
        for (int i = 0; i <= tanz; i++){

        }
    }

    public void getGoal(View view) {
        final DatabaseHandler db;

    }
}

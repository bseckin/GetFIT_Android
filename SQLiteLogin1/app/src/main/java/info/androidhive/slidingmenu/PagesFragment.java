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

import com.packone.login.Contact;
import com.packone.login.DatabaseHandler;
import com.packone.login.ErnaehrungActivity;
import com.packone.login.GlobalClass;
import com.packone.login.R;

import java.util.List;

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
    private String[][][] lebensmittel;
    private String[][] food;

    private int anzahl;
    private int cols;
    private int rows;

    //Database data
    private int weight;
    private int height;
    private String gender;

    public PagesFragment() {
    }

    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.fragment_pages, container, false);

        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        // Get name and email from global/application context
        final String name = globalVariable.getName();

        DatabaseHandler db = new DatabaseHandler(getActivity());
        List<Contact> a = db.getContact(name);

        for (Contact cn : a) {
            this.goal = cn.getZiel();
            this.weight = cn.getWeight();
            this.height = cn.getHeight();
            this.gender = cn.getGender();
        }
        //Konstruktor
        this.typ = "Ectomorph";
        this.ni = new NutritionIntake(this.weight, this.height, 18, "mittel");
        this.carbs = ni.getCarbs();
        this.fat = ni.getFett();
        this.protein = ni.getProtein();
        this.kcal = ni.getGu();

        // Formel für

        this.ni.CalculaeNutritions("Maennlich");
        this.ectoplan = new Ectomorph();


        //TODO ??? Das Ziel muss aus der Datenbank kommen
        if (this.typ == "Ectomorph") {
            if (goal.equals("Masse und Muskelaufbau – für Schlanke Menschen")) {
                this.carbs = ni.getCarbs() + 100;
                this.fat = ni.getFett() + 20;
                this.protein = ni.getProtein() + 10;
                this.kcal = ni.getGu() + 200;
                EctoErnaehrung = ectoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"

            } else if (goal.equals("Gewichtsverlust")) {
                EctoErnaehrung = ectoplan.holePlan(this.goal);
                EctoErnaehrung.starten();//"Pages startet"
            } else {
            }
        }

        // Anzeige der Nährwerte


        // wir erzeugen ein zwei dimensionales array für die Nutrition tabelle
        //auf der rechten seite befinden sich die werte und auf der linken seite die
        //jeweilige bezeichnung
        marks = new String[][]{{"Carbs", "Fat", "Proteine", "Kcal"}, {
                Float.toString(this.carbs),
                Float.toString(this.fat),
                Float.toString(this.protein),
                Float.toString(this.kcal)}};
        table_layout = (TableLayout) rootView.findViewById(R.id.tableLayout1);

        //Wir bereiten die variablen nun für eine asugabe vor indem wir die größe
        //der tabelle festlegen. Diese "größe" besteht aus der spalten und der zeilen
        //anzahl des arrays
        this.cols = marks.length - 1;
        this.rows = marks[1].length - 1;
        //entfernen alle zuvor generierten tabellen inhalte im View
        //entfernen nicht die ganze tabelle da wir die grundstruktur brauchen um
        //die tabelle zeichenn zu könenn
        table_layout.removeAllViews();
        //Die Methode BuildTable wird aufgerufen
        BuildTableNutrition(rows, cols, "1", marks);

        //Anzeige der Malzeiten

        table_layout_food = (TableLayout) rootView.findViewById(R.id.tableLayout2);

        //Am anfang werden wir nur das Frühstück anzeigen später wird dieser Wert
        String[][] morgens = new String[][]{lebensmittel[0][0], lebensmittel[0][1]};


        cols = morgens.length - 1;
        rows = morgens[1].length - 1;
        table_layout_food.removeAllViews();
        BuildTableNutrition(rows, cols, "2", morgens);

        //Wenn der Benutzer den Butten mit de Aufschrifft "egschafft" betätigt
        //so wird die nächste malzeit angezeigt
        mButton = (Button) rootView.findViewById(R.id.bgeschafft);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hier zächlen wir sozusagen anch wie oft der benutzer den Button geschafft drückt
                //und ändern den Tabellen inhalt jedesmal um, indem wir zur nächsten stelle des
                //arrays springen
                switch (anzahl) {
                    case 0:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 1:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 2:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 3:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 4:
                        table_layout_food.removeAllViews();
                        RelativeLayout linearLayout = (RelativeLayout) rootView.findViewById(R.id.rlt);

                        //Sind alle Malzeiten gegessen so wird nur ein Text ausgegben
                        TextView valueTV = new TextView(getActivity());
                        valueTV.setText("Glüchwunsch Sie sinf für heute fertig");
                        valueTV.setLayoutParams(new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.FILL_PARENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT));
                        linearLayout.addView(valueTV);
                    default:
                        break;

                }
                //Die anzahl wird nach jedem klick um 1 erhöht
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
            }
            if (vtable == "2") {
                table_layout_food.addView(row);
            }
        }
    }
}

package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.packone.login.Contact;
import com.packone.login.DatabaseHandler;
import com.packone.login.ErnaehrungActivity;
import com.packone.login.Food;
import com.packone.login.GlobalClass;
import com.packone.login.R;

import java.util.ArrayList;
import java.util.List;

import Nutrition.NutritionIntake;
import ernaehrung.AErnaehrung;
import ernaehrung.Ectomorph;
import ernaehrung.Endomorph;
import ernaehrung.Ernaehrungsplan;
import ernaehrung.Mesomorph;

public class ErnaehrungsFragment extends Fragment {
    private NutritionIntake ni;

    private int carbs;
    private int fat;
    private int protein;
    private int kcal;

    private TextView fatview;
    private TextView protview;
    private TextView carbview;
    private TextView calview;

    private ProgressBar pfat;
    private ProgressBar pprot;
    private ProgressBar pcarb;
    private ProgressBar pcal;

    private int _weight;
    private int _height;
    private int _kcal;
    private float BMI;

    private String goal;
    private String typ;
    private Button mButton;
    private String marks[][];
    private TableLayout table_layout;
    private TableLayout table_layout_food;
    private Ernaehrungsplan ectoplan;
    private Ernaehrungsplan endoplan;
    private Ernaehrungsplan mesoplan;
    private AErnaehrung EctoErnaehrung;
    private String[][][] lebensmittel;
    private String[][] food;

    private int anzahl;
    private int cols;
    private int rows;

    //Database data
    private int weight;
    private int height;
    private String gender;

    public ErnaehrungsFragment() {
    }

    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.fragment_ernaehrung, container, false);

        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        // Get name and email from global/application context
        final String name = globalVariable.getName();

        DatabaseHandler db = new DatabaseHandler(getActivity());
        List<Contact> a = db.getContactMuhi(name);

        for (Contact cn : a) {
            this.goal = cn.getZiel();
            this.weight = cn.getWeight();
            this.height = cn.getHeight();
            this.gender = cn.getGender();
            this.typ = cn.get_ktyp();
        }
        //Konstruktor
        this.ni = new NutritionIntake(this.weight, this.height, 18, "mittel");
        this.carbs = Math.round(ni.getCarbs());
        this.fat = Math.round(ni.getFett());
        this.protein = Math.round(ni.getProtein());
        this.kcal = Math.round(ni.getGu());

        // Formel für

        this.ni.CalculaeNutritions("Maennlich");
        this.ectoplan = new Ectomorph();
        this.endoplan = new Endomorph();
        this.mesoplan = new Mesomorph();


        //TODO ??? Das Ziel muss aus der Datenbank kommen
            if (this.typ.equals("Ectomorph")) {
            Log.d("$$$$$$$$$$$$", goal);
            if (goal.equals("Masse und Muskelaufbau – für Schlanke Menschen")) {
                this.carbs =  Math.round(ni.getCarbs())+100;
                this.fat =  Math.round(ni.getFett())+20;
                this.protein = Math.round(ni.getProtein())+ 10;
                this.kcal = Math.round(ni.getGu())+200;
                EctoErnaehrung = ectoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"

            } else if (goal.equals("Gewichtsverlust")) {
                this.carbs -= 100;
                this.fat -=  20;
                this.protein -= 10;
                this.kcal -= 200;
                EctoErnaehrung = ectoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"
            }
        } else if (this.typ.equals("Endomorph")) {
            if (goal.equals("Masse und Muskelaufbau – für Schlanke Menschen")) {
                this.carbs += 100;
                this.fat += 20;
                this.protein += 10;
                this.kcal += 200;
                EctoErnaehrung = endoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"

            } else if (goal.equals("Gewichtsverlust")) {
                this.carbs -= 100;
                this.fat -= 20;
                this.protein -= 10;
                this.kcal -= 200;
                EctoErnaehrung = endoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"
            }
        } else if (this.typ.equals("Mesomorph")) {
            if (goal.equals("Masse und Muskelaufbau – für Schlanke Menschen")) {
                this.carbs += 100;
                this.fat += 20;
                this.protein += 10;
                this.kcal += 200;
                EctoErnaehrung = mesoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"

            } else if (goal.equals("Gewichtsverlust")) {
                this.carbs -= 100;
                this.fat -= 20;
                this.protein -= 10;
                this.kcal -=  200;
                EctoErnaehrung = mesoplan.holePlan(this.goal);

                //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
                //So haben wir ein dreidimensionales array
                //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
                //2.Stelle -> Nahrungsbezeichnung
                //3.Stelle -> Menge in gramm
                lebensmittel = EctoErnaehrung.starten();//"Pages startet"
            }
        }

        // Anzeige der Nährwerte


        // wir erzeugen ein zwei dimensionales array für die Nutrition tabelle
        //auf der rechten seite befinden sich die werte und auf der linken seite die
        //jeweilige bezeichnung
        marks = new String[][]{{"Carbs", "Fat", "Proteine", "Kcal"}, {
                Float.toString(Math.round(this.carbs)),
                Float.toString(Math.round(this.fat)),
                Float.toString(Math.round(this.protein)),
                Float.toString(Math.round(this.kcal))}};

        //die progressbars werden beschriftet
        this.fatview = (TextView) rootView.findViewById(R.id.fat_anz);
        fatview.setText("0/" + Float.toString(this.fat));

        this.protview = (TextView) rootView.findViewById(R.id.prot_anz);
        protview.setText("0/" + Float.toString(this.protein));

        this.carbview = (TextView) rootView.findViewById(R.id.carb_anz);
        carbview.setText("0/"+Float.toString(this.carbs));

        this.calview = (TextView) rootView.findViewById(R.id.cal_anz);
        calview.setText("0/"+Float.toString(this.kcal));

        //Progressbar wird resettet
        this.pfat = (ProgressBar) rootView.findViewById(R.id.fat_prog);
        pfat.setProgress(1);

        this.pprot = (ProgressBar) rootView.findViewById(R.id.prot_prog);
        pprot.setProgress(1);

        this.pcarb = (ProgressBar) rootView.findViewById(R.id.carb_prog);
        pcarb.setProgress(1);

        this.pcal = (ProgressBar) rootView.findViewById(R.id.cal_prog);
        pcal.setProgress(1);

        //TODO Tablelayout weg und alles mit progressbars weils schöner aussieht
   /**     table_layout = (TableLayout) rootView.findViewById(R.id.tableLayout1);

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
*/
        //Anzeige der Malzeiten

        table_layout_food = (TableLayout) rootView.findViewById(R.id.tableLayout2);

        //Am anfang werden wir nur das Frühstück anzeigen später wird dieser Wert
        String[][] xy = new String[][]{lebensmittel[0][0], lebensmittel[0][1]};
        // String[][] morgens = optimizeAmount(xy,db);
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
                        valueTV.setText("Glüchwunsch Sie sind für heute fertig");
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

    /**
     * public float calculateBMI() {
     * this.BMI = (this._weight) / (this._height) ^ 2;
     * return this.BMI;
     * }
     */

    private int calculateKcal(int menge, int kcal_menge) {

        int erg = kcal_menge / menge;
        return erg;
    }

    private int calculateSumKcal(List<Integer> a) {
        int result = 0;

        for (int i = 0; i <= a.size(); i++) {
            result += a.get(i);
        }
        return result;
    }

    public String[][] optimizeAmount(String[][] a, DatabaseHandler db) {
        //diese funktion geht die liste mit den mengen und bezeichnungen der
        //Lebensmittel durch und reduziert die menge jenachdem wieviel der nenutzer an
        //kcal pro tag benötigt
        int kcal_db = 0;
        int zaehler = 0;
        String[][] food_amount_list = a;
        List<Integer> durchschnitt = new ArrayList<Integer>();

        // Hier holen wir die kcal aus der datenbank und speichern diese in eine ArrayListe
        // indem wir die kcalorien mit der menge multiplizieren um den exacten kalorienwert zu ermitteln
        // z.B. 50g * 1.3 -> schokolade
        while (this.kcal <= calculateSumKcal(durchschnitt)) {

            if (zaehler == 0) {
                for (int i = 0; i <= food_amount_list[0].length; i++) {

                    List<Food> x = db.getFood(food_amount_list[0][i]);
                    for (Food fd : x) {
                        kcal_db = fd.get_kcal();
                    }
                    durchschnitt.add(calculateKcal(kcal_db, Integer.parseInt(a[1][i])) * Integer.parseInt(food_amount_list[2][i]));
                }

                int max = durchschnitt.get(0);

                for (int i = 1; i < durchschnitt.size(); i++) {
                    if (durchschnitt.get(i) > max) {
                        max = durchschnitt.get(i);
                    }
                }
                int index = durchschnitt.indexOf(max);
                durchschnitt.set(max, Integer.parseInt(food_amount_list[2][index]) / 2);
                food_amount_list[2][index] = String.valueOf((Integer.parseInt(food_amount_list[2][index]) / 2));

                zaehler++;
            } else {
                int max = durchschnitt.get(0);

                for (int i = 1; i < durchschnitt.size(); i++) {
                    if (durchschnitt.get(i) > max) {
                        max = durchschnitt.get(i);
                    }
                }
                int index = durchschnitt.indexOf(max);
                durchschnitt.set(max,Integer.parseInt(food_amount_list[2][index]) / 2);
                food_amount_list[2][index] = String.valueOf((Integer.parseInt(food_amount_list[2][index]) / 2));

                zaehler++;
            }

            if (this.kcal >= calculateSumKcal(durchschnitt)) {
                break;
            }
        }
        return food_amount_list;
    }
}
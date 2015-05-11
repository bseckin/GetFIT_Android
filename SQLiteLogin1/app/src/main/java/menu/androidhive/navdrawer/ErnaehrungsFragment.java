package menu.androidhive.navdrawer;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.packone.login.GlobalClass;
import com.packone.login.R;
import com.packone.login.XMLParser;
import com.packone.login.database.Contact;
import com.packone.login.database.DatabaseHandler;
import com.packone.login.database.Food;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Nutrition.NutritionIntake;
import ernaehrung.factory.AErnaehrung;
import ernaehrung.factory.Ectomorph;
import ernaehrung.factory.Endomorph;
import ernaehrung.factory.Ernaehrungsplan;
import ernaehrung.factory.Mesomorph;

public class ErnaehrungsFragment extends ListFragment {

    private NutritionIntake ni;

    private int carbs;
    private int fat;
    private int protein;
    private int kcal;

    private int protref;
    private int fatref;
    private int carbref;
    private int kcalref;

    private float prottotal;
    private float fattotal;
    private float carbtotal;
    private float kcaltotal;

    private String[][] morgens;
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

    //XML PARSER
    // All static variables
    String URL = "http://fddb.info/api/v12/search/item_short.xml?lang=de";
    // XML node keys
    String SEARCHED_ITEM;
    String KEY_SHORTITEM = "shortitem";
    String KEY_NAME = "name";
    String KEY_KJ = "kj";
    String KEY_KCAL = "kcal";
    String KEY_FAT = "fat_gram";
    String KEY_PROT = "protein_gram";
    String KEY_KH = "kh_gram";
    String KEY_SUGAR = "sugar_gram";
    String API_KEY = "&apikey=5U92BAMH4Z3QK6TXVBU3EQ0N";
    String KEY_AMOUNT = "amount";
    EditText inputSearch;

    public ErnaehrungsFragment() {
    }

    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ernaehrung, container, false);


        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        // Get name and email from global/application context
        final String name = globalVariable.getName();

        //Daten werden aus der datenbank geholt
        DatabaseHandler db = new DatabaseHandler(getActivity());
        List<Contact> a = db.getContactMuhi(name);

        for (Contact cn : a) {
            this.goal = cn.getZiel();
            this.weight = cn.getWeight();
            this.height = cn.getHeight();
            this.gender = cn.getGender();
            this.typ = cn.get_ktyp();
        }

        /**
         this.fatpercview = (TextView) rootView.findViewById(R.id.fat_perc);
         this.protpercview = (TextView) rootView.findViewById(R.id.prot_perc);
         this.kcalpercview = (TextView) rootView.findViewById(R.id.cal_perc);
         this.carbpercview = (TextView) rootView.findViewById(R.id.carb_perc);
         */

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
        if (this.typ.equals("Ectomorph  -  Der Schlanke")) {

            this.carbs = Math.round(ni.getCarbs()) +10;
            this.fat = Math.round(ni.getFett()) ;
            this.protein = Math.round(ni.getProtein()) +5;
            this.kcal = Math.round(ni.getGu()) + 100;
            EctoErnaehrung = ectoplan.holePlan(this.goal);

            //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
            //So haben wir ein dreidimensionales array
            //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
            //2.Stelle -> Nahrungsbezeichnung
            //3.Stelle -> Menge in gramm
            lebensmittel = EctoErnaehrung.starten();//"Pages startet"


        } else if (this.typ.equals("Endomorph - Der molligere")) {

            this.carbs = Math.round(ni.getCarbs())+25;
            this.fat = Math.round(ni.getFett())+5;
            this.protein = Math.round(ni.getProtein())+20;
            this.kcal = Math.round(ni.getGu())+200;
            EctoErnaehrung = ectoplan.holePlan(this.goal);

            //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
            //So haben wir ein dreidimensionales array
            //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
            //2.Stelle -> Nahrungsbezeichnung
            //3.Stelle -> Menge in gramm
            lebensmittel = EctoErnaehrung.starten();//"Pages startet"


        } else if (this.typ.equals("Mesomorph  -  Der durchschnittliche")) {

            this.carbs = Math.round(ni.getCarbs()) ;
            this.fat = Math.round(ni.getFett()) ;
            this.protein = Math.round(ni.getProtein()) ;
            this.kcal = Math.round(ni.getGu()) ;
            EctoErnaehrung = ectoplan.holePlan(this.goal);

            //Unser Array leebnsmittel wird mit den werten die wir vom ernährungs package kriegen befüllt
            //So haben wir ein dreidimensionales array
            //1.Stelle -> die Malzeiten frühstück, mittag, abend, ....
            //2.Stelle -> Nahrungsbezeichnung
            //3.Stelle -> Menge in gramm
            lebensmittel = EctoErnaehrung.starten();//"Pages startet"


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
        this.fatview.setText("0/" + Float.toString(this.fat));

        this.protview = (TextView) rootView.findViewById(R.id.prot_anz);
        this.protview.setText("0/" + Float.toString(this.protein));

        this.carbview = (TextView) rootView.findViewById(R.id.carb_anz);
        this.carbview.setText("0/" + Float.toString(this.carbs));

        this.calview = (TextView) rootView.findViewById(R.id.cal_anz);
        this.calview.setText("0/" + Float.toString(this.kcal));

        //Progressbar wird resettet
        this.pfat = (ProgressBar) rootView.findViewById(R.id.fat_prog);
        this.pfat.setProgress(0);

        this.pprot = (ProgressBar) rootView.findViewById(R.id.prot_prog);
        this.pprot.setProgress(0);

        this.pcarb = (ProgressBar) rootView.findViewById(R.id.carb_prog);
        this.pcarb.setProgress(0);

        this.pcal = (ProgressBar) rootView.findViewById(R.id.cal_prog);
        this.pcal.setProgress(0);


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
        this.morgens = new String[][]{lebensmittel[0][0], lebensmittel[0][1]};


        cols = morgens.length - 1;
        rows = morgens[1].length - 1;
        table_layout_food.removeAllViews();
        BuildTableNutrition(rows, cols, "2", morgens);
        /**
         for (int i = 0; i < lebensmittel.length - 1; i++) {
         String[][] food2 = new String[][]{lebensmittel[i][0], lebensmittel[i][1]};

         db = new DatabaseHandler(getActivity());
         for (int j = 0; j <= food2[0].length - 1; j++) {
         List<Food> ab = db.getFood(food2[0][j].toLowerCase());

         for (Food cn : ab) {
         prottotal = prottotal + cn.getProtein();
         fattotal = fattotal + cn.getFats();
         kcaltotal = kcaltotal + cn.get_kcal();
         carbtotal = carbtotal + cn.getCarbs();
         }
         }
         }*/

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

                        String[][] food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};

                        DatabaseHandler db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(food2[1][i]));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(food2[1][i]));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(food2[1][i]));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(food2[1][i]));
                            }

                        }


                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));

                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 1:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};

                        db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(food2[1][i]));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(food2[1][i]));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(food2[1][i]));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(food2[1][i]));
                            }
                            Log.d(fatref + "", "!!!!!!!!!!!!!!!");
                        }

                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));

                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 2:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};

                        db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(food2[1][i]));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(food2[1][i]));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(food2[1][i]));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(food2[1][i]));
                            }
                            Log.d(fatref + "", "!!!!!!!!!!!!!!!");
                        }

                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));

                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 3:
                        food = new String[][]{lebensmittel[anzahl + 1][0], lebensmittel[anzahl + 1][1]};
                        food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};

                        db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(food2[1][i]));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(food2[1][i]));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(food2[1][i]));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(food2[1][i]));
                            }
                            Log.d(fatref + "", "!!!!!!!!!!!!!!!");
                        }

                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));

                        table_layout_food.removeAllViews();
                        cols = food.length - 1;
                        rows = food[1].length - 1;
                        table_layout_food.removeAllViews();
                        BuildTableNutrition(rows, cols, "2", food);
                        break;
                    case 4:

                        food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};

                        db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(food2[1][i]));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(food2[1][i]));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(food2[1][i]));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(food2[1][i]));
                            }
                            Log.d(fatref + "", "!!!!!!!!!!!!!!!");
                        }

                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));


                        table_layout_food.removeAllViews();
                        RelativeLayout linearLayout = (RelativeLayout) getActivity().findViewById(R.id.rlt);

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
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);
        Button button1 = (Button) rootView.findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                SEARCHED_ITEM = inputSearch.getText().toString();
                SEARCHED_ITEM = SEARCHED_ITEM.replace(" ", "+");

                ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

                XMLParser parser = new XMLParser();
                String xml = parser.getXmlFromUrl(URL + "&q=" + SEARCHED_ITEM + API_KEY); // getting XML
                Document doc = parser.getDomElement(xml); // getting DOM element

                NodeList nl = doc.getElementsByTagName(KEY_SHORTITEM);

                if (nl != null && nl.getLength() > 0) {
                    // looping through all item nodes <item>
                    for (int i = 0; i < nl.getLength(); i++) {
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
                        Element e = (Element) nl.item(i);
                        // adding each child node to HashMap key => value
                        map.put(KEY_NAME, parser.getCharacterDataFromElement(e, KEY_NAME));
                        map.put(KEY_KJ, parser.getValue(e, KEY_KJ));
                        map.put(KEY_KCAL, parser.getValue(e, KEY_KCAL));
                        map.put(KEY_FAT, parser.getValue(e, KEY_FAT));
                        map.put(KEY_PROT, parser.getValue(e, KEY_PROT));
                        map.put(KEY_KH, parser.getValue(e, KEY_KH));
                        map.put(KEY_SUGAR, parser.getValue(e, KEY_SUGAR));
                        map.put(KEY_AMOUNT, parser.getValue(e, KEY_AMOUNT));


                        // adding HashList to ArrayList
                        menuItems.add(map);
                    }
                }

                // Adding menuItems to ListView
                ListAdapter adapter = new SimpleAdapter(getApplicationContext(), menuItems,
                        R.layout.listen_item,
                        new String[]{KEY_NAME, KEY_KJ, KEY_KCAL, KEY_FAT, KEY_PROT, KEY_KH, KEY_SUGAR, KEY_AMOUNT}, new int[]{
                        R.id.name, R.id.kj, R.id.kcal, R.id.fat_gram, R.id.protein_gram, R.id.kh_gram, R.id.sugar_gram, R.id.amount});

                setListAdapter(adapter);

                // selecting single ListView item
                ListView lv = getListView();


                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        // getting values from selected ListItem
                        String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
                        String kj = ((TextView) view.findViewById(R.id.kj)).getText().toString();
                        String kcal2 = ((TextView) view.findViewById(R.id.kcal)).getText().toString();
                        String fat_gram = ((TextView) view.findViewById(R.id.fat_gram)).getText().toString();
                        String protein_gram = ((TextView) view.findViewById(R.id.protein_gram)).getText().toString();
                        String kh_gram = ((TextView) view.findViewById(R.id.kh_gram)).getText().toString();
                        String sugar_gram = ((TextView) view.findViewById(R.id.sugar_gram)).getText().toString();
                        String amount = ((TextView) view.findViewById(R.id.amount)).getText().toString();

                     

                        String[][] food2 = new String[][]{lebensmittel[anzahl][0], lebensmittel[anzahl][1]};
                        DatabaseHandler db = new DatabaseHandler(getActivity());
                        for (int i = 0; i <= food2[0].length - 1; i++) {
                            List<Food> a = db.getFood(food2[0][i].toLowerCase());

                            for (Food cn : a) {
                                protref += ((cn.getProtein() / 100.0) * Integer.parseInt(protein_gram));
                                fatref += ((cn.getFats() / 100.0) * Integer.parseInt(fat_gram));
                                kcalref += ((cn.get_kcal() / 100.0) * Integer.parseInt(kcal2));
                                carbref += ((cn.getCarbs() / 100.0) * Integer.parseInt(kh_gram));
                            }

                        }


                        new Thread(new Task("fat", getPerc(fatref, fat))).start();
                        new Thread(new Task("protein", getPerc(protref, protein))).start();
                        new Thread(new Task("carb", getPerc(carbref, carbs))).start();
                        new Thread(new Task("kcal", getPerc(kcalref, kcal))).start();

                        fatview.setText(Math.round(100.0 * fatref) / 100.0 + "/" + Float.toString(fat));
                        protview.setText(Math.round(100.0 * protref) / 100.0 + "/" + Float.toString(protein));
                        carbview.setText(Math.round(100.0 * carbref) / 100.0 + "/" + Float.toString(carbs));
                        calview.setText(Math.round(100.0 * kcalref) / 100.0 + "/" + Float.toString(kcal));



                    }
                });
            }

        });
        return rootView;
    }

    private Context getApplicationContext() {
        return getActivity().getApplicationContext();
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
            for (int j = 0; j <= cols ; j++) {

                TextView tv = new TextView(getActivity());
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(a[j][i]);

                row.addView(tv);

            }
            if (vtable.equals("1")) {
                table_layout.addView(row);
            }
            if (vtable.equals("2")) {
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

        for (int i = 0; i <= food_amount_list[0].length; i++) {
            List<Food> x = db.getFood(food_amount_list[0][i]);
            for (Food fd : x) {
                kcal_db = fd.get_kcal();
            }
            durchschnitt.add(calculateKcal(kcal_db, Integer.parseInt(a[1][i])) * Integer.parseInt(food_amount_list[2][i]));
        }

        // Hier holen wir die kcal aus der datenbank und speichern diese in eine ArrayListe
        // indem wir die kcalorien mit der menge multiplizieren um den exacten kalorienwert zu ermitteln
        // z.B. 50g * 1.3 -> schokolade
        while (this.kcal <= calculateSumKcal(durchschnitt)) {

            if (zaehler == 0) {


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
                durchschnitt.set(max, Integer.parseInt(food_amount_list[2][index]) / 2);
                food_amount_list[2][index] = String.valueOf((Integer.parseInt(food_amount_list[2][index]) / 2));

                zaehler++;
            }

            if (this.kcal >= calculateSumKcal(durchschnitt)) {
                break;
            }
        }
        return food_amount_list;
    }


    public float getPerc(float anz, float total) {
        return ((anz * 100) / total);
    }


    class Task implements Runnable {
        String _viewart;
        float _perc;

        public Task(String viewart, float perc) {
            this._viewart = viewart;
            this._perc = perc;
        }

        @Override
        public void run() {
            if (this._viewart.equals("fat")) {
                for (int i = pfat.getProgress(); i <= _perc; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pfat.setProgress(value);
                }
            } else if (this._viewart.equals("protein")) {
                for (int i = pprot.getProgress(); i <= _perc; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pprot.setProgress(value);
                }
            } else if (this._viewart.equals("kcal")) {
                for (int i = pcal.getProgress(); i <= _perc; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pcal.setProgress(value);
                }
            } else if (this._viewart.equals("carb")) {
                for (int i = pcarb.getProgress(); i <= _perc; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pcarb.setProgress(value);
                }

            }
        }

    }
}




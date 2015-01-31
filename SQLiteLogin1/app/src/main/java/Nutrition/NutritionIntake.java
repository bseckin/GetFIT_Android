package Nutrition;


import android.util.Log;

/**
 * Created by Muhammed5 on 03.12.2014.
 */
public class NutritionIntake {
    private int _weight;
    private int _height;
    private int _age;



    private float fett;
    private float carbs;
    private float protein;
    private float gu;
    private double pal;
    private float bmi;
    private String _inten;

    public NutritionIntake(int weight, int height, int age, String inten){
        this._weight = weight;
        this._height = height;
        this._age = age;
        this._inten = inten;
        this.bmi = 0;
    }

    public void CalculateUmsatz(){
        if (this._inten.equals("gering")){
            this.pal = 1.2;
        } else if(this._inten.equals("mittel")){
            this.pal = 1.7;
        } else if(this._inten.equals("hoch")){
            this.pal = 2.3;
        }
    }
    public void CalculaeNutritions(String gender){
        Log.d(this._height + "!!!!!", "aaaaaaaaaaaaaaaaaaaaaaa");
        Log.d(this._weight + "!!!!!", "bbbbbbbbbbb");
        this.bmi = this._weight/((this._height/100)*(this._height/100));

        CalculateUmsatz();
        //Grundumsatz berechnen
        if (gender.equals("Maennlich")) {
            this.gu = (float) ((66.47 + (13.7 * this._weight) +
                                (5 * this._height) -
                                (6.8 * this._age)));
        } else if (gender.equals("Weiblich")){
            this.gu = (float) ((665.1 + (9.6 * this._weight) +
                                (1.8 * this._height) -
                                (4.7 * this._age))*this.pal);
        }

        //1.2 	    nur sitzend oder liegend 	gebrechliche Menschen
        //1.4-1.5 	sitzend, kaum körperliche Aktivität 	Büroarbeit am Schreibtisch
        //1.6-1.7 	sitzend, gehend und stehend 	Studenten, Schüler, Taxifahrer
        //1.8-1.9 	hauptsächlich stehend und gehend 	Verkäufer, Kellner, Handwerker
        //2.0-2.4 	körperlich anstrengende Arbeit 	Landwirte, Hochleistungssportler
        // man sollte 15% der energie als eiweiß, 30% als Fett und 55% als KOhlenhydrat zu sich nehemn
        this.fett = 60;
        this.protein = (float) (this.bmi*1.5);
        if (this.bmi <= 25){
            this.carbs = 90;
        }
        else if (this.bmi >= 30){
            this.carbs = 100;
        } else if (this.bmi <= 30){
            this.carbs = 125;
        }

    }

    //GETTER
    public float getFett() {
        return fett;
    }

    public float getCarbs() {
        return carbs;
    }

    public float getProtein() {
        return protein;
    }

    public float getGu() {
        return gu;
    }

    //SETTER
    public void setFett(float fett) {
        this.fett = fett;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public void setGu(float gu) {
        this.gu = gu;
    }
}

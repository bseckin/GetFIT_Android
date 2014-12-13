package Nutrition;


/**
 * Created by Muhammed5 on 03.12.2014.
 */
public class NutritionIntake {
    private float _weight;
    private int _height;
    private int _age;



    private float fett;
    private float carbs;
    private float protein;
    private float gu;

    public NutritionIntake(float weight, int height, int age){
        this._weight = weight;
        this._height = height;
        this._age = age;
    }

    public void CalculaeFat(){
        //Grundumsatz berechnen
        this.gu = (float) (66.47 + (13.7 * this._weight) +
                                (5*this._height)-
                                (6.8*this._age));

        // man sollte 15% der energie als eiweiß, 30% als Fett und 55% als KOhlenhydrat zu sich nehemn
        this.fett = (float) (gu * 0.15);
        this.protein = (float) (gu*0.3);
        this.carbs = (float) (gu*0.55);
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

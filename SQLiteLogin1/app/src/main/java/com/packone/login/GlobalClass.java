package com.packone.login;
import android.app.Application;
/**
 * Created by Berkay on 24.12.2014.
 */

public class GlobalClass extends Application{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

}
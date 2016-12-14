package com.example.krupal.roughestimantion;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Krupal on 12/3/2016.
 */

public class RoughModal {

        String NAME,CLARITY,SIZE,FLOROSENCE,CUT,CARATS,RATE,AMOUNT;

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getCARATS() {
        return CARATS;
    }

    public void setCARATS(String CARATS) {
        this.CARATS = CARATS;
    }

    public String getCLARITY() {
        return CLARITY;
    }

    public void setCLARITY(String CLARITY) {
        this.CLARITY = CLARITY;
    }

    public String getCUT() {
        return CUT;
    }

    public void setCUT(String CUT) {
        this.CUT = CUT;
    }

    public String getFLOROSENCE() {
        return FLOROSENCE;
    }

    public void setFLOROSENCE(String FLOROSENCE) {
        this.FLOROSENCE = FLOROSENCE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getRATE() {
        return RATE;
    }

    public void setRATE(String RATE) {
        this.RATE = RATE;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }
}


package com.example.elcodelab;

public class PersonReference {
    private String referenceName;
    private float rate;

    public PersonReference(String referenceName, float rate){
        this.referenceName = referenceName;
        this.rate = rate;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public float getRate() {
        return rate;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}

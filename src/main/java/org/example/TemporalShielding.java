package org.example;

public class TemporalShielding {

    private Double shieldStrength;
    private Double shieldFrequency;
    private Boolean shieldEnabled;

    public TemporalShielding(){
        shieldStrength = 100.0;
        shieldFrequency = 3.14;
        shieldEnabled = true;
    }

    public Double getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(Double newValue){
        shieldStrength = newValue;
    }

    public Double getFrequency() {
        return shieldFrequency;
    }

    public void setFrequency(Double newFrequency) {
        this.shieldFrequency = newFrequency;
    }

    public void toggleShield(){
        this.shieldEnabled = !this.shieldEnabled;
    }
}

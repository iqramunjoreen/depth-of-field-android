

public class ALens {
    private String make;
    private double maximumaperture;
    private double focallength;

    public ALens(String make, double maximumaperture, double focallength) {
        this.make = make;
        this.maximumaperture = maximumaperture;
        this.focallength = focallength;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getMaximumaperture() {
        return this.maximumaperture;
    }

    public void setMaximumaperture(double maximumaperture) {
        this.maximumaperture = maximumaperture;
    }

    public double getFocallength() {
        return this.focallength;
    }

    public void setFocallength(double focallength) {
        this.focallength = focallength;
    }

    public String toString() {
        return "ca.lensdemo.model.ALens{make='" + this.make + "', maximumaperture=" + this.maximumaperture + ", focallength=" + this.focallength + "}";
    }
}
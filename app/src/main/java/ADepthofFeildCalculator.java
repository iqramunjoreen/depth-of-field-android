



public class ADepthofFeildCalculator {
    private ALens lens;
    private double distanceofobject;
    private double currentaperture;
    public static final double circleofconfusion = 0.029D;

    public ADepthofFeildCalculator(ALens lens, double distanceofobject, double currentaperture) {
        this.lens = lens;
        this.distanceofobject = distanceofobject;
        this.currentaperture = currentaperture;
    }

    public ALens getLens() {
        return this.lens;
    }

    public void setLens(ALens lens) {
        this.lens = lens;
    }

    public double getDistanceofobject() {
        return this.distanceofobject;
    }

    public void setDistanceofobject(double distanceofobject) {
        this.distanceofobject = distanceofobject;
    }

    public double getCurrentaperture() {
        return this.currentaperture;
    }

    public void setCurrentaperture(double currentaperture) {
        this.currentaperture = currentaperture;
    }

    public static double getCircleofconfusion() {
        return 0.029D;
    }

    public double gethyperfocaldistance() {
        return Math.pow(this.lens.getFocallength(), 2.0D) / (this.currentaperture * 0.029D);
    }

    public double getnearfocalpoint() {
        return this.gethyperfocaldistance() * this.getDistanceofobject() / (this.gethyperfocaldistance() + (this.getDistanceofobject() - this.getLens().getFocallength()));
    }

    public double getfarfocalpoint() {
        double farfocalpoint = this.gethyperfocaldistance() * this.getDistanceofobject() / (this.gethyperfocaldistance() - (this.getDistanceofobject() - this.getLens().getFocallength()));
        if (this.getDistanceofobject() > this.gethyperfocaldistance()) {
            farfocalpoint = 1.0D / 0.0;
        }

        return farfocalpoint;
    }

    public double getdepthoffield() {
        double depthoffield = this.getfarfocalpoint() - this.getnearfocalpoint();
        return depthoffield;
    }
}

package pl.put.poznan.informer.logic;

public class Pomieszczenie extends Lokacja{
    private double area;
    private double cube;
    private double heating;
    private double light;

    public Pomieszczenie(int id, String nazwa) {
        super(id, nazwa);

    }
    public void setArea(double area){
        this.area = area;
    }
    public void setCube(double cube){
        this.cube = cube;
    }
    public void setLight(double light){
        this.light = light;
    }
    public void setHeating(double heating){
        this.heating = heating;
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }


    @Override
    public double getLight() {
        return light/area;
    }

    @Override
    public double getLightPower() {
        return light;
    }
    @Override
    public double getHeating() {
        return heating/cube;
    }

    @Override
    public double getHeatingPower() {
        return heating;
    }
}

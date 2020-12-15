package pl.put.poznan.transformer.logic;

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

    public void setHeating(double heating){
        this.heating = heating;
    }

    public void setLight(double light){
        this.light = light;
    }

    public double getArea() {
        return area;
    }

    public double getCube() { return cube; }

    public double getHeating() {
        return heating;
    }

    public double getLight() {
        return light;
    }
}
